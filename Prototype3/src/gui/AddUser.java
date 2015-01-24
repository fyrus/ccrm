/**
 * 
 */
package gui;

import entities.Location;
import entities.User;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import client.ChatClient;
import common.ChatIF;
import common.Com;
import common.Command;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Nastia
 *
 */
public class AddUser extends JPanel implements ChatIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChatClient client;
	private JTextField tfPassword;
	private JTextField tfPhone;
	private JTextField tfName;
	private JComboBox<Location> cbLocation;
	private JComboBox<String> cbRole;


	/**
	 * Create the panel.
	 */
	public AddUser() {
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				if (client==null) connect();
				SetData();
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});

		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAddNewUser = new JLabel("Add User");
		lblAddNewUser.setForeground(Color.PINK);
		lblAddNewUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewUser.setBounds(12, 13, 94, 25);
		add(lblAddNewUser);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfName.getText().equals("") || tfPassword.getText().equals("") || tfPhone.getText().equals("") || cbRole.getSelectedIndex() == 0 )
				{
					JOptionPane.showMessageDialog(null, "Error! Fill all mandatory fields.","New User",0);	

				}
				else
				{
					String address = cbLocation.getSelectedItem().toString();
					Command cmd = new Command();
					
					User user = new User();
					user.setAddress(address);
					user.setLoggedin(false);
					user.setName(tfName.getText());
					user.setPassword(tfPassword.getText());
					user.setRole(cbRole.getSelectedItem().toString());
					user.setPhone(tfPhone.getText());
					
					cmd.setComVal(user);
					cmd.setComNum(Com.ADD_USER);

					client.handleMessageFromClientUI(cmd);
					JOptionPane.showMessageDialog(null, "New User has been added to Database.");
					cbRole.setSelectedIndex(0);
					SetData();
				}
				
			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);
		
		JLabel lblUserName = new JLabel("Name:");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBounds(74, 64, 61, 16);
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(74, 116, 95, 16);
		add(lblPassword);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLocation.setBounds(327, 170, 85, 16);
		add(lblLocation);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(74, 170, 61, 16);
		add(lblPhone);
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setForeground(Color.WHITE);
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRole.setBounds(342, 64, 61, 16);
		add(lblRole);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(155, 112, 160, 27);
		add(tfPassword);
		tfPassword.setColumns(10);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(155, 166, 160, 27);
		add(tfPhone);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(155, 60, 160, 27);
		add(tfName);
		
		cbRole = new JComboBox<String>();
		cbRole.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose Role", "Customer Relations", "Sales Man ", "Marketing Man", "Marketing Manager", "Admin"}));
		cbRole.setBounds(404, 60, 166, 29);
		add(cbRole);
		
		cbLocation = new JComboBox<Location>();
		cbLocation.setBounds(404, 164, 166, 29);
		add(cbLocation);
		
	}

	private void SetData()
	{
		cbLocation.removeAllItems();
		tfName.setText("");
		tfPassword.setText("");
		tfPhone.setText("");
		Command cmd = new Command();
		Location l = new Location();
		cmd.setComVal(l);
		cmd.setComNum(Com.SEARCH_LOCATION);
		
		client.handleMessageFromClientUI(cmd);
	}
	/**
	 * this is the server connect method //will do in every panel
	 */
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
			cbLocation.removeAllItems();
			for(Object key:((ArrayList<?>)message).toArray()){
				if(key instanceof Location){
					cbLocation.addItem(((Location)key));
				}
			}
			
		}

	}

}
