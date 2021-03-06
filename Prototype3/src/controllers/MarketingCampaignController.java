/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Customer;
import entities.MarketingCampaign;
import entities.MarketingCustomer;

/**
 *controller for the MarketingCampaign class
 *allows saving and retrieving MarketingCampaign info from the DB
 * @author fyrus
 *
 */
public class MarketingCampaignController extends SuperController{

	public static void addToDB(Object value) {
		MarketingCampaign tMarketingCampaign = (MarketingCampaign)value;

		String insert = "INSERT INTO Marketing_Campaign"
				+ "(Cid,Startdate, Enddate, Paternid) VALUES"
				+ "(null,?,?,?)";

		try{
			Object []args = new Object[3];
			args[0]=tMarketingCampaign.getStartdate();
			args[1]=tMarketingCampaign.getEnddate();
			args[2]=tMarketingCampaign.getPaternid();

			if(superAddToDB(insert,args)){	//if add to db success
				ResultSet resultSet;
				insert = "SELECT Cid FROM Marketing_Campaign "
						+"ORDER BY Cid DESC "
						+"LIMIT 1";
				resultSet = superSearchInDB(insert, null);	//get the new Cid
				resultSet.next();
				int id = resultSet.getInt("Cid");
				System.out.println("MarketingCampaign with id " + id + " was added");

				ArrayList<Customer> cust = tMarketingCampaign.getCust();
				MarketingCustomer mc = new MarketingCustomer();

				//insert all the customers for the campaign
				for(Object key:cust.toArray()){
					mc.setCustomerid(((Customer)key).getcId());
					mc.setCampaignid(id);
					MarketingCustomerController.addToDB(mc);
				}
			}
			else
				System.out.println("MarketingCampaign with id " + tMarketingCampaign.getCid() + " was not added");
		}
		catch (SQLException e) {
			System.out.println("ERROR: Could search MarketingCampaign in DB");
			e.printStackTrace();
			return;
		}
	}

	/**
	 * remove MarketingCampaign from DB
	 * @param value the MarketingCampaign to remove
	 */
	public static void removeFromDB(Object value) {

		MarketingCampaign tMarketingCampaign = (MarketingCampaign)value;
		MarketingCampaign tmp = new MarketingCampaign();
		tmp.setCid(tMarketingCampaign.getCid());

		if (tMarketingCampaign.getCid() == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no MarketingCampaign with id " + tMarketingCampaign.getCid() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM Marketing_Campaign WHERE Cid = " + tMarketingCampaign.getCid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("MarketingCampaign with id " + tMarketingCampaign.getCid() + " was removed");
			else
				System.out.println("MarketingCampaign with id " + tMarketingCampaign.getCid() + " was not removed");

			//remove the campaign from marketing customers table
			sqlRemove = "DELETE FROM marketing_customers WHERE Campaignid = " + tMarketingCampaign.getCid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("marketing_customers with id " + tMarketingCampaign.getCid() + " was removed");
			else
				System.out.println("marketing_customers with id " + tMarketingCampaign.getCid() + " was not removed");
		}

	}

	/**
	 * search all MarketingCampaigns in DB
	 * @return list of MarketingCampaigns if found, null if not
	 */
	public static Object searchInDB(Object value) {

		MarketingCampaign tmp = (MarketingCampaign)value;

		ArrayList<MarketingCampaign> MarketingCampaignList = new ArrayList<MarketingCampaign>();

		String sqlSearch = "SELECT * "
				+ "FROM Marketing_Campaign "
				+ "WHERE Cid=ifnull(?,Cid) "
				+ "AND Startdate=ifnull(?,Startdate) "
				+ "AND Enddate=ifnull(?,Enddate) "
				+ "AND Paternid=ifnull(?,Paternid) ";

		Object []args = new Object[4];
		args[0]=tmp.getCid();
		args[1]=tmp.getStartdate();
		args[2]=tmp.getEnddate();
		args[3]=tmp.getPaternid();

		ResultSet resultSet;

		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null)
				return null;
			while (resultSet.next()) {
				MarketingCampaign p = new MarketingCampaign();
				p.setCid(resultSet.getInt("Cid"));
				p.setStartdate(resultSet.getDate("Startdate"));
				p.setEnddate(resultSet.getDate("Enddate"));
				p.setPaternid(resultSet.getInt("Paternid"));
				MarketingCampaignList.add(p);
			}
			return MarketingCampaignList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search MarketingCampaign in DB");
			e.printStackTrace();
			return null;
		}
	}

	public static void updateDb(Object value, int id) {

		if (id == 0)
			return;
		MarketingCampaign tMarketingCampaign = (MarketingCampaign)value;
		String update = "UPDATE Marketing_Campaign "
				+ "SET Cid=?, Startdate=?, Enddate=?, Paternid=?"
				+ "WHERE Cid=?";
		MarketingCampaign tmp = new MarketingCampaign();
		tmp.setCid(id);
		//check if MarketingCampaign exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("MarketingCampaign with id " + tMarketingCampaign.getCid() + " cannot be found");
		}
		else{
			Object []args = new Object[5];
			args[0]=tmp.getCid();
			args[1]=tmp.getStartdate();
			args[2]=tmp.getEnddate();
			args[3]=tmp.getPaternid();
			args[4]=id;
			if(superUpdateDb(update,args))
				System.out.println("MarketingCampaign with id " + tMarketingCampaign.getCid() + " was updated");
			else
				System.out.println("MarketingCampaign with id " + tMarketingCampaign.getCid() + " was not updated");
		}

	}

}
