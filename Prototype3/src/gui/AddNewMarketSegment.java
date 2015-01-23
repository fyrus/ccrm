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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.ChatClient;
import common.ChatIF;
import common.Com;
import common.Command;
import entities.Domain;
import entities.Location;
import entities.MarketSegment;
import entities.Permission;





import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Nastia
 *
 */
public class AddNewMarketSegment extends JPanel implements ChatIF {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChatClient client;

	public JButton btnCancel;
	private JTextField tfAge;
	private JComboBox<Location> cbLocation;
	private JComboBox<Domain> cbPermissionByDomain;

	/**
	 * Create the panel.
	 */
	public AddNewMarketSegment() {
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
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(38, 85, 37, 16);
		add(lblAge);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLocation.setBounds(38, 134, 70, 16);
		add(lblLocation);
		
		JLabel lblCustomerRank = new JLabel("Customer Importance Rank:");
		lblCustomerRank.setForeground(Color.WHITE);
		lblCustomerRank.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerRank.setBounds(38, 186, 199, 16);
		add(lblCustomerRank);
		
		JLabel lblCustomerInterestRank = new JLabel("Customer Interest Rank In Products:");
		lblCustomerInterestRank.setForeground(Color.WHITE);
		lblCustomerInterestRank.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerInterestRank.setBounds(38, 225, 269, 16);
		add(lblCustomerInterestRank);
		
		JLabel lblPermissionDomain = new JLabel("Permission Domain:");
		lblPermissionDomain.setForeground(Color.WHITE);
		lblPermissionDomain.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPermissionDomain.setBounds(38, 265, 194, 16);
		add(lblPermissionDomain);
		
		final JComboBox<String> cbImportance = new JComboBox<String>();
		cbImportance.setModel(new DefaultComboBoxModel<String>(new String[] {"rank", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cbImportance.setBounds(317, 184, 116, 22);
		add(cbImportance);
		
		final JComboBox<String> cbInterest = new JComboBox<String>();
		cbInterest.setModel(new DefaultComboBoxModel<String>(new String[] {"rank", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cbInterest.setBounds(317, 219, 116, 22);
		add(cbInterest);
		
		tfAge = new JTextField();
		tfAge.setBounds(317, 83, 116, 22);
		add(tfAge);
		tfAge.setColumns(10);
		
		JLabel lblAddNewMarket = new JLabel("Add New Market Segment");
		lblAddNewMarket.setForeground(Color.PINK);
		lblAddNewMarket.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewMarket.setBounds(12, 13, 225, 17);
		add(lblAddNewMarket);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(91, 347, 188, 36);
		add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cbImportance.getSelectedIndex() == 0 ||
					cbInterest.getSelectedIndex() == 0 ||
					(Integer.parseInt(tfAge.getText())<0 || Integer.parseInt(tfAge.getText())>100 ))
				{
					JOptionPane.showMessageDialog(null, "Error! Please fill mandatory fields.");
				}
				else 
				{
				Command cmd = new Command();
				
				MarketSegment marketSegment = new MarketSegment();
				
				marketSegment.setAge(Integer.parseInt(tfAge.getText()));
				marketSegment.setImportance(Integer.parseInt((String) cbImportance.getSelectedItem()));
				marketSegment.setInterest(Integer.parseInt((String) cbInterest.getSelectedItem()));
				marketSegment.setLocation(((Location)cbLocation.getSelectedItem()).getLid());
			//	marketSegment.AddPermission(((Permission)cbPermissions.getSelectedItem()));
				
				//cmd.setComVal(marketSegment);
				//cmd.setComNum(Com.ADD_MARKETSEGMENT);

				//client.handleMessageFromClientUI(cmd);

				JOptionPane.showMessageDialog(null, "Market Segment was successfully created");
				cbImportance.setSelectedIndex(0);
				cbInterest.setSelectedIndex(0);
				tfAge.setText("");
				LoadData();
				}
				
			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(332, 347, 188, 36);
		add(btnAdd);
		
		cbLocation = new JComboBox<Location>();
		cbLocation.setBounds(317, 132, 116, 22);
		add(cbLocation);
		
		cbPermissionByDomain = new JComboBox<Domain>();
		cbPermissionByDomain.setBounds(317, 263, 116, 22);
		add(cbPermissionByDomain);
		
		
		
		

	}

	private void LoadData(){
		

				cbLocation.removeAllItems();
				cbPermissionByDomain.removeAllItems();
				

				Command cmd = new Command();

				Location location = new Location();
				cmd.setComVal(location);
				cmd.setComNum(Com.SEARCH_LOCATION);
				client.handleMessageFromClientUI(cmd);

				Domain domain = new Domain();
				cmd.setComVal(domain);
				cmd.setComNum(Com.SEARCH_DOMAIN);
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
				if(key instanceof Location){
					cbLocation.addItem(((Location)key));
				}
				if(key instanceof Domain){
					cbPermissionByDomain.addItem(((Domain)key));


				}

			}

		}
		
	}
}
