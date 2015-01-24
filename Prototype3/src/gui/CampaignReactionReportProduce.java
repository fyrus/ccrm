/**
 * 
 */
package gui;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JLabel;

import java.awt.Font;

import client.ChatClient;

import com.toedter.calendar.JDateChooser;

import common.ChatIF;
import common.Com;
import common.Command;
import entities.Domain;
import entities.MarketingCampaign;
import entities.MarketingCustomer;
import entities.Product;
import entities.ProductType;
import entities.Sale;
import entities.Type;

import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 * @author Dima
 *
 */
public class CampaignReactionReportProduce extends JPanel implements ChatIF{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;
	
	private JComboBox<MarketingCampaign> campComboBox;
	private JLabel lblCustomernumber;
	private JLabel lblPhonetime;
	private JLabel lblSalesnumber;
	private DefaultListModel<String> model;
	
	private MarketingCampaign mCamp;
	private MarketingCustomer mCost;
	private Sale sale;
	private ArrayList<MarketingCustomer> mcList;
	private ArrayList<Sale> salesList;
	private int min;
	
	private ChatClient client;
	private Command cmd;
	/**
	 * Create the panel.
	 */
	public CampaignReactionReportProduce() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				if (client==null) connect();
				loadCamp();
				lblCustomernumber.setText("0");
				lblPhonetime.setText("0.0");
				lblSalesnumber.setText("0");
				model.clear();
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblCampaignReactionReport = new JLabel("Campaign Reaction Report Produce");
		lblCampaignReactionReport.setForeground(Color.PINK);
		lblCampaignReactionReport.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCampaignReactionReport.setBounds(12, 13, 315, 16);
		add(lblCampaignReactionReport);
		
		JLabel lblMarketingCampaignId = new JLabel("Marketing Campaign ID:");
		lblMarketingCampaignId.setForeground(Color.WHITE);
		lblMarketingCampaignId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarketingCampaignId.setBounds(112, 57, 179, 16);
		add(lblMarketingCampaignId);
		
		JButton btnPro = new JButton("Produce Report");
		
		btnPro.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnPro.setBackground(new Color(230, 230, 250));
		btnPro.setBounds(431, 55, 136, 24);
		add(btnPro);
		
		btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(52, 381, 188, 36);
		add(btnCancel);
		
		campComboBox = new JComboBox<MarketingCampaign>();
		campComboBox.setBounds(301, 57, 91, 20);
		add(campComboBox);
		
		JLabel lblNumberOfPotential = new JLabel("Number of potential customers:");
		lblNumberOfPotential.setForeground(Color.WHITE);
		lblNumberOfPotential.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberOfPotential.setBounds(52, 116, 239, 27);
		add(lblNumberOfPotential);
		
		lblCustomernumber = new JLabel("0");
		lblCustomernumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomernumber.setBounds(301, 121, 112, 16);
		add(lblCustomernumber);
		
		JLabel lblTimeSpendOn = new JLabel("Time spend on phone:");
		lblTimeSpendOn.setForeground(Color.WHITE);
		lblTimeSpendOn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTimeSpendOn.setBounds(52, 202, 179, 27);
		add(lblTimeSpendOn);
		
		lblPhonetime = new JLabel("0.0");
		lblPhonetime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhonetime.setBounds(225, 206, 83, 19);
		add(lblPhonetime);
		
		JLabel lblNumberOfSales = new JLabel("Number of sales events:");
		lblNumberOfSales.setForeground(Color.WHITE);
		lblNumberOfSales.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberOfSales.setBounds(52, 269, 179, 27);
		add(lblNumberOfSales);
		
		lblSalesnumber = new JLabel("0");
		lblSalesnumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalesnumber.setBounds(236, 271, 106, 22);
		add(lblSalesnumber);
		
		model = new DefaultListModel<String>();
		JList<String> list = new JList<String>(model);
		list.setBounds(433, 138, 200, 279);
		add(list);
		
		JLabel lblRejectionComments = new JLabel("Rejection comments");
		lblRejectionComments.setForeground(Color.WHITE);
		lblRejectionComments.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRejectionComments.setBounds(454, 116, 157, 16);
		add(lblRejectionComments);
		
		btnPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				model.clear();
				mcList=new ArrayList<MarketingCustomer>();
				salesList=new ArrayList<Sale>();
				min=0;
				
				mCamp=(MarketingCampaign)campComboBox.getSelectedItem();
				mCost=new MarketingCustomer();
				mCost.setCampaignid(mCamp.getCid());
				cmd=new Command(Com.SEARCH_MARKETINCUSTOMER,mCost);
				client.handleMessageFromClientUI(cmd);
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lblCustomernumber.setText(""+mcList.size());
				for(Object key:mcList.toArray()){
					sale=new Sale();
					sale.setCustomerid(((MarketingCustomer)key).getCustomerid());
					cmd=new Command(Com.SEARCH_SALE,sale);
					client.handleMessageFromClientUI(cmd);
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				lblSalesnumber.setText(""+salesList.size());
				for(Object key:salesList.toArray()){
					min+=((Sale)key).getCallTime();
					if (!((Sale)key).getBuy())
						model.addElement(((Sale)key).getComments());
					
				}
				lblPhonetime.setText(""+(double)min/60+" hours");
			}
		});

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
	
	private void loadCamp(){
		campComboBox.removeAll();
		cmd=new Command(Com.SEARCH_MARKETINGCAMPAIGN,new MarketingCampaign());
		client.handleMessageFromClientUI(cmd);
	}
	/* (non-Javadoc)
	 * @see common.ChatIF#display(java.lang.Object)
	 */
	@Override
	public void display(Object message) {
		// TODO Auto-generated method stub
		if (message instanceof ArrayList<?>){
			for(Object key:((ArrayList<?>)message).toArray()){
				if(key instanceof MarketingCampaign){
					campComboBox.addItem((MarketingCampaign)key);
				}
				if(key instanceof MarketingCustomer){
					mcList.add((MarketingCustomer)key);
				}
				if(key instanceof Sale){
					salesList.add((Sale)key);
				}
				
			}
		}
	}
}
