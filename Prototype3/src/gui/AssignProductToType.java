/**
 * 
 */
package gui;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import common.ChatIF;
import common.Com;
import common.Command;
import client.ChatClient;
import entities.Domain;
import entities.Permission;
import entities.Product;
import entities.RegisteredCustomer;
import entities.Type;

/**
 * @author Nastia
 *
 */
public class AssignProductToType extends JPanel implements ChatIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;
	
	private JComboBox<Product> prodComboBox;
	private JComboBox<Type> typeComboBox;
	
	private ChatClient client;
	private Command cmd;
	
	private ArrayList<Product> prodList;
	private int prodLen;
	private ArrayList<Type> typeList;
	private int typeLen;
	private Product product;
	private Type type;
	/**
	 * Create the panel.
	 */
	public AssignProductToType() {
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
				
				loadTypes();
				loadProducts();
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAssignProductTo = new JLabel("Assign Product To Type");
		lblAssignProductTo.setForeground(Color.PINK);
		lblAssignProductTo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAssignProductTo.setBounds(12, 13, 212, 25);
		add(lblAssignProductTo);
		
		JLabel lblChooseProducts = new JLabel("Choose Products:");
		lblChooseProducts.setForeground(Color.WHITE);
		lblChooseProducts.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseProducts.setBounds(133, 109, 144, 16);
		add(lblChooseProducts);
		
		JLabel lblChooseTypes = new JLabel("Choose Types:");
		lblChooseTypes.setForeground(Color.WHITE);
		lblChooseTypes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseTypes.setBounds(147, 186, 144, 16);
		add(lblChooseTypes);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAssign.setBackground(new Color(230, 230, 250));
		btnAssign.setBounds(103, 297, 188, 36);
		add(btnAssign);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);
		
		prodComboBox = new JComboBox<Product>();
		prodComboBox.setBounds(305, 107, 153, 25);
		add(prodComboBox);
		
		typeComboBox = new JComboBox<Type>();
		typeComboBox.setBounds(305, 184, 153, 25);
		add(typeComboBox);

		connect();
		
	}
	private void loadProducts(){
		prodComboBox.removeAllItems();
		cmd=new Command(Com.SEARCH_PRODUCT,new Product());
		client.handleMessageFromClientUI(cmd);
	}
	private void loadTypes(){
		typeComboBox.removeAllItems();
		cmd=new Command(Com.SEARCH_TYPE,new Type());
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
		if (message instanceof ArrayList<?>){
			for(Object key:((ArrayList<?>)message).toArray()){
				if(key instanceof Type){
					typeComboBox.addItem((Type)key);
				}
				if(key instanceof Product){
					prodComboBox.addItem((Product)key);
				}
			
			}
		
		}
	}
}
