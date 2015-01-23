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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import client.ChatClient;
import common.ChatIF;
import common.Com;
import common.Command;
import entities.Domain;
import entities.Product;
import entities.Type;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 * this is the catalog class
 * @author Dima
 *
 */
public class Catalog extends JPanel implements ChatIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnBack;
	
	private JComboBox<Domain> domainComboBox;
	private JComboBox<Type> typeComboBox;
	private JList<Product> list;
	private JTextArea textArea;
	
	private ChatClient client;
	private Command cmd;
	
	private ArrayList<Domain> domainList;
	private int domainLen;
	private ArrayList<Type> typeList;
	private int typeLen;
	private Product product;
	private Type type;
	
	final JLabel ImgLabel;
	/**
	 * Create the panel.
	 */
	public Catalog() {
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				if (client==null) connect();
				
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
		
		JLabel lblCatalog = new JLabel("Catalog");
		lblCatalog.setForeground(Color.PINK);
		lblCatalog.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCatalog.setBounds(12, 13, 212, 25);
		add(lblCatalog);
		
		JLabel lblChooseDomain = new JLabel("Choose Domain:");
		lblChooseDomain.setForeground(Color.WHITE);
		lblChooseDomain.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseDomain.setBounds(39, 83, 144, 16);
		add(lblChooseDomain);
		
		JLabel lblChooseType = new JLabel("Choose Type:");
		lblChooseType.setForeground(Color.WHITE);
		lblChooseType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseType.setBounds(384, 83, 144, 16);
		add(lblChooseType);
		
		btnBack = new JButton("Back");
		btnBack.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnBack.setBackground(new Color(230, 230, 250));
		btnBack.setBounds(471, 392, 188, 36);
		add(btnBack);
		
		domainComboBox = new JComboBox<Domain>();
		domainComboBox.setBounds(183, 81, 153, 25);
		add(domainComboBox);
		
		typeComboBox = new JComboBox<Type>();
		typeComboBox.setBounds(512, 81, 153, 25);
		add(typeComboBox);
		
		ImgLabel = new JLabel("");
		ImgLabel.setBackground(Color.WHITE);
		ImgLabel.setBounds(440, 191, 153, 143);
		add(ImgLabel);
		
		JLabel lblName = new JLabel("Product Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(39, 127, 110, 25);
		add(lblName);
		
		list = new JList<Product>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(39, 156, 110, 222);
		add(list);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrice.setBounds(183, 156, 66, 25);
		add(lblPrice);
		
		JLabel lblProdprice = new JLabel("0.0");
		lblProdprice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProdprice.setBounds(246, 156, 90, 25);
		add(lblProdprice);
		
		JLabel lblDescription = new JLabel("Product Description:");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescription.setBounds(183, 213, 188, 25);
		add(lblDescription);
		
		textArea = new JTextArea();
		textArea.setBounds(183, 249, 165, 129);
		add(textArea);
		
		JLabel lblProductPicture = new JLabel("Product picture:");
		lblProductPicture.setForeground(Color.WHITE);
		lblProductPicture.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProductPicture.setBounds(440, 157, 153, 23);
		add(lblProductPicture);

		
		
	}
	private void loadProducts(){
		domainComboBox.removeAllItems();
		
		cmd=new Command(Com.SEARCH_DOMAIN,new Domain());
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
					
				}
			
			}
		
		}
	}
}

