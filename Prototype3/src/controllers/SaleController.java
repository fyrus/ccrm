/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Sale;

/**
 *controller for the sale class
 *allows saving and retrieving user info from the DB
 * @author fyrus
 *
 */
public class SaleController extends SuperController{

	public static void addToDB(Object value) {
		Sale tSale = (Sale)value;

		String insert = "INSERT INTO sales"
				+ "(Itemid, Customerid, SaleDate, Comments, Buy) VALUES"
				+ "(?,?,?,?,?)";
		/*
		private int Itemid;
		private String Customerid;
		private String SaleDate;
		private String Comments;
		private boolean Buy;
		 */


		Object []args = new Object[5];
		args[0]=tSale.getItemid();
		args[1]=tSale.getCustomerid();
		args[2]=tSale.getSaleDate();
		args[3]=tSale.getComments();
		args[4]=tSale.getBuy();
		if(superAddToDB(insert,args))
			System.out.println("Sale was added");
		else
			System.out.println("Sale with id was not added");

	}

	/**
	 * remove customer from DB
	 * @param value the customer to remove
	 */
	public static void removeFromDB(Object value) {
/*
		Sale tSale = (Sale)value;
		Sale tmp = new Sale();
		tmp.setcId(tSale.getcId());

		if (tSale.getcId().compareTo("") == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no Sale with id " + tSale.getcId() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM customer WHERE Cid = " + tSale.getcId();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("Sale with id " + tSale.getcId() + " was removed");
			else
				System.out.println("Sale with id " + tSale.getcId() + " was not removed");
		}
		*/

	}

	/**
	 * search all customers in DB
	 * @param value the customer to search (can have some values or all)
	 * @return list of customers if found, null if not
	 */
	public static Object searchInDB(Object value) {

		Sale tmp = (Sale)value;

		ArrayList<Sale> customerList = new ArrayList<Sale>();

		String sqlSearch = "SELECT * "
				+ "FROM sales "
				+ "WHERE Itemid=ifnull(?,Itemid) "
				+ "AND Customerid=ifnull(?,Customerid) "
				+ "AND SaleDate=ifnull(?,SaleDate) "
				+ "AND Comments=ifnull(?,Comments) "
				+ "AND Buy=ifnull(?,Buy) ";
		
		/*
		private int Itemid;
		private String Customerid;
		private String SaleDate;
		private String Comments;
		private boolean Buy;
		 */

		Object []args = new Object[5];
		args[0]=tmp.getItemid();
		args[1]=tmp.getCustomerid();
		args[2]=tmp.getSaleDate();
		args[3]=tmp.getComments();
		args[4]=tmp.getBuy();

		ResultSet resultSet;

		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null){
				System.out.println("no sales found");
				return null;
			}
			while (resultSet.next()) {
				Sale p = new Sale();
				p.setItemid(resultSet.getInt("Itemid"));
				p.setCustomerid(resultSet.getString("Customerid"));
				p.setSaleDate(resultSet.getString("SaleDate"));
				p.setComments(resultSet.getString("Comments"));
				p.setBuy(resultSet.getBoolean("Buy"));
				customerList.add(p);
			}
			return customerList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search sale in DB");
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
/*
		if (id.compareTo("") == 0)
			return;
		Sale tSale = (Sale)value;
		String update = "UPDATE customer "
				+ "SET Cid=? ,Cname=? ,Cbd=? ,Clocation=? ,Cphone=?"
				+ "WHERE Cid=?";

		Sale tmp = new Sale();
		tmp.setcId(id);
		//check if customer exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("Sale with id " + tSale.getcId() + " cannot be found");
		}
		else{
			Object []args = new Object[6];
			args[0]=tSale.getcId();
			args[1]=tSale.getcName();
			args[2]=tSale.getcBirthDate();
			args[3]=tSale.getcLocation();
			args[4]=tSale.getcPhone();
			args[5]=id;
			if(superUpdateDb(update,args))
				System.out.println("Sale with id " + tSale.getcId() + " was updated");
			else
				System.out.println("Sale with id " + tSale.getcId() + " was not updated");
		}
		*/

	}

}
