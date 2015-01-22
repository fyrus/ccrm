/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Customer;

/**
 *controller for the customer class
 *allows saving and retrieving user info from the DB
 * @author fyrus
 *
 */
public class CustomerController extends SuperController{

	public static void addToDB(Object value) {
		Customer tCustomer = (Customer)value;

		String insert = "INSERT INTO customer"
				+ "(Cid,Cname, Cbd, Clocation, Cphone) VALUES"
				+ "(?,?,?,?,?)";
		
		Customer tmp = new Customer();
		tmp.setcId(tCustomer.getcId());
		
		if (tCustomer.getcId().compareTo("") == 0){
			System.out.println("cant insert no id");
			return;
		}

		if(searchInDB(tmp) != null)
		{
			System.out.println("Customer with id " + tCustomer.getcId() + " already exists");
		}
		else{
			Object []args = new Object[5];
			args[0]=tCustomer.getcId();
			args[1]=tCustomer.getcName();
			args[2]=tCustomer.getcBirthDate();
			args[3]=tCustomer.getcLocation();
			args[4]=tCustomer.getcPhone();
			if(superAddToDB(insert,args))
				System.out.println("Customer with id " + tCustomer.getcId() + " was added");
			else
				System.out.println("Customer with id " + tCustomer.getcId() + " was not added");
		}
	}

	/**
	 * remove customer from DB
	 * @param value the customer to remove
	 */
	public static void removeFromDB(Object value) {
		
		Customer tCustomer = (Customer)value;
		Customer tmp = new Customer();
		tmp.setcId(tCustomer.getcId());
		
		if (tCustomer.getcId().compareTo("") == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no Customer with id " + tCustomer.getcId() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM customer WHERE Cid = " + tCustomer.getcId();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("Customer with id " + tCustomer.getcId() + " was removed");
			else
				System.out.println("Customer with id " + tCustomer.getcId() + " was not removed");
		}

	}

	/**
	 * search all customers in DB
	 * @param value the customer to search (can have some values or all)
	 * @return list of customers if found, null if not
	 */
	public static Object searchInDB(Object value) {

		Customer tmp = (Customer)value;

		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		String sqlSearch = "SELECT * "
				+ "FROM customer "
				+ "WHERE Cbd=ifnull(?,Cbd) "
				+ "AND Cid=ifnull(?,Cid) "
				+ "AND Clocation=ifnull(?,Clocation) "
				+ "AND Cname=ifnull(?,Cname) "
				+ "AND Cphone=ifnull(?,Cphone) ";
		
		Object []args = new Object[5];
		args[0]=tmp.getcBirthDate();
		args[1]=tmp.getcId();
		args[2]=tmp.getcLocation();
		args[3]=tmp.getcName();
		args[4]=tmp.getcPhone();
		
		ResultSet resultSet;
		
		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null){
				System.out.println("no customers found");
				return null;
			}
			while (resultSet.next()) {
				Customer p = new Customer();
				p.setcId(resultSet.getString("Cid"));
				p.setcName(resultSet.getString("Cname"));
				p.setcBirthDate(resultSet.getDate("Cbd"));
				p.setcLocation(resultSet.getString("Clocation"));
				p.setcPhone(resultSet.getString("Cphone"));
				customerList.add(p);
			}
			return customerList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search customer in DB");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * update a customer in the db
	 * @param value new customer data to be updated
	 * @param id id of the customer we updating
	 */
	public static void updateDb(Object value, String id) {
		
		if (id.compareTo("") == 0)
			return;
		Customer tCustomer = (Customer)value;
		String update = "UPDATE customer "
				+ "SET Cid=? ,Cname=? ,Cbd=? ,Clocation=? ,Cphone=?"
				+ "WHERE Cid=?";

		Customer tmp = new Customer();
		tmp.setcId(id);
		//check if customer exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("Customer with id " + tCustomer.getcId() + " cannot be found");
		}
		else{
			Object []args = new Object[6];
			args[0]=tCustomer.getcId();
			args[1]=tCustomer.getcName();
			args[2]=tCustomer.getcBirthDate();
			args[3]=tCustomer.getcLocation();
			args[4]=tCustomer.getcPhone();
			args[5]=id;
			if(superUpdateDb(update,args))
				System.out.println("Customer with id " + tCustomer.getcId() + " was updated");
			else
				System.out.println("Customer with id " + tCustomer.getcId() + " was not updated");
		}

	}

}
