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
import java.awt.Dimension;

/**
 * @author Nastya
 *
 */
public class ReportSelector extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCampaignReactionReport;
	public JButton btnCustomerCharacterizationReport;
	public JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public ReportSelector() {
		setSize(new Dimension(700, 480));
		setLayout(null);
		setBackground(Color.GRAY);
		
		JLabel label = new JLabel("Activate Marketing Campaign");
		label.setForeground(Color.PINK);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		add(label);
		
		JLabel lblReportSelector = new JLabel("Report Selector");
		lblReportSelector.setForeground(Color.PINK);
		lblReportSelector.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblReportSelector.setBounds(12, 13, 207, 16);
		add(lblReportSelector);
		
		btnCampaignReactionReport = new JButton("Campaign Reaction Report");
		btnCampaignReactionReport.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCampaignReactionReport.setBackground(new Color(230, 230, 250));
		btnCampaignReactionReport.setBounds(112, 128, 214, 36);
		add(btnCampaignReactionReport);
		
		btnCustomerCharacterizationReport = new JButton("Customer Characterization Report");
		btnCustomerCharacterizationReport.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCustomerCharacterizationReport.setBackground(new Color(230, 230, 250));
		btnCustomerCharacterizationReport.setBounds(112, 226, 214, 36);
		add(btnCustomerCharacterizationReport);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(427, 345, 214, 36);
		add(btnCancel);

	}
}
