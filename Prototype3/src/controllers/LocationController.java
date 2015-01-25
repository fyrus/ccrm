/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Location;

/**
 *controller for the user class
 *allows saving and retrieving user info from the DB
 * @author fyrus
 *
 */
public class LocationController extends SuperController{

	public static void addToDB(Object value) {
		Location tLocation = (Location)value;

		String insert = "INSERT INTO location"
				+ "(Lid,Location) VALUES"
				+ "(null,?)";
		
		Object []args = new Object[1];
		args[0]=tLocation.getLocation();
		if(superAddToDB(insert,args))
			System.out.println("Location with id " + tLocation.getLid() + " was added");
		else
			System.out.println("Location with id " + tLocation.getLid() + " was not added");

	}

	/**
	 * remove Location from DB
	 * @param value the Location to remove
	 */
	public static void removeFromDB(Object value) {
		
		Location tLocation = (Location)value;
		Location tmp = new Location();
		tmp.setLid(tLocation.getLid());
		
		if (tLocation.getLid() == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no Location with id " + tLocation.getLid() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM Location WHERE Lid = " + tLocation.getLid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("Location with id " + tLocation.getLid() + " was removed");
			else
				System.out.println("Location with id " + tLocation.getLid() + " was not removed");
		}

	}

	/**
	 * search all Locations in DB
	 * @param value the Location to search (can have some values or all)
	 * @return list of Locations if found, null if not
	 */
	public static Object searchInDB(Object value) {

		Location tmp = (Location)value;

		ArrayList<Location> locationList = new ArrayList<Location>();
		
		String sqlSearch = "SELECT * "
				+ "FROM location "
				+ "WHERE Lid=ifnull(?,Lid) "
				+ "AND Location LIKE ifnull(?,Location) "
				+ "ORDER BY Location";
		
		Object []args = new Object[2];
		args[0]=tmp.getLid();
		args[1]=tmp.getLocation();
		
		ResultSet resultSet;
		
		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null)
				return null;
			while (resultSet.next()) {
				Location p = new Location();
				p.setLid(resultSet.getInt("Lid"));
				p.setLocation(resultSet.getString("Location"));
				locationList.add(p);
			}
			return locationList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search location in DB");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * update a Location in the db
	 * @param value new Location data to be updated
	 * @param id id of the Location we updating
	 */
	public static void updateDb(Object value, int id) {
		
		if (id == 0)
			return;
		Location tLocation = (Location)value;
		
		String update = "UPDATE location "
				+ "SET Location=? "
				+ "WHERE Lid=?";

		Location tmp = new Location();
		tmp.setLid(id);
		//check if Location exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("Location with id " + tLocation.getLid() + " cannot be found");
		}
		else{
			Object []args = new Object[2];
			args[0]=tLocation.getLocation();
			args[1]=id;
			if(superUpdateDb(update,args))
				System.out.println("Location with id " + tLocation.getLid() + " was updated");
			else
				System.out.println("Location with id " + tLocation.getLid() + " was not updated");
		}

	}

}
