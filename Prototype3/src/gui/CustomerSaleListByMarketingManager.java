/**
 * 
 */
package gui;

import javax.swing.JPanel;

import client.ChatClient;
import common.ChatIF;
import common.Com;
import common.Command;

import javax.swing.JButton;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JList;

import entities.Domain;
import entities.Permission;
import entities.RegisteredCustomer;
import entities.User;
import javax.swing.JSeparator;

/**
 * @author Nastia
 *
 */
public class CustomerSaleListByMarketingManager extends JPanel implements ChatIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChatClient client;
	public JButton btnCancel;
	private JList listCampaignCustomers;
	private JList listSalesManList;
	private DefaultListModel listModel;
	private DefaultListModel listModelsm;
	
	

	/**
	 * Create the panel.
	 */
	public CustomerSaleListByMarketingManager() {
		setBackground(Color.GRAY);
		setSize(new Dimension(700, 480));
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				if (client==null) connect();
				LoadData();
				

				
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		

		
		setLayout(null);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(456, 385, 188, 36);
		add(btnCancel);
		
		JLabel lblCreateCustomerLists = new JLabel("Create Customer Lists For Sales Man");
		lblCreateCustomerLists.setForeground(Color.PINK);
		lblCreateCustomerLists.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCreateCustomerLists.setBounds(12, 13, 406, 25);
		add(lblCreateCustomerLists);
		
		JLabel lblCurrentSalesman = new JLabel("Current SalesMan");
		lblCurrentSalesman.setForeground(Color.WHITE);
		lblCurrentSalesman.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentSalesman.setBounds(80, 96, 135, 20);
		add(lblCurrentSalesman);
		
		
		
		listModel = new DefaultListModel();
		listCampaignCustomers = new JList(listModel);
		
		JScrollPane spCustomers = new JScrollPane();
		spCustomers.setViewportView(listCampaignCustomers);
		spCustomers.setBounds(312, 73, 332, 299);
		add(spCustomers);
		
		
		
		
		listModelsm = new DefaultListModel();
		listSalesManList = new JList(listModelsm);
		JScrollPane spSalesMan = new JScrollPane();
		spSalesMan.setViewportView(listSalesManList);
		spSalesMan.setBounds(80, 133, 159, 239);
		add(spSalesMan);
		

	
	}
	
	private void LoadData(){
		
		
		listModel.removeAllElements();
		listModelsm.removeAllElements();
		
		Command cmd = new Command();
		RegisteredCustomer registeredCustomer = new RegisteredCustomer();
		cmd.setComVal(registeredCustomer);
		cmd.setComNum(Com.SEARCH_REGISTEREDCUSTOMER);
		client.handleMessageFromClientUI(cmd);
		
		User user = new User();
		cmd.setComVal(user);
		cmd.setComNum(Com.SEARCH_USER);
		client.handleMessageFromClientUI(cmd);

	
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
	
	/* (non-Javadoc)
	 * @see common.ChatIF#display(java.lang.Object)
	 */
	@Override
	public void display(Object message) {
		// TODO Auto-generated method stub
		if (message instanceof ArrayList<?>) {
			for(Object key:((ArrayList<?>)message).toArray()){
				if(key instanceof RegisteredCustomer){
					RegisteredCustomer elem = ((RegisteredCustomer)key);
					listModel.addElement((elem+" "+elem.getcName()+" "+elem.getcLocation()+" "+elem.getcPhone()));
					
					
				
				}
				if(key instanceof User){
						
						User user = ((User)key);
						listModelsm.addElement(user.getRole().toString());
					
				}
				
			}
			

		}
		
	}
}
