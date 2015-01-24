/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.MarketingSegment;
import entities.Permission;
import entities.SegmentPermission;

/**
 *controller for the segment permission class
 *allows saving and retrieving segment permission info from the DB
 * @author fyrus
 *
 */
public class MarketingSegmentController extends SuperController{

	public static void addToDB(Object value) {
		MarketingSegment tMarketingSegment = (MarketingSegment)value;

		String insert = "INSERT INTO marketing_segment"
				+ "(age,locationid,importance,interest) VALUES"
				+ "(?,?,?,?)";

		Object []args = new Object[4];
		args[0]=tMarketingSegment.getAge();
		args[1]=tMarketingSegment.getLocation();
		args[2]=tMarketingSegment.getImportance();
		args[3]=tMarketingSegment.getInterest();
		try{
			if(superAddToDB(insert,args)){
				ResultSet resultSet;
				String sqlstr = "SELECT Segmentid FROM marketing_segment "
						+"ORDER BY Segmentid DESC "
						+"LIMIT 1";
				resultSet = superSearchInDB(sqlstr, null);	//get the new Segmentid
				resultSet.next();
				int id = resultSet.getInt("Segmentid");
				System.out.println("MarketSegment with id " + id + " added");

				//add the permissions
				ArrayList<Permission> per = tMarketingSegment.getPermission();
				SegmentPermission mc = new SegmentPermission();
				
				//insert all the permissions for the segment
				for(Object key:per.toArray()){
					mc.setPermissionid(((Permission)key).getPid());
					mc.setSegmentid(id);
					SegmentPermissionController.addToDB(mc);
				}

			}
			else
				System.out.println("MarketSegment not added");

		}
		catch (SQLException e) {
			System.out.println("ERROR: Could not add market segment");
			e.printStackTrace();
			return;
		}
	}

	/**
	 * remove segment permission from DB
	 * @param value the segment permission to remove
	 */
	public static void removeFromDB(Object value) {

		MarketingSegment tMarketingSegment = (MarketingSegment)value;
		MarketingSegment tmp = new MarketingSegment();

		tmp.setSegmentid(tMarketingSegment.getSegmentid());

		if(searchInDB(tmp) == null)
		{
			System.out.println("no MarketSegment found");
		}
		else{
			String sqlRemove = "DELETE FROM marketing_segment "
					+ "WHERE Segmentid=" + tMarketingSegment.getSegmentid();
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

		MarketingSegment tmp = (MarketingSegment)value;

		ArrayList<MarketingSegment> marketsegmentList = new ArrayList<MarketingSegment>();

		String sqlSearch = "SELECT * "
				+ "FROM marketing_segment "
				+ "WHERE Segmentid=ifnull(?,Segmentid) "
				+ "AND age=ifnull(?,age) "
				+ "AND locationid=ifnull(?,locationid) "
				+ "AND importance=ifnull(?,importance) "
				+ "AND interest=ifnull(?,interest) ";

		/*
		 private int segmentid;
	private int age;
	private int locationid;
	private int importance;
	private int interest;
	private List<Permission> permission;
		 */

		Object []args = new Object[5];
		args[0]=tmp.getSegmentid();
		args[1]=tmp.getAge();
		args[2]=tmp.getLocation();
		args[3]=tmp.getImportance();
		args[4]=tmp.getInterest();

		ResultSet resultSet;

		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null){
				System.out.println("no MarketSegment found");
				return null;
			}
			while (resultSet.next()) {
				MarketingSegment p = new MarketingSegment();
				p.setAge(resultSet.getInt("Age"));
				p.setImportance(resultSet.getInt("importance"));
				p.setInterest(resultSet.getInt("interest"));
				p.setLocation(resultSet.getInt("locationid"));
				p.setSegmentid(resultSet.getInt("segmentid"));
				marketsegmentList.add(p);
			}
			return marketsegmentList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could not search MarketSegment in DB");
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
		MarketSegment tMarketingSegment = (MarketSegment)value;
		String update = "UPDATE segment permission "
				+ "SET Cid=? ,Cname=? ,Cbd=? ,Clocation=? ,Cphone=?"
				+ "WHERE Cid=?";

		MarketSegment tmp = new MarketSegment();
		tmp.setcId(id);
		//check if segment permission exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("MarketSegment with id " + tMarketingSegment.getcId() + " cannot be found");
		}
		else{
			Object []args = new Object[6];
			args[0]=tMarketingSegment.getcId();
			args[1]=tMarketingSegment.getcName();
			args[2]=tMarketingSegment.getcBirthDate();
			args[3]=tMarketingSegment.getcLocation();
			args[4]=tMarketingSegment.getcPhone();
			args[5]=id;
			if(superUpdateDb(update,args))
				System.out.println("MarketSegment with id " + tMarketingSegment.getcId() + " was updated");
			else
				System.out.println("MarketSegment with id " + tMarketingSegment.getcId() + " was not updated");
		}*/

	}

}
