/**
 * 
 */
package gui;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Dimension;

import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Nastia
 *
 */
public class AddNewCampaignMarketingPattern extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfcmpID;
	private JTextField tfpID;
	private JTextField tfmsID;
	public JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public AddNewCampaignMarketingPattern() {
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAddNewCampaign = new JLabel("Add New Campaign Marketing Pattern");
		lblAddNewCampaign.setForeground(Color.PINK);
		lblAddNewCampaign.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewCampaign.setBounds(12, 13, 345, 25);
		add(lblAddNewCampaign);
		
		JLabel lblId = new JLabel("Pattern ID:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(35, 99, 105, 16);
		add(lblId);
		
		JLabel lblProduct = new JLabel("Product ID:");
		lblProduct.setForeground(Color.WHITE);
		lblProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduct.setBounds(35, 164, 105, 16);
		add(lblProduct);
		
		JLabel lblMarketSegment = new JLabel("Market Segment ID:");
		lblMarketSegment.setForeground(Color.WHITE);
		lblMarketSegment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarketSegment.setBounds(35, 233, 149, 16);
		add(lblMarketSegment);
		
		JLabel lblMessageToCustomer = new JLabel("Message To Customers");
		lblMessageToCustomer.setForeground(Color.WHITE);
		lblMessageToCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessageToCustomer.setBounds(392, 83, 187, 25);
		add(lblMessageToCustomer);
		
		tfcmpID = new JTextField();
		tfcmpID.setBounds(188, 97, 144, 22);
		add(tfcmpID);
		tfcmpID.setColumns(10);
		
		tfpID = new JTextField();
		tfpID.setBounds(188, 162, 144, 22);
		add(tfpID);
		tfpID.setColumns(10);
		
		tfmsID = new JTextField();
		tfmsID.setBounds(188, 231, 144, 22);
		add(tfmsID);
		tfmsID.setColumns(10);
		
		final JTextPane tfamsgToCustomer = new JTextPane();
		tfamsgToCustomer.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		tfamsgToCustomer.setBounds(369, 121, 210, 139);
		add(tfamsgToCustomer);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfcmpID.setText("");
				tfmsID.setText("");
				tfpID.setText("");
				tfamsgToCustomer.setText("");
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfamsgToCustomer.getText().equals("") ||tfcmpID.getText().equals("") ||
						tfmsID.getText().equals("") || tfpID.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Error! Please fill ALL mandatory fields.");
					tfamsgToCustomer.setText("");
					tfcmpID.setText("");
					tfmsID.setText("");
					tfpID.setText("");
				}
					
			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);

	}
}
