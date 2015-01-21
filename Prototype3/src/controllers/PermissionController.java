/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Permission;

/**
 *controller for the Permission class
 *allows saving and retrieving Permission info from the DB
 * @author fyrus
 *
 */
public class PermissionController extends SuperController{

	public static void addToDB(Object value) {
		Permission tPermission = (Permission)value;

		String sqlinsert = "INSERT INTO Permission"
				+ "(Cid, Did) VALUES"
				+ "(?,?)";

			Object []args = new Object[2];
			args[0]=tPermission.getCid();
			args[1]=tPermission.getDid();
			if(superAddToDB(sqlinsert,args))
				System.out.println("Permission was added");
			else
				System.out.println("Permission was not added");
	}

	/**
	 * remove Permission from DB
	 * @param value the Permission to remove
	 */
	public static void removeFromDB(Object value) {
		
		Permission tPermission = (Permission)value;
		Permission tmp = new Permission();
		tmp.setPid(tPermission.getPid());
		
		if (tPermission.getPid() == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no Permission with id " + tPermission.getPid() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM Permission WHERE Pid = " + tPermission.getPid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("Permission with id " + tPermission.getPid() + " was removed");
			else
				System.out.println("Permission with id " + tPermission.getPid() + " was not removed");
		}

	}

	/**
	 * search all Permissions in DB
	 * @return list of Permissions if found, null if not
	 */
	public static Object searchInDB(Object value) {

		Permission tmp = (Permission)value;

		ArrayList<Permission> PermissionList = new ArrayList<Permission>();
		
		String sqlSearch = "SELECT * "
				+ "FROM Permission "
				+ "WHERE Pid=ifnull(?,Pid) "
				+ "AND Cid =ifnull(?,Cid) "
				+ "AND Did =ifnull(?,Did) ";
		
		Object []args = new Object[3];
		args[0]=tmp.getPid();
		args[1]=tmp.getCid();
		args[2]=tmp.getDid();
		
		ResultSet resultSet;
		
		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null)
				return null;
			while (resultSet.next()) {
				Permission p = new Permission();
				p.setPid(resultSet.getInt("Pid"));
				p.setCid(resultSet.getInt("Cid"));
				p.setDid(resultSet.getInt("Did"));
				PermissionList.add(p);
			}
			return PermissionList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search Permission in DB");
			e.printStackTrace();
			return null;
		}
	}

	public static void updateDb(Object value, int id) {
		
		if (id == 0)
			return;
		Permission tPermission = (Permission)value;
		String update = "UPDATE Permission "
				+ "SET Pid=?, Cid=?, Did=?"
				+ "WHERE Pid=?";

		Permission tmp = new Permission();
		tmp.setDid(id);
		//check if Permission exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("Permission with id " + tPermission.getDid() + " cannot be found");
		}
		else{
			Object []args = new Object[4];
			args[0]=tmp.getPid();
			args[1]=tmp.getCid();
			args[2]=tmp.getDid();
			args[3]=id;
			if(superUpdateDb(update,args))
				System.out.println("Permission with id " + tPermission.getDid() + " was updated");
			else
				System.out.println("Permission with id " + tPermission.getDid() + " was not updated");
		}

	}

}
