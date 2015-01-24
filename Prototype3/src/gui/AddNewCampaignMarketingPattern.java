/**
 * 
 */
package gui;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import client.ChatClient;
import common.ChatIF;
import common.Com;
import common.Command;
import entities.Domain;
import entities.Location;
import entities.MarketingPatern;
import entities.MarketingSegment;
import entities.Permission;
import entities.Product;

/**
 * @author Nastia
 *
 */
public class AddNewCampaignMarketingPattern extends JPanel implements ChatIF {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChatClient client;

	
	public JButton btnCancel;
	private JComboBox<Product> cbProductId;
	private JComboBox<MarketingSegment> cbMarketSegmentId;
	private JTextPane tfamsgToCustomer;

	/**
	 * Create the panel.
	 */
	public AddNewCampaignMarketingPattern() {
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
		
		JLabel lblAddNewCampaign = new JLabel("Add New Campaign Marketing Pattern");
		lblAddNewCampaign.setForeground(Color.PINK);
		lblAddNewCampaign.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewCampaign.setBounds(12, 13, 345, 25);
		add(lblAddNewCampaign);
		
		JLabel lblProduct = new JLabel("Product ID:");
		lblProduct.setForeground(Color.WHITE);
		lblProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduct.setBounds(35, 87, 105, 16);
		add(lblProduct);
		
		JLabel lblMarketSegment = new JLabel("Market Segment ID:");
		lblMarketSegment.setForeground(Color.WHITE);
		lblMarketSegment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarketSegment.setBounds(35, 158, 149, 16);
		add(lblMarketSegment);
		
		JLabel lblMessageToCustomer = new JLabel("Message To Customers");
		lblMessageToCustomer.setForeground(Color.WHITE);
		lblMessageToCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessageToCustomer.setBounds(392, 83, 187, 25);
		add(lblMessageToCustomer);
		
		tfamsgToCustomer = new JTextPane();
		tfamsgToCustomer.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		tfamsgToCustomer.setBounds(369, 121, 210, 139);
		add(tfamsgToCustomer);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfamsgToCustomer.setText("");
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfamsgToCustomer.getText().equals(""))
						
				{
					JOptionPane.showMessageDialog(null, "Error! Message to customer is empty.","New Pattern",0);
					
				}
				else{
					Command cmd = new Command();
					
					MarketingPatern marketingPatern = new MarketingPatern();
					
					marketingPatern.setMassageToCustomer(tfamsgToCustomer.getText());
					marketingPatern.setProductid(Integer.parseInt(cbProductId.getSelectedItem().toString()));
					marketingPatern.setSegmentid((cbMarketSegmentId).getSelectedIndex());
					
					cmd.setComVal(marketingPatern);
					cmd.setComNum(Com.ADD_MARKETINGPATERN);
					client.handleMessageFromClientUI(cmd);

					JOptionPane.showMessageDialog(null, "Campaign Marketing Pattern was successfully created");
				
					
					LoadData();
				}
					
			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);
		
		cbProductId = new JComboBox<Product>();
		cbProductId.setBounds(184, 85, 144, 22);
		add(cbProductId);
		
		cbMarketSegmentId = new JComboBox<MarketingSegment>();
		cbMarketSegmentId.setBounds(184, 156, 144, 22);
		add(cbMarketSegmentId);

	}
	
	private void LoadData(){
		

		tfamsgToCustomer.setText("");
		cbMarketSegmentId.removeAllItems();
		cbProductId.removeAllItems();
		
		

		Command cmd = new Command();

		MarketingSegment marketingSegment = new MarketingSegment();
		cmd.setComVal(marketingSegment);
		cmd.setComNum(Com.SEARCH_MARKETSEGMENT);
		client.handleMessageFromClientUI(cmd);

		Product product = new Product();
		cmd.setComVal(product);
		cmd.setComNum(Com.SEARCH_PRODUCT);
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
					((Product) key).setStringby(1);
					cbProductId.addItem((Product)key);
				}
				if(key instanceof MarketingSegment){
					cbMarketSegmentId.addItem((MarketingSegment)key);
				}
				

			}

		}
		
	}
}
