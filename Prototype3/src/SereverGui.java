import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 225, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ServerPort:");
		lblNewLabel.setBounds(29, 36, 62, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data Base IP:");
		lblNewLabel_1.setBounds(29, 67, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User:");
		lblNewLabel_2.setBounds(29, 98, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(29, 123, 62, 14);
		contentPane.add(lblNewLabel_3);
		
		tfPort = new JTextField();
		tfPort.setText("5555");
		tfPort.setBounds(100, 33, 86, 20);
		contentPane.add(tfPort);
		tfPort.setColumns(10);
		
		tfIP = new JTextField();
		tfIP.setText("localhost");
		tfIP.setBounds(100, 64, 86, 20);
		contentPane.add(tfIP);
		tfIP.setColumns(10);
		
		tfUser = new JTextField();
		tfUser.setText("root");
		tfUser.setBounds(100, 95, 86, 20);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setText("Braude");
		tfPassword.setBounds(100, 120, 86, 20);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
		
		JButton btnStart = new JButton("Start Server");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int port = 0; // Port to listen on

				try {
					port = Integer.parseInt(tfPort.getText()); // Get port from command line
				} catch (Throwable t) {
					port = 5555; // Set port to 5555
				}

				EchoServer sv = new EchoServer(port);

				try {
					sv.listen(); // Start listening for connections
				} catch (Exception ex) {
					System.out.println("ERROR - Could not listen for clients!");
					ex.printStackTrace();
				}
			}
		});
		btnStart.setBounds(10, 148, 91, 23);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop Server");
		btnStop.setBounds(110, 148, 89, 23);
		contentPane.add(btnStop);
	}
}
