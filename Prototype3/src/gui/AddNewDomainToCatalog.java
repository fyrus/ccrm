/**
 * 
 */
package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Nastia
 *
 */
public class AddNewDomainToCatalog extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfdName;
	private JTextField tfdID;
	public JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public AddNewDomainToCatalog() {
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblName = new JLabel("Domain Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(133, 109, 144, 16);
		add(lblName);
		
		tfdName = new JTextField();
		tfdName.setBounds(308, 107, 172, 22);
		add(tfdName);
		tfdName.setColumns(10);
		
		JLabel lblId = new JLabel("Domain Serial Number:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(133, 176, 172, 16);
		add(lblId);
		
		tfdID = new JTextField();
		tfdID.setBounds(308, 174, 172, 22);
		add(tfdID);
		tfdID.setColumns(10);
		
		JLabel lblAddNewDomain = new JLabel("Add New Domain To Catalog");
		lblAddNewDomain.setForeground(Color.PINK);
		lblAddNewDomain.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewDomain.setBounds(12, 13, 267, 25);
		add(lblAddNewDomain);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfdID.getText().equals("") || tfdName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Error! Please fill ALL mandatory fields.");
					tfdID.setText("");
					tfdName.setText("");
				}
			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfdID.setText("");
				tfdName.setText("");
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);

	}
}
