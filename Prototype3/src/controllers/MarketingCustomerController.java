/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.MarketingCustomer;

/**
 *controller for the marketing customer class
 *allows saving and retrieving user info from the DB
 * @author fyrus
 *
 */
public class MarketingCustomerController extends SuperController{

	public static void addToDB(Object value) {
		MarketingCustomer tMarketingCustomer = (MarketingCustomer)value;

		String insert = "INSERT INTO marketing_customers"
				+ "(Customerid,Campaignid) VALUES"
				+ "(?,?)";
		
		MarketingCustomer tmp = new MarketingCustomer();
		tmp.setCustomerid(tMarketingCustomer.getCustomerid());
		tmp.setCampaignid(tMarketingCustomer.getCampaignid());

		if(searchInDB(tmp) != null)
		{
			System.out.println("MarketingCustomer with id " + tMarketingCustomer.getCustomerid() 
					+ "campaign id " + tMarketingCustomer.getCampaignid() + " already exists");
		}
		else{
			Object []args = new Object[2];
			args[0]=tMarketingCustomer.getCustomerid();
			args[1]=tMarketingCustomer.getCampaignid();
			if(superAddToDB(insert,args))
				System.out.println("MarketingCustomer with id " + tMarketingCustomer.getCustomerid() 
						+ "campaign id " + tMarketingCustomer.getCampaignid() + " was added");
			else
				System.out.println("MarketingCustomer with id " + tMarketingCustomer.getCustomerid() 
						+ "campaign id " + tMarketingCustomer.getCampaignid() + " not added");
		}
	}

	/**
	 * remove customer from DB
	 * @param value the customer to remove
	 */
	public static void removeFromDB(Object value) {
		
		MarketingCustomer tMarketingCustomer = (MarketingCustomer)value;
		MarketingCustomer tmp = new MarketingCustomer();
		tmp.setCustomerid(tMarketingCustomer.getCustomerid());
		tmp.setCampaignid(tMarketingCustomer.getCampaignid());
		
		if (tMarketingCustomer.getCustomerid().compareTo("") == 0 && tMarketingCustomer.getCampaignid() == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no MarketingCustomer found");
		}
		else{
			String sqlRemove = "DELETE FROM marketing_customers "
					+ "WHERE Customerid=" + "ifnull("+ tMarketingCustomer.getCustomerid() + ",Customerid)"
					+ " AND Campaignid= " + tMarketingCustomer.getCampaignid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("MarketingCustomer was removed");
			else
				System.out.println("MarketingCustomer was not removed");
		}

	}

	/**
	 * search all customers in DB
	 * @param value the customer to search (can have some values or all)
	 * @return list of customers if found, null if not
	 */
	public static Object searchInDB(Object value) {

		MarketingCustomer tmp = (MarketingCustomer)value;

		ArrayList<MarketingCustomer> marketingcustomerList = new ArrayList<MarketingCustomer>();
		
		String sqlSearch = "SELECT * "
				+ "FROM marketing_customers "
				+ "WHERE Customerid=ifnull(?,Customerid) "
				+ "AND Campaignid=ifnull(?,Campaignid) ";
		
		Object []args = new Object[2];
		args[0]=tmp.getCustomerid();
		args[1]=tmp.getCampaignid();
		
		ResultSet resultSet;
		
		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null){
				System.out.println("no marketingcustomers found");
				return null;
			}
			while (resultSet.next()) {
				MarketingCustomer p = new MarketingCustomer();
				p.setCampaignid(resultSet.getInt("Campaignid"));
				p.setCustomerid(resultSet.getString("Customerid"));
				marketingcustomerList.add(p);
			}
			return marketingcustomerList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search marketingcustomer in DB");
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
		MarketingCustomer tMarketingCustomer = (MarketingCustomer)value;
		String update = "UPDATE customer "
				+ "SET Cid=? ,Cname=? ,Cbd=? ,Clocation=? ,Cphone=?"
				+ "WHERE Cid=?";

		MarketingCustomer tmp = new MarketingCustomer();
		tmp.setcId(id);
		//check if customer exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("MarketingCustomer with id " + tMarketingCustomer.getcId() + " cannot be found");
		}
		else{
			Object []args = new Object[6];
			args[0]=tMarketingCustomer.getcId();
			args[1]=tMarketingCustomer.getcName();
			args[2]=tMarketingCustomer.getcBirthDate();
			args[3]=tMarketingCustomer.getcLocation();
			args[4]=tMarketingCustomer.getcPhone();
			args[5]=id;
			if(superUpdateDb(update,args))
				System.out.println("MarketingCustomer with id " + tMarketingCustomer.getcId() + " was updated");
			else
				System.out.println("MarketingCustomer with id " + tMarketingCustomer.getcId() + " was not updated");
		}*/

	}

}
