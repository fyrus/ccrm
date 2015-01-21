package client;




import ocsf.client.*;
import common.*;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.*;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient {
	// Instance variables **********************************************

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	ChatIF clientUI;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host
	 *            The server to connect to.
	 * @param port
	 *            The port number to connect on.
	 * @param clientUI
	 *            The interface type variable.
	 */

	public ChatClient(String host, int port, ChatIF clientUI)
			throws IOException {
		super(host, port); // Call the superclass constructor
		this.clientUI = clientUI;
		openConnection();
	}

	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 *
	 * @param msg
	 *            The message from the server.
	 */
	public void handleMessageFromServer(Object msg) {
		//StringBuilder sb = new StringBuilder();
		//if (msg instanceof ArrayList<?>) {
			/*for(Object key:((ArrayList<?>)msg).toArray()){
				if(key instanceof Customer){
					sb.append("Customer id: "+ ((Customer)key).getCid() + "\n");
					sb.append("Customer name: "+ ((Customer)key).getCname() + "\n");
					sb.append("Customer phone: "+ ((Customer)key).getcPhone() + "\n");
					sb.append("Customer date: "+ ((Customer)key).getcBirthDate() + "\n");
				}
				if(key instanceof User){
					sb.append("User id: "+ ((User)key).getUid() + "\n");
					sb.append("User name: "+ ((User)key).getName() + "\n");
					sb.append("User address: "+ ((User)key).getAddress() + "\n");
					sb.append("User password: "+ ((User)key).getPassword() + "\n");
					sb.append("User phone: "+ ((User)key).getPhone() + "\n");
				}
				if(key instanceof Domain){
					sb.append("Domain id: "+ ((Domain)key).getDid() + "\n");
					sb.append("Domain name: "+ ((Domain)key).getdName() + "\n");
				}
			}*/
			clientUI.display(msg);
		//}	
	}

	/**
	 * This method handles all data coming from the UI
	 *
	 * @param message
	 *            The message from the UI.
	 */
	public void handleMessageFromClientUI(Object message) {
		try {
			sendToServer(message);
		} catch (IOException e) {
			clientUI.display("Could not send message to server.  Terminating client.");
			quit();
		}
	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}
}
// End of ChatClient class
