/**
 * 
 */
package gui;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStreamImpl;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import sun.security.action.OpenFileInputStreamAction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.border.LineBorder;

import common.ChatIF;
import common.Com;
import common.Command;
import client.ChatClient;
import entities.Domain;
import entities.Product;


/**
 * @author Nastia
 * 
 */
public class AddNewProductToCatalog extends JPanel implements ChatIF{
	
	private static final long serialVersionUID = 1L;
	private JTextField tfpName;
	private JTextField tfpPrice;
	private JTextPane tfapDescription;
	public JButton btnCancel;
	private boolean canInput;
	
	private Product product;
	private ChatClient client;
	private Command cmd;
	
	public JFileChooser fc;
	final JLabel ImgLabel;

	/**
	 * Create the panel.
	 * This constructs a panel for adding a new price.
	 * @param pName the name of the product
	 * @param pPrice the price of the product
	 * @param btnCancel the button that quits from this pannel
	 */
	
	
	public AddNewProductToCatalog() {
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAddNewProduct = new JLabel("Add New Product To Catalog");
		lblAddNewProduct.setForeground(Color.PINK);
		lblAddNewProduct.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewProduct.setBounds(12, 13, 288, 25);
		add(lblAddNewProduct);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(50, 114, 52, 16);
		add(lblName);
		
		JLabel lblDescription = new JLabel("Product Description");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(272, 85, 170, 16);
		add(lblDescription);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(50, 191, 46, 16);
		add(lblPrice);
		
		tfpName = new JTextField();
		tfpName.setBounds(123, 112, 116, 22);
		add(tfpName);
		tfpName.setColumns(10);
		
		tfpPrice = new JTextField();
		tfpPrice.setBounds(123, 189, 116, 22);
		add(tfpPrice);
		tfpPrice.setColumns(10);
		
		final JTextPane tfapDescription = new JTextPane();
		tfapDescription.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		tfapDescription.setBounds(272, 114, 188, 102);
		add(tfapDescription);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( tfapDescription.getText().equals("") ||tfpName.getText().equals("") ||
						tfpPrice.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null, "Error! Please fill ALL mandatory fields.","New Product",0);
					
				}
				else
				{
					canInput=true;
					float price=0;
					try
					{
						price=Float.parseFloat(tfpPrice.getText());
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Error! Incorrect input at price field","New Product",0);
						canInput=false;
					}
					if (canInput){
					product=new Product(0,tfpName.getText(),fc.getSelectedFile().getPath(),tfapDescription.getText(),price);
					cmd=new Command(Com.ADD_PRODUCT,product);
					client.handleMessageFromClientUI(cmd);
					
					
					JOptionPane.showMessageDialog(null, "New product has been added to Database.","New Product",1);
					tfpName.setText("");
					tfpPrice.setText("");
					tfapDescription.setText("");
					ImgLabel.setIcon(null);
					}
				}
			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);
		
		ImgLabel = new JLabel("");
		ImgLabel.setBounds(500, 114, 128, 128);
		add(ImgLabel);
		
		btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfpName.setText("");
				tfpPrice.setText("");
				tfapDescription.setText("");
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);
		
		
		
		
		final JButton btnBrowse = new JButton(" Browse Image");
		
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fc = new JFileChooser();
				
				fc.setCurrentDirectory(new java.io.File("D:/"));
				fc.setDialogTitle("Choose product image");
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if(fc.showOpenDialog(btnBrowse) == JFileChooser.APPROVE_OPTION)
				{
					try {
						BufferedImage img = ImageIO.read(fc.getSelectedFile());
					
						ImgLabel.setIcon(new ImageIcon(img));
						
					} catch (IOException e1) {
						JOptionPane.showConfirmDialog(null, "Image upload failed. Try again");
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnBrowse.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnBrowse.setBackground(new Color(230, 230, 250));
		btnBrowse.setBounds(500, 82, 116, 25);
		add(btnBrowse);
		
		connect();

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
		
	}
	
}
