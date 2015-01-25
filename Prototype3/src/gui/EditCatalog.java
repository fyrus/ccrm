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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Dima
 *
 */
public class EditCatalog extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel frame;
	public JButton btnCancel;
	public JButton btnAssignProductTo;
	public JButton btnAddNewProduct;
	public JButton btnAddNewType;
	public JButton btnAddNewDomain;
	public JButton btnViewCatalog;
	

	/**
	 * Create the panel.
	 */
		public EditCatalog() {
		setSize(new Dimension(234, 339));
		frame = new JPanel();
		frame.setBounds(100, 100, 450, 300);
		//this.setSize(380, 300);
		this.setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel lblEditCatalog = new JLabel("Edit Catalog");
		lblEditCatalog.setForeground(Color.PINK);
		lblEditCatalog.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblEditCatalog.setBounds(12, 13, 128, 25);
		add(lblEditCatalog);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(22, 284, 188, 36);
		add(btnCancel);
		
		btnAssignProductTo = new JButton("Assign Product To Type");
		btnAssignProductTo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAssignProductTo.setBackground(new Color(230, 230, 250));
		btnAssignProductTo.setBounds(22, 190, 188, 36);
		add(btnAssignProductTo);
		
		btnAddNewProduct = new JButton("Add New Product");
		btnAddNewProduct.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAddNewProduct.setBackground(new Color(230, 230, 250));
		btnAddNewProduct.setBounds(22, 143, 188, 36);
		add(btnAddNewProduct);
		
		btnAddNewType = new JButton("Add New Type");
		btnAddNewType.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAddNewType.setBackground(new Color(230, 230, 250));
		btnAddNewType.setBounds(22, 96, 188, 36);
		add(btnAddNewType);
		
		btnAddNewDomain = new JButton("Add New Domain");
		btnAddNewDomain.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAddNewDomain.setBackground(new Color(230, 230, 250));
		btnAddNewDomain.setBounds(22, 49, 188, 36);
		add(btnAddNewDomain);
		
		btnViewCatalog = new JButton("View Catalog");
		btnViewCatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnViewCatalog.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnViewCatalog.setBackground(new Color(230, 230, 250));
		btnViewCatalog.setBounds(22, 237, 188, 36);
		add(btnViewCatalog);
		frame.setVisible(true);


	}

}
