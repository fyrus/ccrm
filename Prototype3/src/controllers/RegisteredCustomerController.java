/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.RegisteredCustomer;

/**
 *controller for the user class
 *allows saving and retrieving user info from the DB
 * @author fyrus
 *
 */
public class RegisteredCustomerController extends SuperController{

	public static void addToDB(Object value) {
		RegisteredCustomer tRegisteredCustomer = (RegisteredCustomer)value;

		String insert = "INSERT INTO RegisteredCustomer"
				+ "(Cid,Cname, Cbd, Clocation, Cphone, Pid) VALUES"
				+ "(?,?,?,?,?,?)";
		
		RegisteredCustomer tmp = new RegisteredCustomer();
		tmp.setcId(tRegisteredCustomer.getcId());
		
		if (tRegisteredCustomer.getcId().compareTo("") == 0){
			System.out.println("cant insert no id");
			return;
		}

		if(searchInDB(tmp) != null)
		{
			System.out.println("RegisteredCustomer with id " + tRegisteredCustomer.getcId() + " already exists");
		}
		else{
			Object []args = new Object[6];
			args[0]=tRegisteredCustomer.getcId();
			args[1]=tRegisteredCustomer.getcName();
			args[2]=tRegisteredCustomer.getcBirthDate();
			args[3]=tRegisteredCustomer.getcLocation();
			args[4]=tRegisteredCustomer.getcPhone();
			args[5]=tRegisteredCustomer.getPermission();
			if(superAddToDB(insert,args))
				System.out.println("RegisteredCustomer with id " + tRegisteredCustomer.getcId() + " was added");
			else
				System.out.println("RegisteredCustomer with id " + tRegisteredCustomer.getcId() + " was not added");
		}
	}

	/**
	 * remove RegisteredCustomer from DB
	 * @param value the RegisteredCustomer to remove
	 */
	public static void removeFromDB(Object value) {
		
		RegisteredCustomer tRegisteredCustomer = (RegisteredCustomer)value;
		RegisteredCustomer tmp = new RegisteredCustomer();
		tmp.setcId(tRegisteredCustomer.getcId());
		
		if (tRegisteredCustomer.getcId().compareTo("") == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no RegisteredCustomer with id " + tRegisteredCustomer.getcId() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM RegisteredCustomer WHERE Cid = " + tRegisteredCustomer.getcId();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("RegisteredCustomer with id " + tRegisteredCustomer.getcId() + " was removed");
			else
				System.out.println("RegisteredCustomer with id " + tRegisteredCustomer.getcId() + " was not removed");
		}

	}

	/**
	 * search all RegisteredCustomers in DB
	 * @param value the RegisteredCustomer to search (can have some values or all)
	 * @return list of RegisteredCustomers if found, null if not
	 */
	public static Object searchInDB(Object value) {

		RegisteredCustomer tmp = (RegisteredCustomer)value;

		ArrayList<RegisteredCustomer> RegisteredCustomerList = new ArrayList<RegisteredCustomer>();
		
		String sqlSearch = "SELECT * "
				+ "FROM RegisteredCustomer "
				+ "WHERE Cbd=ifnull(?,Cbd) "
				+ "AND Cid=ifnull(?,Cid) "
				+ "AND Clocation=ifnull(?,Clocation) "
				+ "AND Cname=ifnull(?,Cname) "
				+ "AND Cphone=ifnull(?,Cphone) "
				+ "AND Pid=ifnull(?,Pid) ";
		
		Object []args = new Object[6];
		args[0]=tmp.getcBirthDate();
		args[1]=tmp.getcId();
		args[2]=tmp.getcLocation();
		args[3]=tmp.getcName();
		args[4]=tmp.getcPhone();
		args[5]=tmp.getPermission();
		
		ResultSet resultSet;
		
		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null){
				System.out.println("no RegisteredCustomers found");
				return null;
			}
			while (resultSet.next()) {
				RegisteredCustomer p = new RegisteredCustomer();
				p.setcId(resultSet.getString("Cid"));
				p.setcName(resultSet.getString("Cname"));
				p.setcBirthDate(resultSet.getString("Cbd"));
				p.setcLocation(resultSet.getString("Clocation"));
				p.setcPhone(resultSet.getString("Cphone"));
				p.setPermissions(resultSet.getInt("Pid"));
				RegisteredCustomerList.add(p);
			}
			return RegisteredCustomerList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search RegisteredCustomer in DB");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * update a RegisteredCustomer in the db
	 * @param value new RegisteredCustomer data to be updated
	 * @param id id of the RegisteredCustomer we updating
	 */
	public static void updateDb(Object value, String id) {
		
		if (id.compareTo("") == 0)
			return;
		RegisteredCustomer tRegisteredCustomer = (RegisteredCustomer)value;
		String update = "UPDATE RegisteredCustomer "
				+ "SET Cid=? ,Cname=? ,Cbd=? ,Clocation=? ,Cphone=? ,Pid=?"
				+ "WHERE Cid=?";

		RegisteredCustomer tmp = new RegisteredCustomer();
		tmp.setcId(id);
		//check if RegisteredCustomer exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("RegisteredCustomer with id " + tRegisteredCustomer.getcId() + " cannot be found");
		}
		else{
			Object []args = new Object[7];
			args[0]=tRegisteredCustomer.getcId();
			args[1]=tRegisteredCustomer.getcName();
			args[2]=tRegisteredCustomer.getcBirthDate();
			args[3]=tRegisteredCustomer.getcLocation();
			args[4]=tRegisteredCustomer.getcPhone();
			args[5]=tRegisteredCustomer.getPermission();
			args[6]=id;
			if(superUpdateDb(update,args))
				System.out.println("RegisteredCustomer with id " + tRegisteredCustomer.getcId() + " was updated");
			else
				System.out.println("RegisteredCustomer with id " + tRegisteredCustomer.getcId() + " was not updated");
		}

	}

}
