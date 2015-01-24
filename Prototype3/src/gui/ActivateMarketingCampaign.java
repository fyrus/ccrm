/**
 * 
 */
package gui;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import client.ChatClient;

import com.toedter.calendar.JDateChooser;

import common.ChatIF;
import common.Com;
import common.Command;
import entities.MarketingPatern;
import entities.MarketingCampaign;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JComboBox;

/**
 * @author Nastia
 *
 */
public class ActivateMarketingCampaign extends JPanel implements ChatIF{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;
	public JButton btnCreateCustomerLists;
	private JDateChooser dcStartDate;
	private JDateChooser dcEndDate;
	private JComboBox<MarketingPatern> cbPatern;

	/**
	 * Create the panel.
	 */
	private ChatClient client;	

	public ActivateMarketingCampaign() {
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
		setLayout(null);
		setBackground(Color.GRAY);

		JLabel lblActivateMarketingCampaign = new JLabel("Activate Marketing Campaign");
		lblActivateMarketingCampaign.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblActivateMarketingCampaign.setForeground(Color.PINK);
		lblActivateMarketingCampaign.setBounds(12, 13, 253, 25);
		add(lblActivateMarketingCampaign);

		JLabel lblMarketingPatternId = new JLabel("Choose Marketing Pattern:");
		lblMarketingPatternId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarketingPatternId.setForeground(Color.WHITE);
		lblMarketingPatternId.setBounds(55, 86, 265, 20);
		add(lblMarketingPatternId);

		JLabel lblStartDate = new JLabel("Marketing Campaign Start Date:");
		lblStartDate.setForeground(Color.WHITE);
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStartDate.setBounds(55, 143, 233, 25);
		add(lblStartDate);

		JLabel lblEndDate = new JLabel("Marketing Campaign End Date:");
		lblEndDate.setForeground(Color.WHITE);
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndDate.setBounds(55, 203, 220, 25);
		add(lblEndDate);

		dcStartDate = new JDateChooser(new Date());
		dcStartDate.setBounds(332, 146, 145, 22);
		add(dcStartDate);

		dcEndDate = new JDateChooser(new Date());
		dcEndDate.setBounds(332, 203, 145, 22);
		add(dcEndDate);

		JButton btnActivate = new JButton("Activate");
		btnActivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dcEndDate.getDate().before(dcStartDate.getDate()))
					JOptionPane.showMessageDialog(null, "Error! End date cannot be before Start date.","Activation",0);
				else
				{
					Command cmd = new Command();

					MarketingCampaign marketingCampaign = new MarketingCampaign();

					marketingCampaign.setStartdate(new java.sql.Date(dcStartDate.getDate().getTime()));
					marketingCampaign.setEnddate(new java.sql.Date(dcEndDate.getDate().getTime()));
					marketingCampaign.setPaternid(((MarketingPatern)cbPatern.getSelectedItem()).getPaternid());

					cmd.setComVal(marketingCampaign);
					cmd.setComNum(Com.ADD_MARKETINGCAMPAIGN);
					client.handleMessageFromClientUI(cmd);

					JOptionPane.showMessageDialog(null, "Marketing Campaign was successfully created");

					LoadData();
				}

			}
		});
		btnActivate.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnActivate.setBackground(new Color(230, 230, 250));
		btnActivate.setBounds(102, 263, 188, 36);
		add(btnActivate);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dcStartDate.setDate(null);
				dcEndDate.setDate(null);


			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(364, 263, 188, 36);
		add(btnCancel);


		btnCreateCustomerLists = new JButton("Create Customer Lists For SalesMans");
		btnCreateCustomerLists.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCreateCustomerLists.setBackground(new Color(230, 230, 250));
		btnCreateCustomerLists.setBounds(203, 329, 244, 36);
		add(btnCreateCustomerLists);

		cbPatern = new JComboBox<MarketingPatern>();
		cbPatern.setBounds(332, 86, 145, 22);
		add(cbPatern);





	}


	private void LoadData(){


		cbPatern.removeAllItems();
		dcStartDate.setDate(new Date());
		dcEndDate.setDate(new Date());

		Command cmd = new Command();
		MarketingPatern marketingPatern = new MarketingPatern();
		cmd.setComVal(marketingPatern);
		cmd.setComNum(Com.SEARCH_MARKETINGPATERN);
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
		System.out.println("System msg: got Marketing Pattern in marketing patterns");
		if (message instanceof ArrayList<?>)
			if (message instanceof ArrayList<?>) {
				cbPatern.removeAllItems();
				for(Object key:((ArrayList<?>)message).toArray()){
					if(key instanceof MarketingPatern){
						cbPatern.addItem(((MarketingPatern)key));
					}
				}

			}
	}
}

