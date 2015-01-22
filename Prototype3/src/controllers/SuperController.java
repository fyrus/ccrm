/**
 * 
 */
package controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import dbconn.DbConn;

/**
 * @author alex
 *
 *super controller for all the controllers
 *all the controllers create sql to be sent to the server
 *the super controller execute this sql
 *it creats a connection to the DB
 *
 *@param conn the connection variable
 */
public class SuperController extends DbConn{
	protected static Connection conn = null;

	/**
	 * Connect creates the connection to the db
	 * in the conn variable
	 */
	protected static void Connect()
	{
		try {
			conn = getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}
	}

	/**
	 * adds to the DB the object from a specific controller
	 * @param sqlInsert the sql insert string
	 * @param args object array of argument to create the statement
	 * @return returns true if added to DB and false if some error
	 */
	protected static boolean superAddToDB(String sqlInsert, Object[] args) {
		Connect();

		try {
			//sql statement that gets the sqlInsert to execute
			PreparedStatement stm;
			stm = conn.prepareStatement(sqlInsert);

			int i=1;	//indexer for the statement

			//check all the arguments and insert them to the statement
			for(Object arg:args){
				if(arg instanceof String)
					stm.setString(i, (String)arg);

				if(arg instanceof Integer)
					stm.setInt(i, (int)arg);

				if(arg instanceof Boolean)
					stm.setBoolean(i, (boolean)arg);

				if(arg instanceof Float)
					stm.setFloat(i, (float)arg);

				if(arg instanceof Date)
					stm.setDate(i, (Date)arg);

				i++;
			}
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("ERROR: Could not insert to DB");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * adds to the DB the object from a specific controller
	 * @param sqlInsert the sql insert string
	 * @param args object array of argument to create the statement
	 * @return returns true if removed from DB and false if some error
	 */
	protected static boolean superRemoveFromDB(String sqlRemove) {
		Connect();

		Statement statement;

		try {
			statement = conn.createStatement();
			statement.executeUpdate(sqlRemove);
			return true;
		} catch (SQLException e) {
			System.out.println("ERROR: Could not delete from DB");
			e.printStackTrace();
			return false;
		}
	}

	protected static ResultSet superSearchInDB(String sqlSearch,Object [] args) {
		Connect();

		PreparedStatement stm;
		ResultSet resultSet;
		int i=1;
		try {
			stm = conn.prepareStatement(sqlSearch);
			if(args != null)
				//resultSet = stm.executeQuery();

			{
				for(Object arg:args){
					if(arg instanceof String){
						String tmp = (String)arg;
						if(tmp.contentEquals(""))
							stm.setNull(i, Types.VARCHAR);
						else
							stm.setString(i, (String)arg);
					}
					if(arg instanceof Integer)
						if((int)arg==0)
							stm.setNull(i, Types.INTEGER);
						else
							stm.setInt(i, (int)arg);

					if(arg instanceof Float)
						if((float)arg==0)
							stm.setNull(i, Types.FLOAT);
						else
							stm.setFloat(i, (float)arg);

					if(arg instanceof Boolean)
						stm.setBoolean(i, (boolean)arg);

					if(arg instanceof Date){
						if(((Date)arg).equals(new Date(0)))
							stm.setNull(i, Types.DATE);
						else
							stm.setDate(i, (Date)arg);
					}
					

					if(arg == null || arg=="")
						stm.setNull(i, Types.VARCHAR);
					i++;
				}
			}


			resultSet = stm.executeQuery();
			if(resultSet.isBeforeFirst())
				return resultSet;
			else{
				return null;
			}


		} catch (SQLException e) {
			System.out.println("ERROR: Could search in DB");
			e.printStackTrace();
			return null;
		}
	}

	protected static boolean superUpdateDb(String sqlUpdate, Object[] args) {
		Connect();

		try {
			//sql statement that gets the sqlUpdate to execute
			PreparedStatement stm;
			stm = conn.prepareStatement(sqlUpdate);

			int i=1;	//indexer for the statement

			//check all the arguments and insert them to the statement
			for(Object arg:args){
				if(arg instanceof String)
					stm.setString(i, (String)arg);

				if(arg instanceof Integer)
					stm.setInt(i, (int)arg);
				
				if(arg instanceof Float)
					stm.setFloat(i, (float)arg);
				
				if(arg instanceof Boolean)
					stm.setBoolean(i, (boolean)arg);
				
				if(arg instanceof Date)
					stm.setDate(i, (Date)arg);
				i++;
			}
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("ERROR: Could not update DB");
			e.printStackTrace();
			return false;
		}
	}

}



