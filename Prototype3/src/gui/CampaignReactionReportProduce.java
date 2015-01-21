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
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Dima
 *
 */
public class CampaignReactionReportProduce extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfmcID;
	public JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public CampaignReactionReportProduce() {
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblCampaignReactionReport = new JLabel("Campaign Reaction Report Produce");
		lblCampaignReactionReport.setForeground(Color.PINK);
		lblCampaignReactionReport.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCampaignReactionReport.setBounds(12, 13, 315, 16);
		add(lblCampaignReactionReport);
		
		JLabel lblMarketingCampaignId = new JLabel("Marketing Campaign ID:");
		lblMarketingCampaignId.setForeground(Color.WHITE);
		lblMarketingCampaignId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarketingCampaignId.setBounds(112, 93, 179, 16);
		add(lblMarketingCampaignId);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setForeground(Color.WHITE);
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStartDate.setBounds(206, 173, 85, 16);
		add(lblStartDate);
		
		final JDateChooser tfDate = new JDateChooser();
		tfDate.setBounds(336, 167, 116, 22);
		add(tfDate);
		
		tfmcID = new JTextField();
		tfmcID.setBounds(336, 91, 116, 22);
		add(tfmcID);
		tfmcID.setColumns(10);
		
		JButton btnPro = new JButton("Produce Report");
		btnPro.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnPro.setBackground(new Color(230, 230, 250));
		btnPro.setBounds(103, 297, 188, 36);
		add(btnPro);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfDate.setDate(null);
				tfmcID.setText("");
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);

	}
}
