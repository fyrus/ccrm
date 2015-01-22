package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import client.ChatClient;
import entities.*;
import common.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewDomain implements ChatIF{
	
	ChatClient client;

	private JFrame frmAddNewDomain;
	private JTextField textField;
	private JTextField txtf_domainName;

	//*********************************************************************************************
	//*********************************************************************************************
	//**     !!!!!!!!!!!!!!!!!!!!!!!!!!!!!NEED TO DELETE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!     **
	//*********************************************************************************************
	//*********************************************************************************************

	/**
	 * Create the application.
	 */
	public AddNewDomain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddNewDomain = new JFrame();
		frmAddNewDomain.setTitle("Add New Domain");
		frmAddNewDomain.setBounds(100, 100, 450, 300);
		frmAddNewDomain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddNewDomain.getContentPane().setLayout(null);
		
		JLabel lblAddNewDomain = new JLabel("Add New Domain");
		lblAddNewDomain.setBounds(151, 13, 132, 16);
		frmAddNewDomain.getContentPane().add(lblAddNewDomain);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(79, 86, 56, 16);
		frmAddNewDomain.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(79, 114, 56, 16);
		frmAddNewDomain.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(151, 83, 116, 22);
		frmAddNewDomain.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtf_domainName = new JTextField();
		txtf_domainName.setBounds(151, 111, 116, 22);
		frmAddNewDomain.getContentPane().add(txtf_domainName);
		txtf_domainName.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(74, 189, 97, 25);
		frmAddNewDomain.getContentPane().add(btnCancel);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command cmd = new Command();
				Domain dm = new Domain();
				dm.setdName(txtf_domainName.toString());
				
				cmd.setComVal(dm);
				cmd.setComNum(Com.ADD_DOMAIN);
				client.handleMessageFromClientUI(cmd);
			}
		});
		btnOk.setBounds(237, 189, 97, 25);
		frmAddNewDomain.getContentPane().add(btnOk);
	}

	/* (non-Javadoc)
	 * @see common.ChatIF#display(java.lang.String)
	 */
	@Override
	public void display(Object message) {
		// TODO Auto-generated method stub
		
	}

}
