/**
 * 
 */
package gui;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JOptionPane;

import java.io.IOException;

import client.ChatClient;
import common.*;
import entities.*;

import java.util.ArrayList;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

/**
 * @author Nastia
 *
 */

public class ManageLocations extends JPanel implements ChatIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;
	private ChatClient client;
	private JComboBox<Location> cbLocation;

	/**
	 * Create the panel.
	 */
	public ManageLocations() {
		
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

		setBackground(Color.GRAY);
		setSize(new Dimension(700, 480));
		setLayout(null);
		
		JLabel lblManageLocations = new JLabel("Manage Locations");
		lblManageLocations.setForeground(Color.PINK);
		lblManageLocations.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblManageLocations.setBounds(12, 13, 176, 25);
		add(lblManageLocations);
		
		JButton btnAddNewLocation = new JButton("Add New Location");
		btnAddNewLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String NewLocationName = JOptionPane.showInputDialog("Enter Location Name:");
				if(NewLocationName.equals(""))
					JOptionPane.showMessageDialog(null, "Error! you MUST enter location name.");
				else
				{
				Command cmd = new Command();
				Location l = new Location();
				l.setLocation(NewLocationName);
				cmd.setComVal(l);
				cmd.setComNum(Com.ADD_LOCATION);

				client.handleMessageFromClientUI(cmd);
				JOptionPane.showMessageDialog(null, "New Location has been added to Database.");
				SetData();
				}

				
			}
		});
		btnAddNewLocation.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAddNewLocation.setBackground(new Color(230, 230, 250));
		btnAddNewLocation.setBounds(50, 124, 188, 36);
		add(btnAddNewLocation);
		
		JButton btnDeleteLocation = new JButton("Delete Location");
		btnDeleteLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Command cmd = new Command();
				Location l = new Location();
				int dl = ((Location)cbLocation.getSelectedItem()).getLid();
				l.setLid(dl);
				
				cmd.setComVal(l);
				cmd.setComNum(Com.DELETE_LOCATION);

				client.handleMessageFromClientUI(cmd);
				JOptionPane.showMessageDialog(null, "Location "+((Location)cbLocation.getSelectedItem()).getLocation()+" has been Deleted from Database.");
				SetData();

				
			}
		});
		btnDeleteLocation.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnDeleteLocation.setBackground(new Color(230, 230, 250));
		btnDeleteLocation.setBounds(50, 215, 188, 36);
		add(btnDeleteLocation);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(50, 304, 188, 36);
		add(btnCancel);
		
		cbLocation = new JComboBox<Location>();
		cbLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbLocation.setForeground(Color.BLACK);
		cbLocation.setBounds(294, 124, 264, 50);
		add(cbLocation);
		
		JLabel lblCurrentExistingLocations = new JLabel("Current Existing Locations");
		lblCurrentExistingLocations.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentExistingLocations.setForeground(Color.WHITE);
		lblCurrentExistingLocations.setBounds(337, 95, 194, 16);
		add(lblCurrentExistingLocations);
		
		
		
	}
	private void SetData()
	{
		cbLocation.removeAllItems();
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
		System.out.println("System msg: got location in ManageLocation");
		//StringBuilder sb = new StringBuilder();
		if (message instanceof ArrayList<?>) {
			cbLocation.removeAllItems();
			for(Object key:((ArrayList<?>)message).toArray()){
				if(key instanceof Location){
					//sb.append(((Location)key).getLocation() + "\n");
					cbLocation.addItem(((Location)key));
				}
			}
			
		}
	}
}
