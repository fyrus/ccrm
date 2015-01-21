/**
 * 
 */
package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * @author Nastia
 *
 */
public class AddNewMarketingCampaign extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField mcID;
	private JTextField custList;

	/**
	 * Create the panel.
	 */
	public AddNewMarketingCampaign() {
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAddNewMarketing = new JLabel("Add New Marketing Campaign");
		lblAddNewMarketing.setForeground(Color.PINK);
		lblAddNewMarketing.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAddNewMarketing.setBounds(12, 13, 212, 25);
		add(lblAddNewMarketing);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(Color.PINK);
		btnCancel.setBounds(368, 262, 70, 25);
		add(btnCancel);
		
		JLabel lblIdl = new JLabel("ID:");
		lblIdl.setForeground(Color.WHITE);
		lblIdl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdl.setBounds(35, 61, 52, 16);
		add(lblIdl);
		
		JLabel lblCustomerList = new JLabel("Customer List:");
		lblCustomerList.setForeground(Color.WHITE);
		lblCustomerList.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCustomerList.setBounds(35, 106, 118, 16);
		add(lblCustomerList);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStatus.setBounds(35, 154, 61, 16);
		add(lblStatus);
		
		mcID = new JTextField();
		mcID.setBounds(145, 58, 116, 22);
		add(mcID);
		mcID.setColumns(10);
		
		custList = new JTextField();
		custList.setBounds(145, 103, 116, 22);
		add(custList);
		custList.setColumns(10);
		
		JComboBox mcStatus = new JComboBox();
		mcStatus.setModel(new DefaultComboBoxModel(new String[] {"active", "inactive"}));
		mcStatus.setBounds(145, 150, 116, 25);
		add(mcStatus);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(Color.PINK);
		btnAdd.setBounds(17, 262, 70, 25);
		add(btnAdd);

	}
}
