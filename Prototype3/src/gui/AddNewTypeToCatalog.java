/**
 * 
 */
package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import common.ChatIF;
import common.Com;
import common.Command;
import client.ChatClient;
import entities.Domain;
import entities.Type;
import entities.User;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;

/**
 * This class creates a new type in a catalog.
 * @author Nastia
 *
 */
public class AddNewTypeToCatalog extends JPanel implements ChatIF{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tftpName;
	public JButton btnCancel;
	private JComboBox comboBox;
	private int domainLen;
	
	private Type type;
	private ChatClient client;
	private Command cmd;
	
	private ArrayList<Domain> domainList;
	/**
	 * @param tpName is the name type name
	 * @param iID is the type is
	 * Create the panel.
	 */
	public AddNewTypeToCatalog() {
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAddNewType = new JLabel("Add New Type To Catalog");
		lblAddNewType.setForeground(Color.PINK);
		lblAddNewType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewType.setBounds(12, 13, 232, 25);
		add(lblAddNewType);
		
		JLabel lblName = new JLabel("Type Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(201, 170, 126, 16);
		add(lblName);
		
		tftpName = new JTextField();
		tftpName.setBounds(337, 170, 172, 21);
		add(tftpName);
		tftpName.setColumns(10);
		
		btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tftpName.setText("");
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tftpName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Error! Type name is empty.","New Type",0);
					
					tftpName.setText("");
				}
				else
				{
					type=new Type();
					type.setTname(tftpName.getText());
					for(int i=0;i<domainLen;i++)
						if (domainList.get(i).getdName().equals(comboBox.getSelectedItem())) type.setDid(domainList.get(i).getDid());
					cmd=new Command(Com.ADD_TYPE,type);
					client.handleMessageFromClientUI(cmd);
					
					JOptionPane.showMessageDialog(null, "New type has been added to Database.","New Type",1);
					tftpName.setText("");
				}
			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);
		
		comboBox = new JComboBox();
		comboBox.setBounds(338, 110, 171, 25);
		add(comboBox);
		
		JLabel lblChooseDomain = new JLabel("Choose Domain:");
		lblChooseDomain.setForeground(Color.WHITE);
		lblChooseDomain.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseDomain.setBounds(181, 112, 126, 16);
		add(lblChooseDomain);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDomains();
			}
		});
		btnRefresh.setBounds(530, 111, 81, 23);
		add(btnRefresh);
		connect();
		loadDomains();
		
	}
	//send a request to server for all domains 
	private void loadDomains(){
		comboBox.removeAllItems();
		cmd=new Command(Com.SEARCH_DOMAIN,new Domain());
		System.out.println("addNewType");
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
@SuppressWarnings("unchecked")
@Override
public void display(Object message) {
	// TODO Auto-generated method stub
	if (message instanceof ArrayList<?>)
		if (((ArrayList<?>)message).get(0) instanceof Domain){
			domainList=new ArrayList<Domain>((ArrayList<Domain>)message);
			domainLen=domainList.size();
			for (int i=0;i<domainLen;i++)
				comboBox.addItem(domainList.get(i).getdName());
		}
			
}
}
