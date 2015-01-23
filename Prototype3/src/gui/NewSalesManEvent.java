/**
 * 
 */
package gui;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import client.ChatClient;

import com.toedter.calendar.JDateChooser;

import common.ChatIF;
import common.Com;
import common.Command;
import entities.Domain;
import entities.Permission;
import entities.Product;
import entities.RegisteredCustomer;
import entities.Sale;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

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
	
	private ChatClient client;
	private JComboBox<RegisteredCustomer> cbCustomerId;
	private JComboBox<Product> cbProductName;
	
	private int productLen;
	private ArrayList<Product> productList;
	private int registeredCustomerLen;
	private ArrayList<RegisteredCustomer> registeredCustomerList;

	/**
	 * Create the panel.
	 */
	public NewSalesManEvent() {
		
		LoadData();
		
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
		lblCustomerId.setBounds(54, 60, 94, 16);
		add(lblCustomerId);
		
		JLabel lblProductIdl = new JLabel("Product ID:");
		lblProductIdl.setForeground(Color.WHITE);
		lblProductIdl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductIdl.setBounds(54, 111, 87, 16);
		add(lblProductIdl);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(54, 170, 94, 16);
		add(lblDate);
		
		final JDateChooser dcDate = new JDateChooser();
		dcDate.setBounds(189, 164, 116, 22);
		add(dcDate);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Command cmd = new Command();
				Sale sale = new Sale();

				for(int i=0;i<productLen;i++)
					if (productList.get(i).getPname().equals(cbProductName.getSelectedItem())) 
						sale.setItemid(productList.get(i).getPid());

				for(int i=0;i<registeredCustomerLen;i++)
					if (registeredCustomerList.get(i).getcId().equals(cbCustomerId.getSelectedItem())) 
						sale.setCustomerid(registeredCustomerList.get(i).getcId());
				sale.setSaleDate((java.sql.Date)(dcDate.getDate()));
				

				cmd.setComVal(sale);
				cmd.setComNum(Com.ADD_SALE);

				client.handleMessageFromClientUI(cmd);
				
				JOptionPane.showConfirmDialog(null, "Sale was added successfully");
				dcDate.setDate(null);
				LoadData();
			}
		});
		btnPurchase.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnPurchase.setBackground(new Color(230, 230, 250));
		btnPurchase.setBounds(452, 161, 188, 36);
		add(btnPurchase);
		
		final JLabel lblRejectionField = new JLabel("");
		lblRejectionField.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRejectionField.setForeground(Color.WHITE);
		lblRejectionField.setBounds(76, 218, 261, 113);
		add(lblRejectionField);
		
		btnRejection = new JButton("Rejection");
		btnRejection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = JOptionPane.showInputDialog("Please submit reason for rejection");
				lblRejectionField.setText("The Reason for rejection:"+s1);
				
			}
		});
		btnRejection.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnRejection.setBackground(new Color(230, 230, 250));
		btnRejection.setBounds(452, 51, 188, 36);
		add(btnRejection);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRejectionField.setText("");
				dcDate.setDate(null);
				
				
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(452, 293, 188, 36);
		add(btnCancel);
		
		cbCustomerId = new JComboBox<RegisteredCustomer>();
		cbCustomerId.setBounds(189, 58, 116, 22);
		add(cbCustomerId);
		
		cbProductName = new JComboBox<Product>();
		cbProductName.setBounds(189, 109, 116, 22);
		add(cbProductName);
		
		connect();
		

	}

	
	private void LoadData(){
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
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
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
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
