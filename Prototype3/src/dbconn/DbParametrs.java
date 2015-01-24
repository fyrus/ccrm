/**
 * 
 */
package dbconn;

/**
 * @author Alex
 * all the database parametrs to connect
 */
public class DbParametrs {
	/** The name of the MySQL account to use (or empty for anonymous) */
	private static String userName;

	/** The password for the MySQL account (or empty for anonymous) */
	private static String password;

	/** The name of the computer running MySQL */
	private static String serverName;

	/** The port of the MySQL server (default is 3306) */
	private static int portNumber;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private static String dbName;

	/**
	 * @return the userName
	 */
	public static String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public static void setUserName(String userName) {
		DbParametrs.userName = userName;
	}

	/**
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public static void setPassword(String password) {
		DbParametrs.password = password;
	}

	/**
	 * @return the serverName
	 */
	public static String getServerName() {
		return serverName;
	}

	/**
	 * @param serverName the serverName to set
	 */
	public static void setServerName(String serverName) {
		DbParametrs.serverName = serverName;
	}

	/**
	 * @return the portNumber
	 */
	public static int getPortNumber() {
		return portNumber;
	}

	/**
	 * @param portNumber the portNumber to set
	 */
	public static void setPortNumber(int portNumber) {
		DbParametrs.portNumber = portNumber;
	}

	/**
	 * @return the dbName
	 */
	public static String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName the dbName to set
	 */
	public static void setDbName(String dbName) {
		DbParametrs.dbName = dbName;
	}
}
