/**
 * 
 */
package gui;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;



import client.ChatClient;

import com.toedter.calendar.JDateChooser;

import common.ChatIF;
import common.Com;
import common.Command;
import entities.Customer;
import entities.Product;
import entities.RegisteredCustomer;
import entities.Sale;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 * @author Nastia
 *
 */
public class NewSalesManEvent extends JPanel implements ChatIF{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;
	public JButton btnPurchase;
	public JButton btnRejection;
	private JDateChooser dcDate;

	private ChatClient client;
	private JComboBox<RegisteredCustomer> cbCustomerId;
	private JComboBox<Product> cbProductName;
	private JTextArea taCustomerDetails;

	/**
	 * Create the panel.
	 */
	public NewSalesManEvent() {
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

		

		setSize(new Dimension(700, 380));
		setBackground(Color.GRAY);
		setLayout(null);

		JLabel lblAddNewCustomer = new JLabel("New SalesMan Event");
		lblAddNewCustomer.setForeground(Color.PINK);
		lblAddNewCustomer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewCustomer.setBounds(12, 13, 201, 17);
		add(lblAddNewCustomer);

		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerId.setBounds(106, 60, 94, 16);
		add(lblCustomerId);

		JLabel lblProductIdl = new JLabel("Product ID:");
		lblProductIdl.setForeground(Color.WHITE);
		lblProductIdl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductIdl.setBounds(113, 246, 87, 16);
		add(lblProductIdl);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(119, 299, 94, 16);
		add(lblDate);

		dcDate = new JDateChooser();
		dcDate.setBounds(212, 293, 116, 22);
		add(dcDate);

		btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				InsertDataToDB(true,null);
				JOptionPane.showMessageDialog(null, "Sale was added successfully");
				LoadData();
			}
		});
		btnPurchase.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnPurchase.setBackground(new Color(230, 230, 250));
		btnPurchase.setBounds(452, 161, 188, 36);
		add(btnPurchase);

		btnRejection = new JButton("Rejection");
		btnRejection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s1 = JOptionPane.showInputDialog("Please submit reason for rejection");
				InsertDataToDB(false,s1);
				JOptionPane.showMessageDialog(null, "Rejection was added successfully");
				LoadData();

			}
		});
		btnRejection.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnRejection.setBackground(new Color(230, 230, 250));
		btnRejection.setBounds(452, 51, 188, 36);
		add(btnRejection);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dcDate.setDate(null);


			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(452, 293, 188, 36);
		add(btnCancel);

		cbCustomerId = new JComboBox<RegisteredCustomer>();
		cbCustomerId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				StringBuilder sb = new StringBuilder();
				sb.append("Selected Customer Details:"+"\n"+"\n"+"\n");
				sb.append("Customer Name:"+((RegisteredCustomer)cbCustomerId.getSelectedItem()).getcName()+"\n");
				sb.append("Birth Date:"+((RegisteredCustomer)cbCustomerId.getSelectedItem()).getcBirthDate().toString()+"\n"+"\n");
				sb.append("Location:"+((RegisteredCustomer)cbCustomerId.getSelectedItem()).getcLocation()+"\n");
				sb.append("Phone Number:"+((RegisteredCustomer)cbCustomerId.getSelectedItem()).getcPhone()+"\n"+"\n");
				
				taCustomerDetails.setText(sb.toString());
				
			}
		});
		cbCustomerId.setBounds(212, 58, 116, 22);
		add(cbCustomerId);

		cbProductName = new JComboBox<Product>();
		cbProductName.setBounds(212, 244, 116, 22);
		add(cbProductName);
		
		taCustomerDetails = new JTextArea();
		taCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		taCustomerDetails.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		taCustomerDetails.setBackground(Color.LIGHT_GRAY);
		taCustomerDetails.setBounds(36, 89, 167, 137);
		add(taCustomerDetails);

		


	}

	private void InsertDataToDB(boolean isPurchase, String rejectionTxt){

		Command cmd = new Command();
		Sale sale = new Sale();

		sale.setItemid(((Product)cbProductName.getSelectedItem()).getPid());//set product id 
		sale.setCustomerid(((Customer)cbCustomerId.getSelectedItem()).getcId());//set customer id
		sale.setSaleDate(new Date(dcDate.getDate().getTime()));//set sale's date
		sale.setBuy(isPurchase);//

		if(!isPurchase)
			sale.setComments(rejectionTxt);//set rejection comment 

		cmd.setComVal(sale);
		cmd.setComNum(Com.ADD_SALE);

		client.handleMessageFromClientUI(cmd);

		dcDate.setDate(null);


	}

	private void LoadData(){
		

				cbCustomerId.removeAllItems();
				cbProductName.removeAllItems();

				Command cmd = new Command();

				Sale sale = new Sale();
				cmd.setComVal(sale);
				cmd.setComNum(Com.SEARCH_SALE);
				client.handleMessageFromClientUI(cmd);

				Product product = new Product();
				cmd.setComVal(product);
				cmd.setComNum(Com.SEARCH_PRODUCT);
				client.handleMessageFromClientUI(cmd);

				RegisteredCustomer registeredCustomer = new RegisteredCustomer();
				cmd.setComVal(registeredCustomer);
				cmd.setComNum(Com.SEARCH_REGISTEREDCUSTOMER);
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
				if(key instanceof Product){
					cbProductName.addItem(((Product)key));
				}
				if(key instanceof RegisteredCustomer){
					cbCustomerId.addItem(((RegisteredCustomer)key));


				}

			}

		}

	}
}
