/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.BoxLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.util.ArrayList;

import javax.swing.JTextArea;

import client.ChatClient;
import common.*;
import entities.*;

import java.awt.Component;

import javax.swing.JLabel;

import org.eclipse.wb.swing.FocusTraversalOnArray;
/**
 * @author Dima
 *
 */


public class Client extends JFrame{

	/**
	 * Default port to connect
	 */
	final public static int D_PORT = 5555;
	
	private static final long serialVersionUID = -4674412322048093368L;
	//private JFrame frame;
	private JPanel panel;
	private JTextField txtIpAddress;
	public String ipAddress;
	public Login login;
	public MainWindow mw;
	public User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.setSize(460, 300);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Client() {
		super();
		setTitle("CCRM");
		initialize();
		
		
		
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		panel = new JPanel();
		panel.setLayout(null);
		login=new Login();
		mw=new MainWindow();
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ipAddress=new String(txtIpAddress.getText());
				login.connect(ipAddress);
				setContentPane(login);
			}
		});
		btnConnect.setBounds(159, 155, 104, 38);
		panel.add(btnConnect);
		
		txtIpAddress = new JTextField();
		txtIpAddress.setText("localhost");
		txtIpAddress.setBounds(202, 54, 176, 23);
		panel.add(txtIpAddress);
		txtIpAddress.setColumns(10);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnConnect, txtIpAddress}));
		panel.setBounds(100, 100, 450, 300);
		this.setSize(451, 300);
		login.btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.lblPasswordIsIncorrect.setVisible(false);
				login.lblNoSuchUser.setVisible(false);
				//getting user from server
				boolean gotu;
				try {
					gotu=login.getUser();
				} catch (Exception e1) {
					gotu=false;
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//checking password
				if (gotu)
				{
				if (login.passOk())
				{
				mw.setDisplay();
				mw.setVisible(true);
				setVisible(false);
				}
				else login.lblPasswordIsIncorrect.setVisible(true);
				}
				else login.lblNoSuchUser.setVisible(true);
			}
		});
		mw.btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mw.setVisible(false);
				setVisible(true);
				Login.user=null;
			}
		});
		setContentPane(panel);
		
		JLabel lblIpAddressTo = new JLabel("IP address to connect:");
		lblIpAddressTo.setBounds(52, 58, 140, 14);
		panel.add(lblIpAddressTo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblEmployeePortal = new JLabel("Wellcome");
		lblEmployeePortal.setForeground(Color.PINK);
		lblEmployeePortal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblEmployeePortal.setBounds(12, 13, 138, 16);
		panel.add(lblEmployeePortal);
		panel.setBackground(Color.GRAY);
		
	}
}
