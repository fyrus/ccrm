/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.MarketingPatern;

/**
 *controller for the product class
 *allows saving and retrieving product info from the DB
 * @author fyrus
 *
 */
public class MarketingPaternController extends SuperController{

	public static void addToDB(Object value) {
		MarketingPatern tMarketingPatern = (MarketingPatern)value;

		String insert = "INSERT INTO marketing_patern"
				+ "(Paternid,Productid,Segmentid,Message) VALUES"
				+ "(null,?,?,?)";

		Object []args = new Object[3];
		args[0]=tMarketingPatern.getProductid();
		args[1]=tMarketingPatern.getSegmentid();
		args[2]=tMarketingPatern.getMassageToCustomer();

		if(superAddToDB(insert,args))
			System.out.println("MarketingPatern with id " + tMarketingPatern.getPaternid() + " was added");
		else
			System.out.println("MarketingPatern with id " + tMarketingPatern.getPaternid() + " was not added");

	}

	/**
	 * remove MarketingPatern from DB
	 * @param value the MarketingPatern to remove
	 */
	public static void removeFromDB(Object value) {

		MarketingPatern tMarketingPatern = (MarketingPatern)value;
		MarketingPatern tmp = new MarketingPatern();
		tmp.setPaternid(tMarketingPatern.getPaternid());

		if (tMarketingPatern.getPaternid() == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no MarketingPatern with id " + tMarketingPatern.getPaternid() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM marketing_patern WHERE Paternid = " + tMarketingPatern.getPaternid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("MarketingPatern with id " + tMarketingPatern.getPaternid() + " was removed");
			else
				System.out.println("MarketingPatern with id " + tMarketingPatern.getPaternid() + " was not removed");
		}

	}

	/**
	 * search all MarketingPaterns in DB
	 * @return list of MarketingPaterns if found, null if not
	 */
	public static Object searchInDB(Object value) {

		MarketingPatern tmp = (MarketingPatern)value;

		ArrayList<MarketingPatern> MarketingPaternList = new ArrayList<MarketingPatern>();

		String sqlSearch = "SELECT * "
				+ "FROM marketing_patern "
				+ "WHERE Paternid=ifnull(?,Paternid) "
				+ "AND Productid=ifnull(?,Productid) "
				+ "AND Segmentid=ifnull(?,Segmentid) "
				+ "AND Message=ifnull(?,Message) ";

		Object []args = new Object[4];
		args[0]=tmp.getPaternid();
		args[1]=tmp.getProductid();
		args[2]=tmp.getSegmentid();
		args[3]=tmp.getMassageToCustomer();

		ResultSet resultSet;

		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null)
				return null;
			while (resultSet.next()) {
				MarketingPatern p = new MarketingPatern();
				p.setPaternid(resultSet.getInt("Paternid"));
				p.setProductid(resultSet.getInt("Productid"));
				p.setSegmentid(resultSet.getInt("Segmentid"));
				p.setMassageToCustomer(resultSet.getString("Message"));
				MarketingPaternList.add(p);
			}
			return MarketingPaternList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search MarketingPatern in DB");
			e.printStackTrace();
			return null;
		}
	}

	public static void updateDb(Object value, int id) {

		if (id == 0)
			return;
		MarketingPatern tMarketingPatern = (MarketingPatern)value;
		String update = "UPDATE marketing_patern "
				+ "SET Paternid=? ,Productid=? ,Segmentid=? ,Message=? "
				+ "WHERE Paternid=?";
		MarketingPatern tmp = new MarketingPatern();
		tmp.setPaternid(id);
		//check if MarketingPatern exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("MarketingPatern with id " + tMarketingPatern.getPaternid() + " cannot be found");
		}
		else{
			Object []args = new Object[5];
			args[0]=tMarketingPatern.getPaternid();
			args[1]=tMarketingPatern.getProductid();
			args[2]=tMarketingPatern.getSegmentid();
			args[3]=tMarketingPatern.getMassageToCustomer();
			args[4]=id;
			if(superUpdateDb(update,args))
				System.out.println("MarketingPatern with id " + tMarketingPatern.getPaternid() + " was updated");
			else
				System.out.println("MarketingPatern with id " + tMarketingPatern.getPaternid() + " was not updated");
		}

	}

}
