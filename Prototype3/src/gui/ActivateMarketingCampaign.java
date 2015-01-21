/**
 * 
 */
package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

import sun.util.calendar.JulianCalendar;

import java.util.Date;

import sun.util.calendar.CalendarUtils;

import javax.swing.text.DateFormatter;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Nastia
 *
 */
public class ActivateMarketingCampaign extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;
	private JTextField tfmp_id;
	/**
	 * Create the panel.
	 */
	public ActivateMarketingCampaign() {
		setSize(new Dimension(700, 480));
		setLayout(null);
		setBackground(Color.GRAY);
		
		JLabel lblActivateMarketingCampaign = new JLabel("Activate Marketing Campaign");
		lblActivateMarketingCampaign.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblActivateMarketingCampaign.setForeground(Color.PINK);
		lblActivateMarketingCampaign.setBounds(12, 13, 253, 25);
		add(lblActivateMarketingCampaign);
		
		JLabel lblMarketingPatternId = new JLabel("Marketing Pattern ID:");
		lblMarketingPatternId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarketingPatternId.setForeground(Color.WHITE);
		lblMarketingPatternId.setBounds(131, 120, 160, 16);
		add(lblMarketingPatternId);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setForeground(Color.WHITE);
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStartDate.setBounds(131, 177, 85, 16);
		add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setForeground(Color.WHITE);
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndDate.setBounds(131, 237, 70, 16);
		add(lblEndDate);
		
		final JDateChooser tfstartDate = new JDateChooser();
		tfstartDate.setBounds(301, 171, 147, 22);
		add(tfstartDate);
		
		final JDateChooser tfendDate = new JDateChooser();
		tfendDate.setBounds(301, 231, 149, 22);
		add(tfendDate);
		
		JButton btnActivate = new JButton("Activate");
		btnActivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( tfmp_id.getText().equals(null) || (tfendDate.getDate().equals(null)) || (tfstartDate.getDate().equals(null)))
				{
					JOptionPane.showMessageDialog(null, "Error! Please fill ALL mandatory fields.");
					tfmp_id.setText("");
					tfendDate.setDate(null);
					tfstartDate.setDate(null);
					

				}
			}
		});
		btnActivate.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnActivate.setBackground(new Color(230, 230, 250));
		btnActivate.setBounds(103, 297, 188, 36);
		add(btnActivate);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfendDate.setDate(null);
				tfstartDate.setDate(null);
				tfmp_id.setText("");
				
				
			}
		});
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);
		
		tfmp_id = new JTextField();
		tfmp_id.setBounds(303, 118, 145, 22);
		add(tfmp_id);
		tfmp_id.setColumns(10);

	}
}
