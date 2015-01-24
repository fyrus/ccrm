import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import dbconn.DbParametrs;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Alex
 *
 */


public class SereverGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4543337444175501583L;

	private JPanel contentPane;
	private JTextField tfPort;
	private JTextField tfIP;
	private JTextField tfUser;
	private JTextField tfPassword;
	private JTextField tfDbName;
	
	private EchoServer sv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SereverGui frame = new SereverGui();
					frame.setVisible(true);			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SereverGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ServerPort:");
		lblNewLabel.setBounds(29, 36, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data Base IP:");
		lblNewLabel_1.setBounds(29, 61, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User:");
		lblNewLabel_2.setBounds(29, 86, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(29, 111, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		tfPort = new JTextField();
		tfPort.setText("5555");
		tfPort.setBounds(139, 30, 120, 20);
		contentPane.add(tfPort);
		tfPort.setColumns(10);
		
		tfIP = new JTextField();
		tfIP.setText("localhost");
		tfIP.setBounds(139, 55, 120, 20);
		contentPane.add(tfIP);
		tfIP.setColumns(10);
		
		tfUser = new JTextField();
		tfUser.setText("root");
		tfUser.setBounds(139, 80, 120, 20);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setText("Braude");
		tfPassword.setBounds(139, 105, 120, 20);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
		
		JButton btnStart = new JButton("Start Server");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int port = 0; // Port to listen on
				
				DbParametrs dbp = new DbParametrs();
				DbParametrs.setDbName(tfDbName.getText());
				DbParametrs.setPassword(tfPassword.getText());
				DbParametrs.setPortNumber(3306);
				DbParametrs.setServerName(tfIP.getText());
				DbParametrs.setUserName(tfUser.getText());
				
				/** The name of the MySQL account to use (or empty for anonymous) */
				//private final static String userName = "root";

				/** The password for the MySQL account (or empty for anonymous) */
				//private final static String password = "Braude";

				/** The name of the computer running MySQL */
				//private final static String serverName = "localhost";

				/** The port of the MySQL server (default is 3306) */
				//private final static int portNumber = 3306;

				/** The name of the database we are testing with (this default is installed with MySQL) */
				//private final static String dbName = "ccrm_db";

				try {
					port = Integer.parseInt(tfPort.getText()); // Get port from command line
				} catch (Throwable t) {
					port = 5555; // Set port to 5555
				}

				sv = new EchoServer(port);

				try {
					sv.listen(); // Start listening for connections
				} catch (Exception ex) {
					System.out.println("ERROR - Could not listen for clients!");
					ex.printStackTrace();
				}
			}
		});
		btnStart.setBounds(29, 161, 110, 23);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop Server");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					sv.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnStop.setBounds(149, 161, 110, 23);
		contentPane.add(btnStop);
		
		JLabel lblNewLabel_4 = new JLabel("Data Base Name:");
		lblNewLabel_4.setBounds(29, 136, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		tfDbName = new JTextField();
		tfDbName.setText("ccrm_db");
		tfDbName.setBounds(139, 130, 120, 20);
		contentPane.add(tfDbName);
		tfDbName.setColumns(10);
	}
}
