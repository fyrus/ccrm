package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConn {
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final static String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final static String password = "Braude";

	/** The name of the computer running MySQL */
	private final static String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final static int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final static String dbName = "ccrm_db";
	
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("password", password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ serverName + ":" + portNumber + "/" + dbName,
				connectionProps);

		return conn;
	}
}
