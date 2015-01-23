/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.SegmentPermission;

/**
 *controller for the segment permission class
 *allows saving and retrieving segment permission info from the DB
 * @author fyrus
 *
 */
public class SegmentPermissionController extends SuperController{

	public static void addToDB(Object value) {
		SegmentPermission tSegmentPermission = (SegmentPermission)value;

		String insert = "INSERT INTO segment_permission"
				+ "(Permissionid,Segmentid) VALUES"
				+ "(?,?)";
		
		SegmentPermission tmp = new SegmentPermission();
		tmp.setPermissionid(tSegmentPermission.getPermissionid());
		tmp.setSegmentid(tSegmentPermission.getSegmentid());

		if(searchInDB(tmp) != null)
		{
			System.out.println("SegmentPermission already exists");
		}
		else{
			Object []args = new Object[2];
			args[0]=tSegmentPermission.getPermissionid();
			args[1]=tSegmentPermission.getSegmentid();
			if(superAddToDB(insert,args))
				System.out.println("SegmentPermission was added");
			else
				System.out.println("SegmentPermission not added");
		}
	}

	/**
	 * remove segment permission from DB
	 * @param value the segment permission to remove
	 */
	public static void removeFromDB(Object value) {
		
		SegmentPermission tSegmentPermission = (SegmentPermission)value;
		SegmentPermission tmp = new SegmentPermission();
		tmp.setPermissionid(tSegmentPermission.getPermissionid());
		tmp.setSegmentid(tSegmentPermission.getSegmentid());
		
		if(searchInDB(tmp) == null)
		{
			System.out.println("no SegmentPermission found");
		}
		else{
			String sqlRemove = "DELETE FROM segment_permission "
					+ "WHERE Segmentid=" + tSegmentPermission.getSegmentid()
					+ " AND Permissionid= " + "ifnull("+ tSegmentPermission.getPermissionid() + ",Permissionid)";
			if(superRemoveFromDB(sqlRemove))
				System.out.println("SegmentPermission was removed");
			else
				System.out.println("SegmentPermission was not removed");
		}

	}

	/**
	 * search all segment permissions in DB
	 * @param value the segment permission to search (can have some values or all)
	 * @return list of segment permissions if found, null if not
	 */
	public static Object searchInDB(Object value) {

		SegmentPermission tmp = (SegmentPermission)value;

		ArrayList<SegmentPermission> segmentpermissionList = new ArrayList<SegmentPermission>();
		
		String sqlSearch = "SELECT * "
				+ "FROM segment_permission "
				+ "WHERE Segmentid=ifnull(?,Segmentid) "
				+ "AND Permissionid=ifnull(?,Permissionid) ";
		
		Object []args = new Object[2];
		args[0]=tmp.getSegmentid();
		args[1]=tmp.getPermissionid();
		
		ResultSet resultSet;
		
		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null){
				System.out.println("no segment permissions found");
				return null;
			}
			while (resultSet.next()) {
				SegmentPermission p = new SegmentPermission();
				p.setPermissionid(resultSet.getInt("Permissionid"));
				p.setSegmentid(resultSet.getInt("Segmentid"));
				segmentpermissionList.add(p);
			}
			return segmentpermissionList;
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
		SegmentPermission tSegmentPermission = (SegmentPermission)value;
		String update = "UPDATE segment permission "
				+ "SET Cid=? ,Cname=? ,Cbd=? ,Clocation=? ,Cphone=?"
				+ "WHERE Cid=?";

		SegmentPermission tmp = new SegmentPermission();
		tmp.setcId(id);
		//check if segment permission exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("SegmentPermission with id " + tSegmentPermission.getcId() + " cannot be found");
		}
		else{
			Object []args = new Object[6];
			args[0]=tSegmentPermission.getcId();
			args[1]=tSegmentPermission.getcName();
			args[2]=tSegmentPermission.getcBirthDate();
			args[3]=tSegmentPermission.getcLocation();
			args[4]=tSegmentPermission.getcPhone();
			args[5]=id;
			if(superUpdateDb(update,args))
				System.out.println("SegmentPermission with id " + tSegmentPermission.getcId() + " was updated");
			else
				System.out.println("SegmentPermission with id " + tSegmentPermission.getcId() + " was not updated");
		}*/

	}

}
