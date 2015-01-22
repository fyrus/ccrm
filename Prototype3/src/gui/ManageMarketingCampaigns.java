/**
 * 
 */
package gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

/**
 * @author Nastia
 *
 */
public class ManageMarketingCampaigns extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;
	public JButton btnAddNewMarketing;
	public JButton btnActivateMarketingCampaign;


	/**
	 * Create the panel.
	 */
	public ManageMarketingCampaigns() {
		setBackground(Color.GRAY);
		setSize(new Dimension(700, 480));
		setLayout(null);
		
		JLabel lblManageMarketingCampaigns = new JLabel("Manage Marketing Campaigns");
		lblManageMarketingCampaigns.setForeground(Color.PINK);
		lblManageMarketingCampaigns.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblManageMarketingCampaigns.setBounds(12, 13, 253, 25);
		add(lblManageMarketingCampaigns);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(180, 292, 188, 36);
		add(btnCancel);
		
	    btnAddNewMarketing = new JButton("Add New Marketing Campaign");
		btnAddNewMarketing.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAddNewMarketing.setBackground(new Color(230, 230, 250));
		btnAddNewMarketing.setBounds(49, 120, 188, 36);
		add(btnAddNewMarketing);
		
		btnActivateMarketingCampaign = new JButton("Activate Marketing Campaign");
		btnActivateMarketingCampaign.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnActivateMarketingCampaign.setBackground(new Color(230, 230, 250));
		btnActivateMarketingCampaign.setBounds(308, 120, 188, 36);
		add(btnActivateMarketingCampaign);

	}
}
