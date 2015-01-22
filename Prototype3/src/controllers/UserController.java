/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.User;

/**
 *controller for the user class
 *allows saving and retrieving user info from the DB
 * @author fyrus
 *
 */
public class UserController extends SuperController{

	public static void addToDB(Object value) {
		User tUser = (User)value;

		String insert = "INSERT INTO user"
				+ "(Uid, Name, Password, Addr, Phone, LoggedIn, Role) VALUES"
				+ "(?,?,?,?,?,?,?)";

		User tmp = new User();
		tmp.setUid(tUser.getUid());

		if (tUser.getUid() == 0)
			return;

		if(searchInDB(tmp) != null)
		{
			System.out.println("User with id " + tUser.getUid() + " already exists");
		}
		else{
			Object []args = new Object[7];
			args[0]=tUser.getUid();
			args[1]=tUser.getName();
			args[2]=tUser.getPassword();
			args[3]=tUser.getAddress();
			args[4]=tUser.getPhone();
			args[5]=tUser.isLoggedin();
			args[6]=tUser.getRole();
			if(superAddToDB(insert,args))
				System.out.println("User with id " + tUser.getUid() + " was added");
			else
				System.out.println("User with id " + tUser.getUid() + " was not added");
		}
	}

	/**
	 * remove User from DB
	 * @param value the User to remove
	 */
	public static void removeFromDB(Object value) {

		User tUser = (User)value;
		User tmp = new User();
		tmp.setUid(tUser.getUid());

		if (tUser.getUid() == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no User with id " + tUser.getUid() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM User WHERE Uid = " + tUser.getUid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("User with id " + tUser.getUid() + " was removed");
			else
				System.out.println("User with id " + tUser.getUid() + " was not removed");
		}

	}

	/**
	 * search all Users in DB
	 * @param value the User to search (can have some values or all)
	 * @return list of Users if found, null if not
	 */
	public static Object searchInDB(Object value) {

		User tmp = (User)value;

		ArrayList<User> UserList = new ArrayList<User>();

		String sqlSearch = "SELECT * "
				+ "FROM User "
				+ "WHERE Uid=ifnull(?,Uid) "
				+ "AND Name=ifnull(?,Name) "
				+ "AND Password=ifnull(?,Password) "
				+ "AND Addr=ifnull(?,Addr) "
				+ "AND Phone=ifnull(?,Phone) "
				+ "AND LoggedIn=ifnull(?,LoggedIn) "
				+ "AND Role=ifnull(?,Role) ";

		Object []args = new Object[7];
		args[0]=tmp.getUid();
		args[1]=tmp.getName();
		args[2]=tmp.getPassword();
		args[3]=tmp.getAddress();
		args[4]=tmp.getPhone();
		args[5]=tmp.isLoggedin();
		args[6]=tmp.getRole();

		ResultSet resultSet;

		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null)
				return null;
			while (resultSet.next()) {
				User p = new User();
				p.setUid(resultSet.getInt("Uid"));
				p.setName(resultSet.getString("Name"));
				p.setPassword(resultSet.getString("Password"));
				p.setAddress(resultSet.getString("Addr"));
				p.setPhone(resultSet.getString("Phone"));
				p.setLoggedin(resultSet.getBoolean("LoggedIn"));
				p.setRole(resultSet.getString("Role"));
				UserList.add(p);
			}
			return UserList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search User in DB");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * update a User in the db
	 * @param value new User data to be updated
	 * @param id id of the User we updating
	 */
	public static void updateDb(Object value, int id) {

		if (id == 0)
			return;
		User tUser = (User)value;
		String update = "UPDATE user "
				+ "SET Uid=? ,Name=? ,Password=? ,Addr=? ,Phone=? ,LoggedIn=?, Role=?"
				+ "WHERE Uid=?";

		User tmp = new User();
		tmp.setUid(id);
		//check if User exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("User with id " + tUser.getUid() + " cannot be found");
		}
		else{
			Object []args = new Object[7];
			args[0]=tUser.getUid();
			args[1]=tUser.getName();
			args[2]=tUser.getPassword();
			args[3]=tUser.getAddress();
			args[4]=tUser.getPhone();
			args[5]=tUser.isLoggedin();
			args[5]=tUser.getRole();
			args[5]=id;
			if(superUpdateDb(update,args))
				System.out.println("User with id " + tUser.getUid() + " was updated");
			else
				System.out.println("User with id " + tUser.getUid() + " was not updated");
		}

	}

}
