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
 * @author Nastia
 *
 */
public class AssignTypeToDomain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public AssignTypeToDomain() {
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAssignTypeTo = new JLabel("Assign Type To Domain");
		lblAssignTypeTo.setForeground(Color.PINK);
		lblAssignTypeTo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAssignTypeTo.setBounds(12, 13, 212, 25);
		add(lblAssignTypeTo);
		
		JLabel lblChooseTypes = new JLabel("Choose Types:");
		lblChooseTypes.setForeground(Color.WHITE);
		lblChooseTypes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseTypes.setBounds(133, 109, 144, 16);
		add(lblChooseTypes);
		
		JLabel lblChooseDomains = new JLabel("Choose Domains:");
		lblChooseDomains.setForeground(Color.WHITE);
		lblChooseDomains.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseDomains.setBounds(133, 186, 144, 16);
		add(lblChooseDomains);
		
		JButton btnTypeList = new JButton("Type List");
		btnTypeList.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnTypeList.setBackground(new Color(230, 230, 250));
		btnTypeList.setBounds(308, 100, 188, 36);
		add(btnTypeList);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAssign.setBackground(new Color(230, 230, 250));
		btnAssign.setBounds(103, 297, 188, 36);
		add(btnAssign);
		
		JButton btnDomainList = new JButton("Domain List");
		btnDomainList.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnDomainList.setBackground(new Color(230, 230, 250));
		btnDomainList.setBounds(308, 177, 188, 36);
		add(btnDomainList);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);

	}

}
