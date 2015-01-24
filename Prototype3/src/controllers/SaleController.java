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
 *allows saving and retrieving sale info from the DB
 * @author fyrus
 *
 */
public class SaleController extends SuperController{

	public static void addToDB(Object value) {
		Sale tSale = (Sale)value;

		String insert = "INSERT INTO sales"
				+ "(Itemid, Customerid, SaleDate, CallTime, Comments, Buy) VALUES"
				+ "(?,?,?,?,?,?)";

		Object []args = new Object[6];
		args[0]=tSale.getItemid();
		args[1]=tSale.getCustomerid();
		args[2]=tSale.getSaleDate();
		args[3]=tSale.getCallTime();
		args[4]=tSale.getComments();
		args[5]=tSale.getBuy();
		if(superAddToDB(insert,args))
			System.out.println("Sale was added");
		else
			System.out.println("Sale with id was not added");

	}

	/**
	 * remove sale from DB
	 * @param value the sale to remove
	 */
	public static void removeFromDB(Object value) {

		Sale tSale = (Sale)value;
		Sale tmp = new Sale();
		tmp.setSaleid(tSale.getSaleid());

		if (tSale.getSaleid() == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no Sale with id " + tSale.getSaleid() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM sales WHERE Saleid = " + tSale.getSaleid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("Sale with id " + tSale.getSaleid() + " was removed");
			else
				System.out.println("Sale with id " + tSale.getSaleid() + " was not removed");
		}
		

	}

	/**
	 * search all sale in DB
	 * @param value the sale to search (can have some values or all)
	 * @return list of sale if found, null if not
	 */
	public static Object searchInDB(Object value) {

		Sale tmp = (Sale)value;

		ArrayList<Sale> customerList = new ArrayList<Sale>();

		String sqlSearch = "SELECT * "
				+ "FROM sales "
				+ "WHERE Saleid=ifnull(?,Saleid) "
				+ "AND Itemid=ifnull(?,Itemid) "
				+ "AND Customerid=ifnull(?,Customerid) "
				+ "AND SaleDate=ifnull(?,SaleDate) "
				+ "AND CallTime=ifnull(?,CallTime) "
				+ "AND Comments=ifnull(?,Comments) "
				+ "AND Buy=ifnull(?,Buy) ";
		
		Object []args = new Object[7];
		args[0]=tmp.getSaleid();
		args[1]=tmp.getItemid();
		args[2]=tmp.getCustomerid();
		args[3]=tmp.getSaleDate();
		args[4]=tmp.getCallTime();
		args[5]=tmp.getComments();
		args[6]=tmp.getBuy();

		ResultSet resultSet;

		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null){
				System.out.println("no sales found");
				return null;
			}
			while (resultSet.next()) {
				Sale p = new Sale();
				p.setSaleid(resultSet.getInt("Saleid"));
				p.setItemid(resultSet.getInt("Itemid"));
				p.setCustomerid(resultSet.getString("Customerid"));
				p.setSaleDate(resultSet.getDate("SaleDate"));
				p.setCallTime(resultSet.getInt("CallTime"));
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
	 * update a sale in the db
	 * @param value new sale data to be updated
	 * @param id id of the sale we updating
	 */
	public static void updateDb(Object value, int id) {

		if (id == 0)
			return;
		Sale tSale = (Sale)value;
		String update = "UPDATE customer "
				+ "SET Cid=? ,Cname=? ,Cbd=? ,Clocation=? ,Cphone=?"
				+ "WHERE Cid=?";

		Sale tmp = new Sale();
		tmp.setSaleid(id);
		//check if sale exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("Sale with id " + tSale.getSaleid() + " cannot be found");
		}
		else{
			Object []args = new Object[8];
			args[0]=tSale.getSaleid();
			args[1]=tSale.getItemid();
			args[2]=tSale.getCustomerid();
			args[3]=tSale.getSaleDate();
			args[4]=tSale.getCallTime();
			args[5]=tSale.getComments();
			args[6]=tSale.getBuy();
			args[7]=id;
			
			if(superUpdateDb(update,args))
				System.out.println("Sale with id " + tSale.getSaleid() + " was updated");
			else
				System.out.println("Sale with id " + tSale.getSaleid() + " was not updated");
		}
		

	}

}
