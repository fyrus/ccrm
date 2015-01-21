



import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ocsf.server.*;
import dbconn.*;
import common.*;
import controllers.*;
import entities.*;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer {
	// Class variables *************************************************

	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port
	 *            The port number to connect on.
	 */
	public EchoServer(int port) {
		super(port);
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg
	 *            The message received from the client.
	 * @param client
	 *            The connection from which the message originated.
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {

		Command cmd;
		cmd=(Command)msg;
		String action="";
		ArrayList<?> list;		//generic list of object to return to client
		Com comm = cmd.getCom();	//prepare the switch with Com enum

		//comm switch for the commands we got from the client
		//uses controllers to put and get data from the database
		switch(comm){

		//---User---
		case ADD_USER:
			action="'add User'";
			System.out.println("Message received: " + action + " from " + client);
			UserController.addToDB(cmd.getValue());
			break;
		case SEARCH_USER:
			action="'search User'";
			System.out.println("Message received: " + action + " from " + client);
			list = (ArrayList<?>) UserController.searchInDB(cmd.getValue());
			this.sendToClient(list, client);
			break;
		case DELETE_USER:
			action="'delete User'";
			System.out.println("Message received: " + action + " from " + client);
			UserController.removeFromDB(cmd.getValue());
			break;
		case UPDATE_USER:
			action="'update User'";
			System.out.println("Message received: " + action + " from " + client);
			UserController.updateDb(cmd.getValue(), cmd.getExtra()[0]);
			break;
			//---User end---

			//---Customer---
		case ADD_CUSTOMER:
			action="'add customer'";
			System.out.println("Message received: " + action + " from " + client);
			CustomerController.addToDB(cmd.getValue());
			break;
		case SEARCH_CUSTOMER:
			action="'search customer'";
			System.out.println("Message received: " + action + " from " + client);
			list = (ArrayList<?>) CustomerController.searchInDB(cmd.getValue());
			this.sendToClient(list, client);
			break;
		case DELETE_CUSTOMER:
			action="'delete customer'";
			System.out.println("Message received: " + action + " from " + client);
			CustomerController.removeFromDB(cmd.getValue());
			break;
		case UPDATE_CUSTOMER:
			action="'update customer'";
			System.out.println("Message received: " + action + " from " + client);
			CustomerController.updateDb(cmd.getValue(), cmd.getExtra()[0]);
			break;
			//---Customer end---

			//---Domain---
		case ADD_DOMAIN:
			action="'add domain'";
			System.out.println("Message received: " + action + " from " + client);
			DomainController.addToDB(cmd.getValue());
			break;
		case SEARCH_DOMAIN:
			action="'search domain'";
			System.out.println("Message received: " + action + " from " + client);
			list = (ArrayList<?>) DomainController.searchInDB(cmd.getValue());
			this.sendToClient(list, client);
			break;
		case DELETE_DOMAIN:
			action="'delete domain'";
			System.out.println("Message received: " + action + " from " + client);
			DomainController.removeFromDB(cmd.getValue());
			break;
		case UPDATE_DOMAIN:
			action="'update domain'";
			System.out.println("Message received: " + action + " from " + client);
			DomainController.updateDb(cmd.getValue(), Integer.parseInt(cmd.getExtra()[0]));
			break;
			//---Domain end---		

			//---Location---
		case ADD_LOCATION:
			action="'add Location'";
			System.out.println("Message received: " + action + " from " + client);
			LocationController.addToDB(cmd.getValue());
			break;
		case SEARCH_LOCATION:
			action="'search Location'";
			System.out.println("Message received: " + action + " from " + client);
			list = (ArrayList<?>) LocationController.searchInDB(cmd.getValue());
			this.sendToClient(list, client);
			break;
		case DELETE_LOCATION:
			action="'delete Location'";
			System.out.println("Message received: " + action + " from " + client);
			LocationController.removeFromDB(cmd.getValue());
			break;
		case UPDATE_LOCATION:
			action="'update Location'";
			System.out.println("Message received: " + action + " from " + client);
			LocationController.updateDb(cmd.getValue(), Integer.parseInt(cmd.getExtra()[0]));
			break;
			//---Location end---

			//---Product---
		case ADD_PRODUCT:
			action="'add Product'";
			System.out.println("Message received: " + action + " from " + client);
			ProductController.addToDB(cmd.getValue());
			break;
		case SEARCH_PRODUCT:
			action="'search Product'";
			System.out.println("Message received: " + action + " from " + client);
			list = (ArrayList<?>) ProductController.searchInDB(cmd.getValue());
			this.sendToClient(list, client);
			break;
		case DELETE_PRODUCT:
			action="'delete Product'";
			System.out.println("Message received: " + action + " from " + client);
			ProductController.removeFromDB(cmd.getValue());
			break;
		case UPDATE_PRODUCT:
			action="'update Product'";
			System.out.println("Message received: " + action + " from " + client);
			ProductController.updateDb(cmd.getValue(), Integer.parseInt(cmd.getExtra()[0]));
			break;
			//---Product---

			//---RegisteredRegisteredCustomer---
		case ADD_REGISTEREDCUSTOMER:
			action="'add registeredcustomer'";
			System.out.println("Message received: " + action + " from " + client);
			RegisteredCustomerController.addToDB(cmd.getValue());
			break;
		case SEARCH_REGISTEREDCUSTOMER:
			action="'search registeredcustomer'";
			System.out.println("Message received: " + action + " from " + client);
			list = (ArrayList<?>) RegisteredCustomerController.searchInDB(cmd.getValue());
			this.sendToClient(list, client);
			break;
		case DELETE_REGISTEREDCUSTOMER:
			action="'delete registeredcustomer'";
			System.out.println("Message received: " + action + " from " + client);
			RegisteredCustomerController.removeFromDB(cmd.getValue());
			break;
		case UPDATE_REGISTEREDCUSTOMER:
			action="'update registeredcustomer'";
			System.out.println("Message received: " + action + " from " + client);
			RegisteredCustomerController.updateDb(cmd.getValue(), cmd.getExtra()[0]);
			break;
			//---RegisteredRegisteredCustomer end---

			//---Permission---
		case ADD_PERMISSION:
			action="'add Permission'";
			System.out.println("Message received: " + action + " from " + client);
			PermissionController.addToDB(cmd.getValue());
			break;
		case SEARCH_PERMISSION:
			action="'search Permission'";
			System.out.println("Message received: " + action + " from " + client);
			list = (ArrayList<?>) PermissionController.searchInDB(cmd.getValue());
			this.sendToClient(list, client);
			break;
		case DELETE_PERMISSION:
			action="'delete Permission'";
			System.out.println("Message received: " + action + " from " + client);
			PermissionController.removeFromDB(cmd.getValue());
			break;
		case UPDATE_PERMISSION:
			action="'update Permission'";
			System.out.println("Message received: " + action + " from " + client);
			PermissionController.updateDb(cmd.getValue(), Integer.parseInt(cmd.getExtra()[0]));
			break;
			//---Permission---

			//---Type---
		case ADD_TYPE:
			action="'add Type'";
			System.out.println("Message received: " + action + " from " + client);
			TypeController.addToDB(cmd.getValue());
			break;
		case SEARCH_TYPE:
			action="'search Type'";
			System.out.println("Message received: " + action + " from " + client);
			list = (ArrayList<?>) TypeController.searchInDB(cmd.getValue());
			this.sendToClient(list, client);
			break;
		case DELETE_TYPE:
			action="'delete Type'";
			System.out.println("Message received: " + action + " from " + client);
			TypeController.removeFromDB(cmd.getValue());
			break;
		case UPDATE_TYPE:
			action="'update Type'";
			System.out.println("Message received: " + action + " from " + client);
			TypeController.updateDb(cmd.getValue(), Integer.parseInt(cmd.getExtra()[0]));
			break;
			//---Type---


		default:
			break;
		}
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port "
				+ getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * stops listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}

	// Class methods ***************************************************

	/**
	 * This method is responsible for the creation of the server instance (there
	 * is no UI in this phase).
	 *
	 * @param args
	 *            [0] The port number to listen on. Defaults to 5555 if no
	 *            argument is entered.
	 */
	public static void main(String[] args) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = DEFAULT_PORT; // Set port to 5555
		}

		EchoServer sv = new EchoServer(port);

		try {
			sv.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
			ex.printStackTrace();
		}
	}
}
// End of EchoServer class
