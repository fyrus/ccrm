/**
 * 
 */
package gui;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import client.ChatClient;
import common.ChatIF;
import common.Com;
import common.Command;
import entities.Domain;
import entities.Permission;
import entities.RegisteredCustomer;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;


/**
 * @author Nastia
 *
 */
public class AddNewPermissionDetails extends JPanel implements ChatIF{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;
	public JButton btnAdd;
	private JTextArea taCustomerDetails;
	private ChatClient client;
	private JComboBox<Domain> cbDomainName; //domain names in combo box
	private JComboBox<RegisteredCustomer> cbRegisteredCustomerId;//customer id's in combo box
	
	private int domainLen;
	private ArrayList<Domain> domainList;
	private int registeredCustomerLen;
	private ArrayList<RegisteredCustomer> registeredCustomerList;


	/**
	 * Create the panel.
	 */
	public AddNewPermissionDetails() {

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
		


		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);

		JLabel lblAddNewPermission = new JLabel("Add New Permission Details");
		lblAddNewPermission.setForeground(Color.PINK);
		lblAddNewPermission.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewPermission.setBounds(12, 13, 268, 16);
		add(lblAddNewPermission);

		JLabel lblCustomerId = new JLabel("Choose Customer ID:");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerId.setBounds(122, 118, 167, 16);
		add(lblCustomerId);

		JLabel lblPermissionDomainName = new JLabel("Choose Domain For Permission:");
		lblPermissionDomainName.setForeground(Color.WHITE);
		lblPermissionDomainName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPermissionDomainName.setBounds(65, 69, 224, 16);
		add(lblPermissionDomainName);
		
		cbDomainName = new JComboBox<Domain>();
		cbDomainName.setBounds(307, 67, 179, 22);
		add(cbDomainName);

		cbRegisteredCustomerId = new JComboBox<RegisteredCustomer>();
		cbRegisteredCustomerId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StringBuilder sb = new StringBuilder();
				RegisteredCustomer registeredCustomer = ((RegisteredCustomer)cbRegisteredCustomerId.getSelectedItem());
				if(registeredCustomer!=null){
				sb.append("Selected Customer Details:"+"\n"+"\n"+"\n");
				sb.append("Customer Name:"+registeredCustomer.getcName()+"\n");
				sb.append("Birth Date:"+registeredCustomer.getcBirthDate().toString()+"\n"+"\n");
				sb.append("Location:"+registeredCustomer.getcLocation()+"\n");
				sb.append("Phone Number:"+registeredCustomer.getcPhone()+"\n"+"\n");
				
				taCustomerDetails.setText(sb.toString());
				}
				
			
			}
			
		});
		cbRegisteredCustomerId.setBounds(307, 116, 179, 22);
		add(cbRegisteredCustomerId);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Command cmd = new Command();
				Permission permission = new Permission();

				permission.setDid(((Domain)cbDomainName.getSelectedItem()).getDid());
				permission.setCid(Integer.parseInt(((RegisteredCustomer)cbRegisteredCustomerId.getSelectedItem()).getcId()));

				cmd.setComVal(permission);
				cmd.setComNum(Com.ADD_PERMISSION);

				client.handleMessageFromClientUI(cmd);
				JOptionPane.showMessageDialog(null, "New Permission has been added to Database.");
				LoadData();
				


			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);
		
		taCustomerDetails = new JTextArea();
		taCustomerDetails.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		taCustomerDetails.setBackground(new Color(192, 192, 192));
		taCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		taCustomerDetails.setBounds(113, 147, 167, 137);
		add(taCustomerDetails);


		


	}
	
	private void LoadData(){
		
				
				cbDomainName.removeAllItems();
				cbRegisteredCustomerId.removeAllItems();
				
				Command cmd = new Command();
				Permission permission = new Permission();
				cmd.setComVal(permission);
				cmd.setComNum(Com.SEARCH_PERMISSION);
				client.handleMessageFromClientUI(cmd);

				RegisteredCustomer registeredCustomer = new RegisteredCustomer();
				cmd.setComVal(registeredCustomer);
				cmd.setComNum(Com.SEARCH_REGISTEREDCUSTOMER);
				client.handleMessageFromClientUI(cmd);

				Domain domain = new Domain();
				cmd.setComVal(domain);
				cmd.setComNum(Com.SEARCH_DOMAIN);
				client.handleMessageFromClientUI(cmd);

			
	}




	// make a connection to server
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
				if(key instanceof Domain){
					//insert domains to comboBox
					cbDomainName.addItem(((Domain)key));
					System.out.println("got domain in add new permit");
				}
				if(key instanceof RegisteredCustomer){
					//insert customer id's to comboBox
					cbRegisteredCustomerId.addItem(((RegisteredCustomer)key));
					
					
				}

			}

		}
	}
}
