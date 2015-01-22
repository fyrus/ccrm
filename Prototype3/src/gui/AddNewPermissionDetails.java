/**
 * 
 */
package gui;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import client.ChatClient;
import common.ChatIF;
import common.Com;
import common.Command;
import entities.Domain;
import entities.Location;
import entities.Permission;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;

/**
 * @author Nastia
 *
 */
public class AddNewPermissionDetails extends JPanel implements ChatIF{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfcID;
	private JTextField tfpID;
	public JButton btnCancel;
	public JButton btnAdd;
	private ChatClient client;
	private JComboBox cbDomainId;

	
	
	private int domainLen;
	private ArrayList<Domain> domainList;


	
	
	/**
	 * Create the panel.
	 */
	public AddNewPermissionDetails() {
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				Command cmd = new Command();
				Permission p = new Permission();
				cmd.setComVal(p);
				cmd.setComNum(Com.SEARCH_PERMISSION);
				
				client.handleMessageFromClientUI(cmd);
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		
		
		
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAddNewPermission = new JLabel("Add New Permission Details");
		lblAddNewPermission.setForeground(Color.PINK);
		lblAddNewPermission.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewPermission.setBounds(12, 13, 268, 16);
		add(lblAddNewPermission);
		
		JLabel lblId = new JLabel("Permission ID:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(84, 67, 167, 16);
		add(lblId);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerId.setBounds(84, 107, 167, 16);
		add(lblCustomerId);
		
		JLabel lblPermissionDomainId = new JLabel("Permission Domain ID:");
		lblPermissionDomainId.setForeground(Color.WHITE);
		lblPermissionDomainId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPermissionDomainId.setBounds(78, 151, 173, 16);
		add(lblPermissionDomainId);
		
		tfcID = new JTextField();
		tfcID.setBounds(263, 105, 179, 22);
		add(tfcID);
		tfcID.setColumns(10);
		
		tfpID = new JTextField();
		tfpID.setBounds(263, 65, 179, 22);
		add(tfpID);
		tfpID.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfcID.setText("");
				tfpID.setText("");
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Command cmd = new Command();
				Permission p = new Permission();
				p.setCid(cid);
				p.setDid(did);
				p.setPid(pid);
				cmd.setComVal(p);
				cmd.setComNum(Com.ADD_PERMISSION);

				client.handleMessageFromClientUI(cmd);
				JOptionPane.showMessageDialog(null, "New Permission has been added to Database.");
				
				
			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);
		
		cbDomainId = new JComboBox();
		cbDomainId.setBounds(263, 149, 179, 22);
		add(cbDomainId);
		
		
		connect();
		loadDomains();

	}

	
	private void loadDomains(){
		cbDomainId.removeAllItems();
		Command cmd=new Command(Com.SEARCH_DOMAIN,new Domain());
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
					cbDomainId.addItem(domainList.get(i).getdName());
				}
		}
	}
