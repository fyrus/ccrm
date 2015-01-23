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
import javax.swing.JTextField;
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
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
	private ChatClient client;
	private JComboBox<Domain> cbDomainId;
	private JComboBox<RegisteredCustomer> cbRegisteredCustomerId;
	private JTextArea taSelectedCustomerDetails;
	private JScrollPane scrollPane;


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
				
				cbDomainId.removeAllItems();
				cbRegisteredCustomerId.removeAllItems();
				
				Command cmd = new Command();
				Permission p = new Permission();
				cmd.setComVal(p);
				cmd.setComNum(Com.SEARCH_PERMISSION);
				client.handleMessageFromClientUI(cmd);

				RegisteredCustomer rc = new RegisteredCustomer();
				cmd.setComVal(rc);
				cmd.setComNum(Com.SEARCH_REGISTEREDCUSTOMER);
				client.handleMessageFromClientUI(cmd);

				Domain domain = new Domain();
				cmd.setComVal(domain);
				cmd.setComNum(Com.SEARCH_DOMAIN);
				client.handleMessageFromClientUI(cmd);

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
		lblCustomerId.setBounds(98, 72, 167, 16);
		add(lblCustomerId);

		JLabel lblPermissionDomainId = new JLabel("Choose Domain For Permission:");
		lblPermissionDomainId.setForeground(Color.WHITE);
		lblPermissionDomainId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPermissionDomainId.setBounds(41, 251, 224, 16);
		add(lblPermissionDomainId);

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
				Permission p = new Permission();
				//p.setCid(cid);

				for(int i=0;i<domainLen;i++)
					if (domainList.get(i).getdName().equals(cbDomainId.getSelectedItem())) 
						p.setDid(domainList.get(i).getDid());

				for(int i=0;i<registeredCustomerLen;i++)
					if (registeredCustomerList.get(i).getcId().equals(cbRegisteredCustomerId.getSelectedItem())) 
					{
						p.setCid(Integer.parseInt(registeredCustomerList.get(i).getcId()));
					}





				//p.setPid(cbDomainId.getSelectedItem().);
				cmd.setComVal(p);
				cmd.setComNum(Com.ADD_PERMISSION);

				client.handleMessageFromClientUI(cmd);
				JOptionPane.showMessageDialog(null, "New Permission has been added to Database.");


			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);

		cbDomainId = new JComboBox<Domain>();
		cbDomainId.setBounds(286, 249, 179, 22);
		add(cbDomainId);

		cbRegisteredCustomerId = new JComboBox<RegisteredCustomer>();
		cbRegisteredCustomerId.setBounds(277, 70, 179, 22);
		add(cbRegisteredCustomerId);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 133, 238, 91);
		add(scrollPane);
		
		taSelectedCustomerDetails = new JTextArea();
		scrollPane.setViewportView(taSelectedCustomerDetails);


		connect();


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
					cbDomainId.addItem(((Domain)key));
				}
				if(key instanceof RegisteredCustomer){
					cbRegisteredCustomerId.addItem(((RegisteredCustomer)key));
					
					
				}

			}

		}
	}
}
