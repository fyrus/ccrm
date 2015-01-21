/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

/**
 * @author Nastia
 *
 */
public class PotentialCustomerSalesList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PotentialCustomerSalesList frame = new PotentialCustomerSalesList();
					frame.setSize(700,480);
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
	public PotentialCustomerSalesList() {
		setTitle("Sales Customer List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 468);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerList = new JLabel("Customer List");
		lblCustomerList.setForeground(Color.PINK);
		lblCustomerList.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCustomerList.setBounds(12, 13, 176, 25);
		contentPane.add(lblCustomerList);
		
		JButton btnDownloadList = new JButton("Download List");
		btnDownloadList.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnDownloadList.setBackground(new Color(230, 230, 250));
		btnDownloadList.setBounds(119, 343, 188, 36);
		contentPane.add(btnDownloadList);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(326, 343, 188, 36);
		contentPane.add(btnCancel);
	}

}
