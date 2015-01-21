/**
 * 
 */
package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Nastia
 *
 */
public class AddNewPermissionDetails extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfpDomainID;
	private JTextField tfcID;
	private JTextField tfpID;
	public JButton btnCancel;
	public JButton btnAdd;

	/**
	 * Create the panel.
	 */
	public AddNewPermissionDetails() {
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAddNewPermission = new JLabel("Add New Permission Details");
		lblAddNewPermission.setForeground(Color.PINK);
		lblAddNewPermission.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewPermission.setBounds(12, 13, 268, 16);
		add(lblAddNewPermission);
		
		JLabel lblId = new JLabel("Permission ID:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(84, 67, 167, 16);
		add(lblId);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerId.setBounds(84, 107, 167, 16);
		add(lblCustomerId);
		
		JLabel lblPermissionDomainId = new JLabel("Permission Domain ID:");
		lblPermissionDomainId.setForeground(Color.WHITE);
		lblPermissionDomainId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPermissionDomainId.setBounds(78, 151, 173, 16);
		add(lblPermissionDomainId);
		
		tfpDomainID = new JTextField();
		tfpDomainID.setBounds(263, 149, 179, 22);
		add(tfpDomainID);
		tfpDomainID.setColumns(10);
		
		tfcID = new JTextField();
		tfcID.setBounds(263, 105, 179, 22);
		add(tfcID);
		tfcID.setColumns(10);
		
		tfpID = new JTextField();
		tfpID.setBounds(263, 65, 179, 22);
		add(tfpID);
		tfpID.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfcID.setText("");
				tfpDomainID.setText("");
				tfpID.setText("");
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);
		
		btnAdd = new JButton("Add");
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);

	}

}
