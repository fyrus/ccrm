/**
 * 
 */
package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Dima
 *
 */
public class TestFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5851322273271981099L;
	private JPanel FirstPanel;
	private JTextField textField;
	private String role;

	
	

	/**
	 * Create the application.
	 */
	public TestFrame(String role) {
		super();
		setTitle("TestFrame");
		this.role=new String(role);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FirstPanel = new JPanel();
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380, 300);	
		setContentPane(getFirstPanel());
	}
	private JPanel getFirstPanel() {
		
			FirstPanel = new JPanel();
			FirstPanel.setLayout(null);
			FirstPanel.setSize(380, 300);		
			
			textField = new JTextField("Logged in as "+this.role);
			textField.setBounds(54, 80, 328, 20);
			textField.setColumns(10);
			
			FirstPanel.add(textField);
		
		return FirstPanel; 
	}

}
