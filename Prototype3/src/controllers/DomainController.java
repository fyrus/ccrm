/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Domain;

/**
 *controller for the domain class
 *allows saving and retrieving domain info from the DB
 * @author fyrus
 *
 */
public class DomainController extends SuperController{

	public static void addToDB(Object value) {
		Domain tDomain = (Domain)value;

		String insert = "INSERT INTO domain"
				+ "(Did,Dname) VALUES"
				+ "(null,?)";

		Object []args = new Object[1];
		args[0]=tDomain.getdName();
		
		if(superAddToDB(insert,args))
			System.out.println("Domain with name " + tDomain.getdName() + " was added");
		else
			System.out.println("Domain with name " + tDomain.getdName() + " was not added");

	}

	/**
	 * remove domain from DB
	 * @param value the domain to remove
	 */
	public static void removeFromDB(Object value) {

		Domain tDomain = (Domain)value;
		Domain tmp = new Domain();
		tmp.setDid(tDomain.getDid());

		if (tDomain.getDid() == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no Domain with id " + tDomain.getDid() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM domain WHERE Did = " + tDomain.getDid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("Domain with id " + tDomain.getDid() + " was removed");
			else
				System.out.println("Domain with id " + tDomain.getDid() + " was not removed");
		}

	}

	/**
	 * search all domains in DB
	 * @return list of domains if found, null if not
	 */
	public static Object searchInDB(Object value) {

		Domain tmp = (Domain)value;

		ArrayList<Domain> domainList = new ArrayList<Domain>();

		String sqlSearch = "SELECT * "
				+ "FROM domain "
				+ "WHERE Did=ifnull(?,Did) "
				+ "AND Dname LIKE ifnull(?,Dname) ";

		Object []args = new Object[2];
		args[0]=tmp.getDid();
		args[1]=tmp.getdName();

		ResultSet resultSet;

		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null)
				return null;
			while (resultSet.next()) {
				Domain p = new Domain();
				p.setDid(resultSet.getInt("DId"));
				p.setdName(resultSet.getString("Dname"));
				domainList.add(p);
			}
			return domainList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search domain in DB");
			e.printStackTrace();
			return null;
		}
	}

	public static void updateDb(Object value, int id) {

		if (id == 0)
			return;
		Domain tDomain = (Domain)value;
		String update = "UPDATE domain "
				+ "SET Did=? ,Dname=?"
				+ "WHERE Did=?";

		Domain tmp = new Domain();
		tmp.setDid(id);
		//check if domain exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("Domain with id " + tDomain.getDid() + " cannot be found");
		}
		else{
			Object []args = new Object[3];
			args[0]=tDomain.getDid();
			args[1]=tDomain.getdName();
			args[2]=id;
			if(superUpdateDb(update,args))
				System.out.println("Domain with id " + tDomain.getDid() + " was updated");
			else
				System.out.println("Domain with id " + tDomain.getDid() + " was not updated");
		}

	}

}
