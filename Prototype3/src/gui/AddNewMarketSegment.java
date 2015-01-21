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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 * @author Dima
 *
 */
public class AddNewMarketSegment extends JPanel {
	private JTextField cID;
	private JTextField cAge;

	/**
	 * Create the panel.
	 */
	public AddNewMarketSegment() {
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAddNewMarket = new JLabel("Add New Market Segment");
		lblAddNewMarket.setForeground(Color.PINK);
		lblAddNewMarket.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAddNewMarket.setBounds(12, 13, 212, 25);
		add(lblAddNewMarket);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(Color.PINK);
		btnCancel.setBounds(368, 262, 70, 25);
		add(btnCancel);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(38, 62, 37, 16);
		add(lblId);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAge.setBounds(38, 97, 37, 16);
		add(lblAge);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLocation.setBounds(38, 126, 70, 16);
		add(lblLocation);
		
		JLabel lblCustomerRank = new JLabel("Customer Importance Rank:");
		lblCustomerRank.setForeground(Color.WHITE);
		lblCustomerRank.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCustomerRank.setBounds(38, 155, 199, 16);
		add(lblCustomerRank);
		
		JLabel lblCustomerInterestRank = new JLabel("Customer Interest Rank In Products:");
		lblCustomerInterestRank.setForeground(Color.WHITE);
		lblCustomerInterestRank.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCustomerInterestRank.setBounds(38, 184, 248, 16);
		add(lblCustomerInterestRank);
		
		JLabel lblCustomerPermossions = new JLabel("Customer Permissions:");
		lblCustomerPermossions.setForeground(Color.WHITE);
		lblCustomerPermossions.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCustomerPermossions.setBounds(38, 213, 152, 16);
		add(lblCustomerPermossions);
		
		JComboBox cImportance = new JComboBox();
		cImportance.setModel(new DefaultComboBoxModel(new String[] {"rank", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cImportance.setBounds(240, 152, 70, 22);
		add(cImportance);
		
		JComboBox cInterest = new JComboBox();
		cInterest.setModel(new DefaultComboBoxModel(new String[] {"rank", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cInterest.setBounds(298, 181, 70, 22);
		add(cInterest);
		
		cID = new JTextField();
		cID.setBounds(108, 59, 116, 22);
		add(cID);
		cID.setColumns(10);
		
		cAge = new JTextField();
		cAge.setBounds(108, 94, 116, 22);
		add(cAge);
		cAge.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAdd.setBackground(Color.PINK);
		btnAdd.setBounds(38, 262, 70, 25);
		add(btnAdd);

	}
}
