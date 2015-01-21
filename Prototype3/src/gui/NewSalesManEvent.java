/**
 * 
 */
package gui;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Nastia
 *
 */
public class NewSalesManEvent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfpID;
	private JTextField tfcstID;
	public JButton btnCancel;
	public JButton btnPurchase;
	public JButton btnRejection;

	/**
	 * Create the panel.
	 */
	public NewSalesManEvent() {
		setSize(new Dimension(700, 380));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAddNewCustomer = new JLabel("New SalesMan Event");
		lblAddNewCustomer.setForeground(Color.PINK);
		lblAddNewCustomer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewCustomer.setBounds(12, 13, 201, 17);
		add(lblAddNewCustomer);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerId.setBounds(54, 60, 94, 16);
		add(lblCustomerId);
		
		JLabel lblProductIdl = new JLabel("Product ID:");
		lblProductIdl.setForeground(Color.WHITE);
		lblProductIdl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductIdl.setBounds(54, 111, 87, 16);
		add(lblProductIdl);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(54, 170, 94, 16);
		add(lblDate);
		
	
		
		tfpID = new JTextField();
		tfpID.setBounds(189, 109, 116, 22);
		add(tfpID);
		tfpID.setColumns(10);
		
		final JDateChooser tfdate = new JDateChooser();
		tfdate.setBounds(189, 164, 116, 22);
		add(tfdate);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnPurchase.setBackground(new Color(230, 230, 250));
		btnPurchase.setBounds(452, 161, 188, 36);
		add(btnPurchase);
		
		final JLabel lblRejectionField = new JLabel("");
		lblRejectionField.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRejectionField.setForeground(Color.WHITE);
		lblRejectionField.setBounds(76, 218, 261, 113);
		add(lblRejectionField);
		
		btnRejection = new JButton("Rejection");
		btnRejection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = JOptionPane.showInputDialog("Please submit reason for rejection");
				lblRejectionField.setText("The Reason for rejection:"+s1);
				
			}
		});
		btnRejection.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnRejection.setBackground(new Color(230, 230, 250));
		btnRejection.setBounds(452, 51, 188, 36);
		add(btnRejection);
		
		tfcstID = new JTextField();
		tfcstID.setBounds(189, 58, 116, 22);
		add(tfcstID);
		tfcstID.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRejectionField.setText("");
				tfdate.setDate(null);
				tfcstID.setText("");
				tfpID.setText("");
				
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(452, 293, 188, 36);
		add(btnCancel);
		
		

	}
}
