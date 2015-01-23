/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import client.ChatClient;
import common.*;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import controllers.*;
import entities.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Dima
 *
 */
public class Login extends JPanel implements ChatIF{

	/**
	 * Default port to connect
	 */
	public static final int D_PORT = 5555;
	
	private static final long serialVersionUID = -1310427259136359271L;
	
	public JTextField textFieldName;
	public JButton btnLogin;
	public JLabel lblNoSuchUser;
	public JLabel lblPasswordIsIncorrect;
	/**
	 * The IP address of the server
	 */
	public static String IP;
	/**
	 * the current user of system
	 */
	public static User user;
	
	private JPanel frame;
	private ChatClient client;
	private JTextField textField_1;
	private JLabel lblPassword;
	
	private Command cmd;
	
	
	
	
	

	/**
	 * Create the application.
	 */
	public Login() {
		super();
		setBackground(Color.GRAY);
		initialize();
		
	}
	/**
	 * connect to server
	 * @param ip IP address to connect
	 */
	public void connect(String ip){
		Login.IP=ip;
		try 
	    {
	      client= new ChatClient(IP,D_PORT,this);
	    } 
	    catch(IOException exception) 
	    {
	      System.out.println("Error: Can't setup connection!"
	                + " Terminating client.");
	      System.exit(1);
	    }
		System.out.println("System msg: Client connected successfully.");
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JPanel();
		frame.setBounds(100, 100, 700, 480);
		
		this.setSize(450, 300);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(157, 58, 215, 20);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 113, 215, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(54, 61, 93, 14);
		add(lblUsername);
		
		JLabel lblEmployeePortal = new JLabel("Wellcome");
		lblEmployeePortal.setForeground(Color.PINK);
		lblEmployeePortal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblEmployeePortal.setBounds(12, 13, 138, 16);
		add(lblEmployeePortal);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(55, 116, 81, 14);
		add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnLogin.setBounds(177, 180, 108, 33);
		add(btnLogin);
		
		lblPasswordIsIncorrect = new JLabel("Password is INCORRECT, try again...");
		lblPasswordIsIncorrect.setForeground(Color.RED);
		lblPasswordIsIncorrect.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPasswordIsIncorrect.setBounds(157, 144, 215, 25);
		lblPasswordIsIncorrect.setVisible(false);
		add(lblPasswordIsIncorrect);
		
		lblNoSuchUser = new JLabel("No such user found");
		lblNoSuchUser.setForeground(Color.RED);
		lblNoSuchUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNoSuchUser.setBounds(157, 82, 215, 20);
		lblNoSuchUser.setVisible(false);
		add(lblNoSuchUser);
		frame.setVisible(true);
		
	}
	/**
	 * Sends a request to server to find the user
	 * @throws Exception 
	 */
	public boolean getUser() throws Exception{
		
		user=null;
		User ut = new User();
		ut.setName(textFieldName.getText());
		
		cmd=new Command();
		cmd.setComNum(Com.SEARCH_USER);	//search methods need object
		cmd.setComVal(ut);;
		client.handleMessageFromClientUI(cmd);
		for (int i=0;i<5;i++){
		Thread.sleep(500);
		if (user!=null) return true;
		}
		return false;
	}
	/**
	 * checks if the user password is OK
	 * @return true if password is good
	 */
	public boolean passOk(){
		
		
		if (textField_1.getText().equals(user.getPassword())) return true;
		else return false;
		
		
	}

	

	/* (non-Javadoc)
	 * @see common.ChatIF#display(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void display(Object message) {
		// TODO Auto-generated method stub
		if (message instanceof ArrayList<?>)
			if (((ArrayList<?>)message).get(0) instanceof User)
				user=new User(((ArrayList<User>) message).get(0));
				
	}
}
