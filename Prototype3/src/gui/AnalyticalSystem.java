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
import entities.CustomerAttributes;
import entities.Product;
import entities.ProductType;
import entities.RegisteredCustomer;
import entities.Sale;
import entities.Type;

import javax.swing.JProgressBar;

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
	
	private JProgressBar progressBar;
	private JLabel lblDone;
	
	private RegisteredCustomer customer;
	private ArrayList<RegisteredCustomer> customerList;
	private int customerListLen;
	
	private Sale sale;
	private ArrayList<Sale> saleList;
	private int saleListLen;
	
	private CustomerAttributes ca;
	
	private ChatClient client;
	private Command cmd;
	
	
	
	
	
	
	/**
	 * Create the panel.
	 */
	public AnalyticalSystem() {
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				if (client==null) connect();
				progressBar.setValue(0);
				customer=new RegisteredCustomer();
				customerList=new ArrayList<RegisteredCustomer>();
				customerListLen=0;
				lblDone.setVisible(false);
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
				analyzeAll();
				
				
			}
		});
		btnStartAnalyze.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnStartAnalyze.setBackground(new Color(230, 230, 250));
		btnStartAnalyze.setBounds(243, 154, 188, 36);
		add(btnStartAnalyze);
		
		btnCancel = new JButton("Back");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(243, 299, 188, 36);
		add(btnCancel);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(112, 112, 461, 14);
		add(progressBar);
		
		lblDone = new JLabel("Done!");
		lblDone.setForeground(Color.WHITE);
		lblDone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDone.setBounds(312, 76, 73, 25);
		lblDone.setVisible(false);
		add(lblDone);
		
		

		
		
	}
	private void analyzeCustomer(RegisteredCustomer c){
		if (progressBar.getValue()<90)
			progressBar.setValue(progressBar.getValue()+2);
		saleList=new ArrayList<Sale>();
		sale=new Sale();
		sale.setCustomerid(c.getcId());
		ca=new CustomerAttributes();
		ca.setCustomerid(c.getcId());
		cmd=new Command(Com.SEARCH_SALE,sale);
		client.handleMessageFromClientUI(cmd);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (progressBar.getValue()<90)
			progressBar.setValue(progressBar.getValue()+2);
		saleListLen=saleList.size();
		if(saleListLen>10)
			ca.setImportance(10);
		else
			ca.setImportance(saleListLen);
		int intrest=0;
		for (int i=0;i<saleListLen;i++)
			if(saleList.get(i).getBuy())
				intrest++;
		if(intrest>10)
			ca.setInterest(10);
		else
			ca.setInterest(intrest);
		
		cmd=new Command(Com.DELETE_CUSTOMERATTRIBUTES,ca);
		client.handleMessageFromClientUI(cmd);
		if (progressBar.getValue()<90)
			progressBar.setValue(progressBar.getValue()+2);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (progressBar.getValue()<90)
			progressBar.setValue(progressBar.getValue()+2);
		cmd=new Command(Com.ADD_CUSTOMERATTRIBUTES,ca);
		client.handleMessageFromClientUI(cmd);
		if (progressBar.getValue()<90)
			progressBar.setValue(progressBar.getValue()+2);
	}
	private void analyzeAll(){
		cmd=new Command(Com.SEARCH_REGISTEREDCUSTOMER,new RegisteredCustomer());
		client.handleMessageFromClientUI(cmd);
		for (int i=0;i<10;i++){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (progressBar.getValue()<90)
				progressBar.setValue(progressBar.getValue()+2);
		}
		customerListLen=customerList.size();
		for (int i=0;i<customerListLen;i++){
			analyzeCustomer(customerList.get(i));
			
		}
		
		progressBar.setValue(100);
		lblDone.setVisible(true);
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
				if(key instanceof RegisteredCustomer){
					customerList.add((RegisteredCustomer)key);
				}
				if(key instanceof Sale){
					saleList.add((Sale)key);
				}
				
			
			}
		
		}
	}
}
