/**
 * 
 */
package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class creates a new type in a catalog.
 * @author Nastia
 *
 */
public class AddNewTypeToCatalog extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tftID;
	private JTextField tftpName;
	public JButton btnCancel;

	/**
	 * @param tpName is the name type name
	 * @param iID is the type is
	 * Create the panel.
	 */
	public AddNewTypeToCatalog() {
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAddNewType = new JLabel("Add New Type To Catalog");
		lblAddNewType.setForeground(Color.PINK);
		lblAddNewType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddNewType.setBounds(12, 13, 232, 25);
		add(lblAddNewType);
		
		JLabel lblName = new JLabel("Type Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(133, 109, 144, 16);
		add(lblName);
		
		
		JLabel lblId = new JLabel("Type Serial Number:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(133, 176, 172, 16);
		add(lblId);
		
		tftID = new JTextField();
		tftID.setBounds(308, 174, 172, 22);
		add(tftID);
		tftID.setColumns(10);
		
		tftpName = new JTextField();
		tftpName.setBounds(308, 107, 172, 22);
		add(tftpName);
		tftpName.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tftID.setText(null);
				tftpName.setText(null);
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tftID.getText().equals("") || tftpName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Error! Please fill ALL mandatory fields.");
					tftID.setText("");
					tftpName.setText("");
				}
			}
		});
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(103, 297, 188, 36);
		add(btnAdd);

	}
}
