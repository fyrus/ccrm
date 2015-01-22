/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Type;

/**
 *controller for the Type class
 *allows saving and retrieving Type info from the DB
 * @author fyrus
 *
 */
public class TypeController extends SuperController{

	public static void addToDB(Object value) {
		Type tType = (Type)value;

		String sqlinsert = "INSERT INTO Type"
				+ "(Tname, Did) VALUES"
				+ "(?,?)";

			Object []args = new Object[2];
			args[0]=tType.getTname();
			args[1]=tType.getDid();
			if(superAddToDB(sqlinsert,args))
				System.out.println("Type was added");
			else
				System.out.println("Type was not added");
	}

	/**
	 * remove Type from DB
	 * @param value the Type to remove
	 */
	public static void removeFromDB(Object value) {
		
		Type tType = (Type)value;
		Type tmp = new Type();
		tmp.setTid(tType.getTid());
		
		if (tType.getTid() == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no Type with id " + tType.getTid() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM Type WHERE Tid = " + tType.getTid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("Type with id " + tType.getTid() + " was removed");
			else
				System.out.println("Type with id " + tType.getTid() + " was not removed");
		}

	}

	/**
	 * search all Types in DB
	 * @return list of Types if found, null if not
	 */
	public static Object searchInDB(Object value) {

		Type tmp = (Type)value;

		ArrayList<Type> TypeList = new ArrayList<Type>();
		
		String sqlSearch = "SELECT * "
				+ "FROM Type "
				+ "WHERE Tid=ifnull(?,Tid) "
				+ "AND Tname =ifnull(?,Tname) "
				+ "AND Did =ifnull(?,Did) ";
		
		Object []args = new Object[3];
		args[0]=tmp.getTid();
		args[1]=tmp.getTname();
		args[2]=tmp.getDid();
		
		ResultSet resultSet;
		
		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null)
				return null;
			while (resultSet.next()) {
				Type p = new Type();
				p.setTid(resultSet.getInt("Tid"));
				p.setTname(resultSet.getString("Tname"));
				p.setDid(resultSet.getInt("Did"));
				TypeList.add(p);
			}
			return TypeList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search Type in DB");
			e.printStackTrace();
			return null;
		}
	}

	public static void updateDb(Object value, int id) {
		
		if (id == 0)
			return;
		Type tType = (Type)value;
		String update = "UPDATE Type "
				+ "SET Tid=?, Tname=?, Did=?"
				+ "WHERE Tid=?";

		Type tmp = new Type();
		tmp.setTid(id);
		//check if Type exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("Type with id " + tType.getDid() + " cannot be found");
		}
		else{
			Object []args = new Object[3];
			args[0]=tmp.getTid();
			args[1]=tmp.getTname();
			args[2]=tmp.getDid();
			if(superUpdateDb(update,args))
				System.out.println("Type with id " + tType.getDid() + " was updated");
			else
				System.out.println("Type with id " + tType.getDid() + " was not updated");
		}

	}

}
