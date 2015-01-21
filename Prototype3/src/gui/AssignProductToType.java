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
public class AssignProductToType extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public AssignProductToType() {
		setSize(new Dimension(700, 480));
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblAssignProductTo = new JLabel("Assign Product To Type");
		lblAssignProductTo.setForeground(Color.PINK);
		lblAssignProductTo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAssignProductTo.setBounds(12, 13, 212, 25);
		add(lblAssignProductTo);
		
		JLabel lblChooseProducts = new JLabel("Choose Products:");
		lblChooseProducts.setForeground(Color.WHITE);
		lblChooseProducts.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseProducts.setBounds(133, 109, 144, 16);
		add(lblChooseProducts);
		
		JLabel lblChooseTypes = new JLabel("Choose Types:");
		lblChooseTypes.setForeground(Color.WHITE);
		lblChooseTypes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseTypes.setBounds(133, 186, 144, 16);
		add(lblChooseTypes);
		
		JButton btnProductList = new JButton("Product List");
		btnProductList.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnProductList.setBackground(new Color(230, 230, 250));
		btnProductList.setBounds(308, 100, 188, 36);
		add(btnProductList);
		
		JButton btnTypeList = new JButton("Type List");
		btnTypeList.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnTypeList.setBackground(new Color(230, 230, 250));
		btnTypeList.setBounds(308, 177, 188, 36);
		add(btnTypeList);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAssign.setBackground(new Color(230, 230, 250));
		btnAssign.setBounds(103, 297, 188, 36);
		add(btnAssign);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(365, 297, 188, 36);
		add(btnCancel);

	}

}
