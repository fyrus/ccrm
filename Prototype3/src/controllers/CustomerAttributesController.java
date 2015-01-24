/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.CustomerAttributes;

/**
 *controller for the CustomerAttributes class
 *allows saving and retrieving CustomerAttributes info from the DB
 * @author fyrus
 *
 */
public class CustomerAttributesController extends SuperController{

	public static void addToDB(Object value) {
		CustomerAttributes tCustomerAttributes = (CustomerAttributes)value;

		String insert = "INSERT INTO customer_attributes"
				+ "(Customerid,Importance,Interest) VALUES"
				+ "(?,?,?)";
		
		CustomerAttributes tmp = new CustomerAttributes();
		tmp.setCustomerid(tCustomerAttributes.getCustomerid());

		if(searchInDB(tmp) != null)
		{
			System.out.println("CustomerAttributes with id " 
					+ tCustomerAttributes.getCustomerid() 
					+ " already exists");
		}
		else{
			Object []args = new Object[3];
			args[0]=tCustomerAttributes.getCustomerid();
			args[1]=tCustomerAttributes.getImportance();
			args[2]=tCustomerAttributes.getInterest();
			if(superAddToDB(insert,args))
				System.out.println("CustomerAttributes with id " 
						+ tCustomerAttributes.getCustomerid() 
						+ " was added");
			else
				System.out.println("CustomerAttributes with id " 
						+ tCustomerAttributes.getCustomerid() 
						+ " not added");
		}
	}

	/**
	 * remove CustomerAttributes from DB
	 * @param value the CustomerAttributes to remove
	 */
	public static void removeFromDB(Object value) {
		
		CustomerAttributes tCustomerAttributes = (CustomerAttributes)value;
		CustomerAttributes tmp = new CustomerAttributes();
		tmp.setCustomerid(tCustomerAttributes.getCustomerid());
		
		if (tCustomerAttributes.getCustomerid().compareTo("") == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no CustomerAttributes found");
		}
		else{
			String sqlRemove = "DELETE FROM customer_attributes "
					+ "WHERE Customerid=" + tCustomerAttributes.getCustomerid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("CustomerAttributes was removed");
			else
				System.out.println("CustomerAttributes was not removed");
		}

	}

	/**
	 * search all CustomerAttributes in DB
	 * @param value the CustomerAttributes to search (can have some values or all)
	 * @return list of CustomerAttributes if found, null if not
	 */
	public static Object searchInDB(Object value) {

		CustomerAttributes tmp = (CustomerAttributes)value;

		ArrayList<CustomerAttributes> marketingcustomerList = new ArrayList<CustomerAttributes>();
		
		String sqlSearch = "SELECT * "
				+ "FROM customer_attributes "
				+ "WHERE Customerid=ifnull(?,Customerid) "
				+ "AND Importance=ifnull(?,Importance) "
				+ "AND Interest=ifnull(?,Interest) ";
		
		Object []args = new Object[3];
		args[0]=tmp.getCustomerid();
		args[1]=tmp.getImportance();
		args[2]=tmp.getInterest();
		
		ResultSet resultSet;
		
		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null){
				System.out.println("no customer attributes found");
				return null;
			}
			while (resultSet.next()) {
				CustomerAttributes p = new CustomerAttributes();
				p.setCustomerid(resultSet.getString("Customerid"));
				p.setImportance(resultSet.getInt("Importance"));
				p.setInterest(resultSet.getInt("Interest"));
				marketingcustomerList.add(p);
			}
			return marketingcustomerList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search customer attributes in DB");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * update a CustomerAttributes in the db
	 * @param value new CustomerAttributes data to be updated
	 * @param id id of the CustomerAttributes we updating
	 */
	public static void updateDb(Object value, String id) {
		
		if (id.compareTo("") == 0)
			return;
		CustomerAttributes tCustomerAttributes = (CustomerAttributes)value;
		String update = "UPDATE customer "
				+ "SET Customerid=? ,Importance=? ,Interest=? "
				+ "WHERE Customerid=?";

		CustomerAttributes tmp = new CustomerAttributes();
		tmp.setCustomerid(id);
		//check if customer exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("CustomerAttributes with id " + tCustomerAttributes.getCustomerid() + " cannot be found");
		}
		else{
			Object []args = new Object[4];
			args[0]=tCustomerAttributes.getCustomerid();
			args[1]=tCustomerAttributes.getImportance();
			args[2]=tCustomerAttributes.getInterest();
			args[3]=id;
			if(superUpdateDb(update,args))
				System.out.println("CustomerAttributes with id " + tCustomerAttributes.getCustomerid() + " was updated");
			else
				System.out.println("CustomerAttributes with id " + tCustomerAttributes.getCustomerid() + " was not updated");
		}

	}

}
