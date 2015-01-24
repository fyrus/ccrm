/**
 * 
 */
package gui;

import javax.swing.JPanel;

import client.ChatClient;
import common.ChatIF;

import javax.swing.JButton;

import java.awt.Color;
import java.io.IOException;

import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 * @author Nastia
 *
 */
public class CustomerSaleListByMarketingManager extends JPanel implements ChatIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChatClient client;
	public JButton btnCancel;
	

	/**
	 * Create the panel.
	 */
	public CustomerSaleListByMarketingManager() {
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				if (client==null) connect();
				

				
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		
		setLayout(null);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCancel.setBackground(new Color(230, 230, 250));
		btnCancel.setBounds(115, 208, 188, 36);
		add(btnCancel);

	}

private void connect(){
		
		try 
	    {
	      client= new ChatClient(Login.IP,Login.D_PORT,this);
	    } 
	    catch(IOException exception) 
	    {
	      System.out.println("Error: Can't setup connection!"
	                + " Terminating client.");
	      System.exit(1);
	    }
		
	}
	
	/* (non-Javadoc)
	 * @see common.ChatIF#display(java.lang.Object)
	 */
	@Override
	public void display(Object message) {
		// TODO Auto-generated method stub
		
	}

}
