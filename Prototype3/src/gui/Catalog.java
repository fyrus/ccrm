/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import client.ChatClient;
import common.ChatIF;
import common.Com;
import common.Command;
import entities.Domain;
import entities.Product;
import entities.ProductType;
import entities.Type;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

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
	private DefaultListModel<Product> model;
	private JTextArea textArea;
	
	private JLabel lblChooseType;
	private JLabel lblName;
	private JLabel lblPrice;
	private JLabel lblProdprice;
	private JLabel lblDescription;
	private JLabel lblProductPicture;
	
	private ChatClient client;
	private Command cmd;
	
	private ArrayList<Domain> domainList;
	private int domainLen;
	private ArrayList<ProductType> ptList;
	private int ptLen;
	private Product product;
	private Type type;
	private Domain domain;
	private File f;
	
	final JLabel ImgLabel;
	/**
	 * Create the panel.
	 */
	public Catalog() {
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				if (client==null) connect();
				lblProdprice.setText("0.0");
				textArea.setText("");
				ImgLabel.setIcon(null);
				loadDomains();
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
		lblChooseDomain.setBounds(12, 83, 144, 16);
		add(lblChooseDomain);
		
		lblChooseType = new JLabel("Choose Type:");
		lblChooseType.setForeground(Color.WHITE);
		lblChooseType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseType.setBounds(384, 83, 144, 16);
		add(lblChooseType);
		
		btnBack = new JButton("Back");
		
		btnBack.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnBack.setBackground(new Color(230, 230, 250));
		btnBack.setBounds(477, 407, 188, 36);
		add(btnBack);
		
		domainComboBox = new JComboBox<Domain>();
		
		domainComboBox.setBounds(145, 81, 153, 25);
		add(domainComboBox);
		
		typeComboBox = new JComboBox<Type>();
		typeComboBox.setBounds(512, 81, 153, 25);
		add(typeComboBox);
		
		ImgLabel = new JLabel("");
		ImgLabel.setBackground(Color.WHITE);
		ImgLabel.setBounds(471, 191, 200, 200);
		add(ImgLabel);
		
		lblName = new JLabel("Product Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(39, 127, 110, 25);
		add(lblName);
		
		model = new DefaultListModel<Product>();
		list = new JList<Product>(model);
									
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(39, 156, 110, 222);
		add(list);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrice.setBounds(263, 155, 66, 25);
		add(lblPrice);
		
		lblProdprice = new JLabel("0.0");
		lblProdprice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProdprice.setBounds(326, 155, 90, 25);
		add(lblProdprice);
		
		lblDescription = new JLabel("Product Description:");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescription.setBounds(263, 213, 188, 25);
		add(lblDescription);
		
		textArea = new JTextArea();
		textArea.setBounds(263, 249, 165, 129);
		add(textArea);
		
		lblProductPicture = new JLabel("Product picture:");
		lblProductPicture.setForeground(Color.WHITE);
		lblProductPicture.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProductPicture.setBounds(492, 157, 153, 23);
		add(lblProductPicture);
		
		JButton button = new JButton("--->");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedValue()!=null){
					lblProdprice.setText(list.getSelectedValue().getPprice()+"");
					textArea.setText(list.getSelectedValue().getPdescription());
					
					f=new File(list.getSelectedValue().getPphoto());
					try {
						ImageIcon icon = new ImageIcon(ImageIO.read(f));
						Image img = icon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
						ImageIcon newIcon = new ImageIcon(img);
						ImgLabel.setIcon(newIcon);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("System error: could not get picture.");
						ImgLabel.setIcon(null);
						//e.printStackTrace();
					}
				
					
				}
			}
		});
		button.setBounds(164, 244, 66, 23);
		add(button);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(184, 224, 46, 14);
		add(lblInfo);
		
		
		
		
		domainComboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if ((Domain)domainComboBox.getSelectedItem()!=null){
		    		domain=(Domain)domainComboBox.getSelectedItem();
		    		model.clear();
		    		loadTypes();
		    	}
		        
		    }
		});
		typeComboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if ((Type)typeComboBox.getSelectedItem()!=null){
		    		type=(Type)typeComboBox.getSelectedItem();
		        
		    		findProducts();
		    		try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		loadProducts();
		    	}
		        
		    }
		});
		
	}
	private void loadDomains(){
		domainComboBox.removeAllItems();
		
		cmd=new Command(Com.SEARCH_DOMAIN,new Domain());
		client.handleMessageFromClientUI(cmd);
	}
	private void loadProducts(){
		model.clear();
		ptLen=ptList.size();
		for (int i=0;i<ptLen;i++){
			System.out.println(ptList.get(i).getProductid());
			product=new Product();
			product.setPid(ptList.get(i).getProductid());
			cmd=new Command(Com.SEARCH_PRODUCT,product);
			client.handleMessageFromClientUI(cmd);
		}
	}
	private void findProducts(){
		ptList=new ArrayList<ProductType>();
		ProductType pt=new ProductType();
		pt.setTypeid(type.getTid());
		cmd=new Command(Com.SEARCH_PRODUCTTYPE,pt);
		client.handleMessageFromClientUI(cmd);
	}
	
	private void loadTypes(){
		typeComboBox.removeAllItems();
		type=new Type();
		type.setDid(domain.getDid());
		cmd=new Command(Com.SEARCH_TYPE,type);
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
					model.addElement((Product)key);
					
				}
				if(key instanceof Domain){
					domainComboBox.addItem((Domain)key);
				}
				if(key instanceof ProductType){
					ptList.add((ProductType)key);
				}
			}
		
		}
	}
}

