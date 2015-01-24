/**
 * 
 */
package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JTextField;

import client.ChatClient;

import com.toedter.calendar.JDateChooser;

import common.ChatIF;
import common.Com;
import common.Command;
import entities.Customer;
import entities.Location;
import entities.Product;
import entities.RegisteredCustomer;
import entities.Sale;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JComboBox;

/**
 * @author Nastia
 *
 */
public class AddNewPotentialCustomer extends JPanel implements ChatIF{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfcID;
	private JTextField tfcFName;
	private JTextField tfcLName;
	private JTextField tfcPhone;
	public JButton btnCancel;
	private RegisteredCustomer customer; 
	private JComboBox<Location> cbCustomerLocation;
	private ChatClient client;
	private Command cmd;
	
	/**
	 * Create the panel.
	 */
	public AddNewPotentialCustomer() {
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
		
		
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(55, 105, 46, 16);
		add(lblId);
		
		JLabel lblName = new JLabel("First Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(55, 157, 79, 16);
		add(lblName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(55, 205, 89, 16);
		add(lblLastName);
		
		JLabel lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setForeground(Color.WHITE);
		lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBirthDate.setBounds(342, 105, 79, 16);
		add(lblBirthDate);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLocation.setBounds(342, 157, 70, 16);
		add(lblLocation);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(342, 205, 89, 16);
		add(lblPhone);
		
		tfcID = new JTextField();
		tfcID.setColumns(10);
		tfcID.setBounds(156, 103, 142, 22);
		add(tfcID);
		
		tfcFName = new JTextField();
		tfcFName.setColumns(10);
		tfcFName.setBounds(156, 155, 142, 22);
		add(tfcFName);
		
		tfcLName = new JTextField();
		tfcLName.setColumns(10);
		tfcLName.setBounds(156, 203, 142, 22);
		add(tfcLName);
		
		tfcPhone = new JTextField();
		tfcPhone.setColumns(10);
		tfcPhone.setBounds(433, 203, 142, 22);
		add(tfcPhone);
		
		final JDateChooser tfcBD = new JDateChooser();
		tfcBD.setBounds(433, 105, 142, 22);
		add(tfcBD);
		
		JLabel lblAddNewPotential = new JLabel("Add New Potential Customer");
		lblAddNewPotential.setForeground(Color.PINK);
		lblAddNewPotential.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewPotential.setBounds(22, 13, 267, 25);
		add(lblAddNewPotential);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( tfcFName.getText().equals("") || tfcID.getText().equals("") ||
						tfcLName.getText().equals("") || tfcPhone.getText().equals("") || tfcBD.getDate().equals(null))
				{
					JOptionPane.showMessageDialog(null, "Error! Please fill ALL mandatory fields.","New Customer",0); // with "X" icon
					
				}
				else
				{
					customer=new RegisteredCustomer(tfcID.getText(),tfcFName.getText()+" "+tfcLName.getText(),new Date(tfcBD.getDate().getTime()),"",tfcPhone.getText());
					customer.setcLocation(((Location)cbCustomerLocation.getSelectedItem()).getLocation());
					cmd=new Command();
					cmd.setComNum(Com.ADD_REGISTEREDCUSTOMER);
					cmd.setComVal(customer);
					client.handleMessageFromClientUI(cmd);
					
					JOptionPane.showMessageDialog(null, "Customer added to Database.", "New Customer", 1);// with "!" icon
					LoadData();
					tfcBD.setDate(null);
					tfcFName.setText("");
					tfcID.setText("");
					tfcLName.setText("");
					tfcPhone.setText("");
				}
			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfcFName.setText("");
				tfcID.setText("");
				tfcLName.setText("");
				tfcPhone.setText("");
				tfcBD.setDate(null);
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);
		
		cbCustomerLocation = new JComboBox<Location>();
		cbCustomerLocation.setBounds(433, 155, 142, 22);
		add(cbCustomerLocation);
		
		
	}
	
	private void LoadData(){
		

				cbCustomerLocation.removeAllItems();

				Command cmd = new Command();

				Location location = new Location();
				cmd.setComVal(location);
				cmd.setComNum(Com.SEARCH_LOCATION);
				client.handleMessageFromClientUI(cmd);


			
	}
	
	/**
	 * this is the server connect method
	 */
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
				if(key instanceof Location){
					cbCustomerLocation.addItem(((Location)key));
				}

			}

		}
		
	}
}
