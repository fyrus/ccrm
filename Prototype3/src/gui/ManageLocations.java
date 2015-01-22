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
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

import client.ChatClient;
import common.*;
import entities.*;

import javax.swing.JTextArea;

import java.util.ArrayList;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextArea taLocation;
	private ChatClient client;

	/**
	 * Create the panel.
	 */
	public ManageLocations() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				Command cmd = new Command();
				Location l = new Location();
				cmd.setComVal(l);
				cmd.setComNum(Com.SEARCH_LOCATION);
				
				client.handleMessageFromClientUI(cmd);
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
				Command cmd = new Command();
				Location l = new Location();
				l.setLocation(NewLocationName);
				cmd.setComVal(l);
				cmd.setComNum(Com.ADD_LOCATION);

				client.handleMessageFromClientUI(cmd);
				JOptionPane.showMessageDialog(null, "New Location has been added to Database.");

				
			}
		});
		btnAddNewLocation.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAddNewLocation.setBackground(new Color(230, 230, 250));
		btnAddNewLocation.setBounds(50, 124, 188, 36);
		add(btnAddNewLocation);
		
		JButton btnDeleteLocation = new JButton("Delete Location");
		btnDeleteLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String LocationNameToDelete = JOptionPane.showInputDialog("Enter Location Name:");
				Command cmd = new Command();
				Location l = new Location();
				l.setLocation(LocationNameToDelete);
				
				cmd.setComVal(l);
				cmd.setComNum(Com.DELETE_LOCATION);

				client.handleMessageFromClientUI(cmd);
				JOptionPane.showMessageDialog(null, "Location"+LocationNameToDelete+" has been Deleted from Database.");
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 124, 312, 258);
		add(scrollPane);
		
		taLocation = new JTextArea();
		scrollPane.setViewportView(taLocation);
		
		connect();// make connection
		
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
		StringBuilder sb = new StringBuilder();
		if (message instanceof ArrayList<?>) {
			for(Object key:((ArrayList<?>)message).toArray()){
				if(key instanceof Location){
					sb.append(((Location)key).getLocation() + "\n");
				}
			}
			
			taLocation.setText(sb.toString());
		}
	}
}
