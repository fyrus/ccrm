package gui;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Faculty;
import logic.Student;


public class StudentForm extends JPanel {

	private JLabel idLabel = null;
	private JLabel pNameLabel = null;
	private JLabel lNameLabel = null;
	private JLabel facLabel = null;
	private JTextField idTextField = null;
	private JTextField pNameTextField = null;
	private JTextField lNameTextField = null;
	private JComboBox facComboBox = null;
	private Student s;
	public JButton btnClose = null;
	public JButton btnDima;
	
	/**
	 * This is the default constructor
	 */
	public StudentForm() {
		super();
		initialize();
	}

	/**
	 * This method initializes StudentForm
	 */
	private void initialize() {
		facLabel = new JLabel();
		facLabel.setBounds(new Rectangle(15, 105, 113, 19));
		facLabel.setText("Faculty");
		
		lNameLabel = new JLabel();
		lNameLabel.setBounds(new Rectangle(15, 17, 113, 18));
		lNameLabel.setText("Last Name");
		
		pNameLabel = new JLabel();
		pNameLabel.setBounds(new Rectangle(15, 46, 113, 17));
		pNameLabel.setText("Private Name");
		
		idLabel = new JLabel();
		idLabel.setBounds(new Rectangle(15, 74, 113, 17));
		idLabel.setText("ID");
		
		this.setSize(320, 300);
		this.setLayout(null);
		this.add(idLabel, null);
		this.add(pNameLabel, null);
		this.add(lNameLabel, null);
		this.add(facLabel, null);
		this.add(getIdTextField(), null);
		this.add(getPNameTextField(), null);
		this.add(getLNameTextField(), null);
		this.add(getFacComboBox(), null);
		
		btnClose = new JButton("Close");
		/*btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});*/
		btnClose.setBounds(38, 153, 91, 23);
		add(btnClose);
		add(getBtnDima());
	}

	/**
	 * This method initializes idTextField	
	 */
	private JTextField getIdTextField() {
		if (idTextField == null) {
			idTextField = new JTextField();
			idTextField.setBounds(new Rectangle(133, 73, 127, 17));
			idTextField.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusLost(java.awt.event.FocusEvent e) {
					System.out.println("focusLost()"); 
					String id=idTextField.getText();
					if(!id.equals(s.getId())) s.setId(id);
				}
			});
		}
		return idTextField;
	}

	/**
	 * This method initializes pNameTextField	
	 */
	private JTextField getPNameTextField() {
		if (pNameTextField == null) {
			pNameTextField = new JTextField();
			pNameTextField.setBounds(new Rectangle(133, 45, 127, 17));
		
		pNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				System.out.println("focusLost()"); 
				String pName=pNameTextField.getText();
				if(!pName.equals(s.getPName())) s.setPName(pName);
			}
		});
		}
		return pNameTextField;
	}

	/**
	 * This method initializes lNameTextField	
	 */
	private JTextField getLNameTextField() {
		if (lNameTextField == null) {
			lNameTextField = new JTextField();
			lNameTextField.setBounds(new Rectangle(133, 17, 127, 17));
		
		lNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				System.out.println("focusLost()"); // TODO Auto-generated Event stub focusLost()
				String lName=lNameTextField.getText();
				if(!lName.equals(s.getLName())) s.setLName(lName);
			}
		});
	}
		return lNameTextField;
	}

	/**
	 * This method initializes facComboBox	
	 */
	private JComboBox getFacComboBox() {
		if (facComboBox == null) {
			facComboBox = new JComboBox();
			facComboBox.setBounds(new Rectangle(133, 105, 127, 17));
			for(String name:Faculty.getFaculties()){
				facComboBox.addItem(name);
			}
			facComboBox.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println("itemStateChanged()"); 
					s.setFc(Faculty.getFaculty((String)facComboBox.getSelectedItem()));
				}
			});
		}
		return facComboBox;
	}

	void loadStudent(Student s1){
		this.s=s1;
		this.idTextField.setText(s.getId());
		this.pNameTextField.setText(s.getPName());
		this.lNameTextField.setText(s.getLName());
		this.facComboBox.setSelectedItem(s.getFc().getFName());
	}
	private JButton getBtnDima() {
		if (btnDima == null) {
			btnDima = new JButton("Dima");
			/*btnDima.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});*/
			btnDima.setBounds(179, 152, 97, 25);
		}
		return btnDima;
	}
}
