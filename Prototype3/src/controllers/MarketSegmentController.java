/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.MarketSegment;
import entities.Permission;

/**
 *controller for the segment permission class
 *allows saving and retrieving segment permission info from the DB
 * @author fyrus
 *
 */
public class MarketSegmentController extends SuperController{

	public static void addToDB(Object value) {
		MarketSegment tMarketSegment = (MarketSegment)value;

		String insert = "INSERT INTO market_segment"
				+ "(age,locationid,importance,interest) VALUES"
				+ "(?,?,?,?)";
		
		/*
		 private int segmentid;
	private int age;
	private int locationid;
	private int importance;
	private int interest;
	private List<Permission> permission;
		 */
		
		MarketSegment tmp = new MarketSegment();
		tmp.setAge(tMarketSegment.getAge());
		tmp.setInterest(tMarketSegment.getInterest());
		tmp.setImportance(tMarketSegment.getImportance());
		tmp.setLocation(tMarketSegment.getLocation());

		if(searchInDB(tmp) != null)
		{
			System.out.println("MarketSegment already exists");
		}
		else{
			Object []args = new Object[4];
			args[0]=tMarketSegment.getAge();
			args[1]=tMarketSegment.getLocation();
			args[2]=tMarketSegment.getImportance();
			args[3]=tMarketSegment.getInterest();
			
			if(superAddToDB(insert,args))
				System.out.println("MarketSegment was added");
			else
				System.out.println("MarketSegment not added");
		}
	}

	/**
	 * remove segment permission from DB
	 * @param value the segment permission to remove
	 */
	public static void removeFromDB(Object value) {
		
		MarketSegment tMarketSegment = (MarketSegment)value;
		MarketSegment tmp = new MarketSegment();
		
		tmp.setSegmentid(tMarketSegment.getSegmentid());
		
		if(searchInDB(tmp) == null)
		{
			System.out.println("no MarketSegment found");
		}
		else{
			String sqlRemove = "DELETE FROM market_segment "
					+ "WHERE Segmentid=" + tMarketSegment.getSegmentid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("MarketSegment was removed");
			else
				System.out.println("MarketSegment was not removed");
		}

	}

	/**
	 * search all segment permissions in DB
	 * @param value the segment permission to search (can have some values or all)
	 * @return list of segment permissions if found, null if not
	 */
	public static Object searchInDB(Object value) {

		MarketSegment tmp = (MarketSegment)value;

		ArrayList<MarketSegment> marketsegmentList = new ArrayList<MarketSegment>();
		
		String sqlSearch = "SELECT * "
				+ "FROM market_segment "
				+ "WHERE Segmentid=ifnull(?,Segmentid) "
				+ "AND Permissionid=ifnull(?,Permissionid) ";
		
		Object []args = new Object[2];
		args[0]=tmp.getSegmentid();
		//args[1]=tmp.getPermissionid();
		
		ResultSet resultSet;
		
		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null){
				System.out.println("no segment permissions found");
				return null;
			}
			while (resultSet.next()) {
				MarketSegment p = new MarketSegment();
				//p.setPermissionid(resultSet.getInt("Permissionid"));
				p.setSegmentid(resultSet.getInt("Segmentid"));
				marketsegmentList.add(p);
			}
			return marketsegmentList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search segment permission in DB");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * update a segment permission in the db
	 * @param value new segment permission data to be updated
	 * @param id id of the segment permission we updating
	 */
	public static void updateDb(Object value, String id) {
		/*
		if (id.compareTo("") == 0)
			return;
		MarketSegment tMarketSegment = (MarketSegment)value;
		String update = "UPDATE segment permission "
				+ "SET Cid=? ,Cname=? ,Cbd=? ,Clocation=? ,Cphone=?"
				+ "WHERE Cid=?";

		MarketSegment tmp = new MarketSegment();
		tmp.setcId(id);
		//check if segment permission exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("MarketSegment with id " + tMarketSegment.getcId() + " cannot be found");
		}
		else{
			Object []args = new Object[6];
			args[0]=tMarketSegment.getcId();
			args[1]=tMarketSegment.getcName();
			args[2]=tMarketSegment.getcBirthDate();
			args[3]=tMarketSegment.getcLocation();
			args[4]=tMarketSegment.getcPhone();
			args[5]=id;
			if(superUpdateDb(update,args))
				System.out.println("MarketSegment with id " + tMarketSegment.getcId() + " was updated");
			else
				System.out.println("MarketSegment with id " + tMarketSegment.getcId() + " was not updated");
		}*/

	}

}
