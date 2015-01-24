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

import entities.Product;
import entities.ProductType;
import entities.Type;

/**
 * this is the Analytical System that manages the customer attributes
 * @author Dima
 *
 */
public class AnalyticalSystem extends JPanel implements ChatIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;
	
	
	
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
	public AnalyticalSystem() {
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				if (client==null) connect();
				
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAssignProductTo = new JLabel("Analytical System");
		lblAssignProductTo.setForeground(Color.PINK);
		lblAssignProductTo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAssignProductTo.setBounds(12, 13, 212, 25);
		add(lblAssignProductTo);
		
		JButton btnStartAnalyze = new JButton("Start Analyze");
		btnStartAnalyze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnStartAnalyze.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnStartAnalyze.setBackground(new Color(230, 230, 250));
		btnStartAnalyze.setBounds(243, 153, 188, 36);
		add(btnStartAnalyze);
		
		btnCancel = new JButton("Back");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(243, 299, 188, 36);
		add(btnCancel);
		
		

		
		
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
					
				}
				
			
			}
		
		}
	}
}
