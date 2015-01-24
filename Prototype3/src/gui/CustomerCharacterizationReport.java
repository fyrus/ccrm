/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import client.ChatClient;
import common.ChatIF;
import common.Com;
import common.Command;
import entities.CustomerAttributes;
import entities.Domain;
import entities.MarketingCampaign;
import entities.RegisteredCustomer;

import javax.swing.JList;

/**
 * this is the Customer Characterization Report ui
 * @author Dima
 *
 */
public class CustomerCharacterizationReport extends JPanel implements ChatIF{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnBack;

	private RegisteredCustomer customer;
	private CustomerAttributes cAtt;
	private ArrayList<RegisteredCustomer> customerList;
	private ArrayList<CustomerAttributes> customerAttList;
	private DefaultListModel<CustomerAttributes> model;
	private JList<CustomerAttributes> list;
	
	private JLabel lblIdofcustomer;
	private JLabel lblPhoneofcustomer;
	
	private ChatClient client;
	private Command cmd;
	
	/**
	 * Create the panel.
	 */
	public CustomerCharacterizationReport() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				if (client==null) connect();
				model.clear();
				lblIdofcustomer.setText("");
				lblPhoneofcustomer.setText("");
				loadCostumers();
				
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAddNewDomain = new JLabel("Customer Characterization Report");
		lblAddNewDomain.setForeground(Color.PINK);
		lblAddNewDomain.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewDomain.setBounds(12, 13, 311, 25);
		add(lblAddNewDomain);
		
		btnBack = new JButton("Back");
		
		btnBack.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnBack.setBackground(new Color(230, 230, 250));
		btnBack.setBounds(448, 379, 188, 36);
		add(btnBack);
		
		model=new DefaultListModel<CustomerAttributes>();
		list = new JList<CustomerAttributes>(model);
		list.setBounds(39, 57, 200, 358);
		add(list);
		
		JButton btnShowDetails = new JButton("Show details");
		btnShowDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customer=new RegisteredCustomer();
				customer.setcId(list.getSelectedValue().getCustomerid());
				cmd=new Command(Com.SEARCH_REGISTEREDCUSTOMER,customer);
				client.handleMessageFromClientUI(cmd);
			}
		});
		btnShowDetails.setBounds(261, 218, 107, 23);
		add(btnShowDetails);
		
		JLabel lblCustomerId = new JLabel("Customer name:");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerId.setBounds(375, 57, 130, 25);
		add(lblCustomerId);
		
		JLabel lblCustomerPhone = new JLabel("Customer phone:");
		lblCustomerPhone.setForeground(Color.WHITE);
		lblCustomerPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerPhone.setBounds(375, 107, 136, 23);
		add(lblCustomerPhone);
		
		lblIdofcustomer = new JLabel("");
		lblIdofcustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdofcustomer.setBounds(521, 59, 114, 21);
		add(lblIdofcustomer);
		
		
		lblPhoneofcustomer = new JLabel("");
		lblPhoneofcustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhoneofcustomer.setBounds(521, 108, 136, 20);
		add(lblPhoneofcustomer);

		
	}
	
	private void connect(){
		
		try 
	    {
	      client= new ChatClient(Login.IP,Login.D_PORT,this);
	    } 
	    catch(IOException exception) 
	    {
	      System.out.println("Error: Can't setup connection!"
	                + " Terminating client.");
	      System.exit(1);
	    }
		
	}
	
	private void loadCostumers(){
		cmd=new Command(Com.SEARCH_CUSTOMERATTRIBUTES,new CustomerAttributes());
		client.handleMessageFromClientUI(cmd);
	}

/* (non-Javadoc)
 * @see common.ChatIF#display(java.lang.Object)
 */
@Override
	public void display(Object message) {
	// TODO Auto-generated method stub
		if (message instanceof ArrayList<?>){
			for(Object key:((ArrayList<?>)message).toArray()){
				if(key instanceof CustomerAttributes){
					model.addElement((CustomerAttributes)key);
				}
				if(key instanceof RegisteredCustomer){
					lblIdofcustomer.setText(((RegisteredCustomer)key).getcName());
					lblPhoneofcustomer.setText(((RegisteredCustomer)key).getcPhone());
				}
			}
		}
	}
}
