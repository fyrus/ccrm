


import java.io.*;

import client.*;
import common.*;
import entities.*;

/**
 * This class constructs the UI for a chat client.  It implements the
 * chat interface in order to activate the display() method.
 * Warning: Some of the code here is cloned in ServerConsole 
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge  
 * @author Dr Robert Lagani&egrave;re
 * @version July 2000
 */
public class ClientConsole implements ChatIF 
{
  //Class variables *************************************************
  
  /**
   * The default port to connect on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Instance variables **********************************************
  
  /**
   * The instance of the client that created this ConsoleChat.
   */
  ChatClient client;

  
  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  public ClientConsole(String host, int port) 
  {
    try 
    {
      client= new ChatClient(host, port, this);
    } 
    catch(IOException exception) 
    {
      System.out.println("Error: Can't setup connection!"
                + " Terminating client.");
      System.exit(1);
    }
  }

  
  //Instance methods ************************************************
  /**
   *  The method will return the action that the user want to do
   **/
  public String getTypeFromConsole(){
	  try
	    {
	      BufferedReader fromConsole = 
	        new BufferedReader(new InputStreamReader(System.in));
	      String message;
	      /*This is the ui of the Client */
	      do
	      {
	    	 System.out.println("Choose the type of command:");
	    	 System.out.println("0. exit.");
	    	 System.out.println("1. Print table.");
	    	 System.out.println("2. Add value to table.");
	    	 System.out.println("3. Update.");
	    	 System.out.print("> ");
	        message = fromConsole.readLine();
	        if (message.equals("0"))
	        	System.exit(0); //if user choose to exit the program
	        
	        
	      }while (!message.equals("1") && !message.equals("2") && !message.equals("3"));
	      return message;
	    } 
	    catch (Exception ex) 
	    {
	      System.out.println
	        ("Unexpected error while reading from console!");
	    }
	  return "0";
  }
  /**
   *  The method will get the value to store in DataBase (String)
   **/
  public String getValueFromConsole(){
	  try
	    {
	      BufferedReader fromConsole = 
	        new BufferedReader(new InputStreamReader(System.in));
	      String message;
	      
	      
	    	 System.out.println("Enter the value to add: ");
	    	 System.out.print("> ");
	        message = fromConsole.readLine();
	         
	      return message;
	    } 
	    catch (Exception ex) 
	    {
	      System.out.println
	        ("Unexpected error while reading from console!");
	    }
	  return "0";
  }
  
  /**
   * This method waits for input from the console.  Once it is 
   * received, it sends it to the client's message handler.
   */
  public void accept() 
  {
    try
    {
      BufferedReader fromConsole = 
        new BufferedReader(new InputStreamReader(System.in));
      String message;
      Command cmd=new Command();

      while (true) 
      {
    	 /* if command is empty, there's an error, exit system. */
        //cmd.setComNum(getTypeFromConsole());
        if (cmd.getCom().equals("")){
        	System.out.println("System shutdown..");
        	System.exit(1);
        }
        
        if (cmd.getCom().equals("1"))
        {
        	System.out.println("search by:");
        	System.out.println("1. id");
        	System.out.println("2. name");
        	System.out.println("3. all\n");
        	String command = getValueFromConsole();
        	System.out.println("enter the value of the search:\n");
        	String extra = getValueFromConsole();
        	cmd.setComExtra(command, extra);
        }
        /* command number 2 means to insert new value to database */
        
        if (cmd.getCom().equals("2"))
        {
        	Customer c1 = new Customer();
        	//cmd.setComVal(getValueFromConsole()); // getting value for database
        	cmd.setComVal(c1);
        }
        
        if (cmd.getCom().equals("3"))
        {
        	Customer c1 = new Customer();
        	//cmd.setComVal(getValueFromConsole()); // getting value for database
        	cmd.setComVal(c1);
        	cmd.setComExtra("3", "306");
        }
        
        client.handleMessageFromClientUI(cmd);
        /* Wait for 3 seconds for the server to replay */
        try {
            Thread.sleep(3000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
      }
    } 
    catch (Exception ex) 
    {
      System.out.println
        ("Unexpected error while reading from console!");
    }
  }

  /**
   * This method overrides the method in the ChatIF interface.  It
   * displays a message onto the screen.
   *
   * @param message The string to be displayed.
   */
  public void display(Object message) 
  {
    System.out.println("> " + (String)message);
  }

  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of the Client UI.
   *
   * @param args[0] The host to connect to.
   */
  public static void main(String[] args) 
  {
    String host = "";
    String ip= "";
    int port = DEFAULT_PORT;  //The port number

    /* the client gets the IP to connect manually*/
    System.out.print("Enter the IP of the Server please: ");
    try
    {
      BufferedReader fromConsole = 
        new BufferedReader(new InputStreamReader(System.in));
      
      /* get IP from console */
        ip = fromConsole.readLine(); 
        
    } 
    catch (Exception ex) 
    {
      System.out.println
        ("Unexpected error while reading from console!");
    }
    /*Feedback to user*/
    System.out.println("Trying to connect to "+ip+" ...");
    try
    {
      host = args[0];
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
    	if (ip.equals("0"))
    		host = "localhost"; // easy access to localhost for testing
    	else if (ip.equals("1"))
    		host = "localhost"; // easy access to remote server for testing
    	else
    		host = ip;
    }
    
    ClientConsole chat= new ClientConsole(host, DEFAULT_PORT);
    /*Feedback to user*/
    System.out.println("Connected succesfuly to "+host);
    
    chat.accept();  // Wait for console data
  }
}
//End of ConsoleChat class
