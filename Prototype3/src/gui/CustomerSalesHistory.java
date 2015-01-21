/**
 * 
 */
package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

/**
 * @author Dima
 *
 */
public class CustomerSalesHistory extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;
	public JButton btnNewCustomerPermission;
	public JButton btnNewSalesEvent;

	/**
	 * Create the panel.
	 */
	public CustomerSalesHistory() {
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblCustomerSalesHistory = new JLabel("Customer Sales History");
		lblCustomerSalesHistory.setForeground(Color.PINK);
		lblCustomerSalesHistory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCustomerSalesHistory.setBounds(12, 13, 213, 25);
		add(lblCustomerSalesHistory);
		
		btnNewCustomerPermission = new JButton("New Customer Permission");
		btnNewCustomerPermission.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnNewCustomerPermission.setBackground(new Color(230, 230, 250));
		btnNewCustomerPermission.setBounds(83, 122, 188, 36);
		add(btnNewCustomerPermission);
		
		btnNewSalesEvent = new JButton("New SalesMan Event");
		btnNewSalesEvent.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnNewSalesEvent.setBackground(new Color(230, 230, 250));
		btnNewSalesEvent.setBounds(83, 226, 188, 36);
		add(btnNewSalesEvent);
		
		JButton btnGetCustomerPermission = new JButton("Get Customer Permission List");
		btnGetCustomerPermission.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnGetCustomerPermission.setBackground(new Color(230, 230, 250));
		btnGetCustomerPermission.setBounds(377, 122, 188, 36);
		add(btnGetCustomerPermission);
		
		JButton btnGetCustomerSales = new JButton("Get Customer Sales History");
		btnGetCustomerSales.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnGetCustomerSales.setBackground(new Color(230, 230, 250));
		btnGetCustomerSales.setBounds(377, 226, 188, 36);
		add(btnGetCustomerSales);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(448, 350, 188, 36);
		add(btnCancel);

	}
}
