/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.ProductType;

/**
 *controller for the segment permission class
 *allows saving and retrieving segment permission info from the DB
 * @author fyrus
 *
 */
public class ProductTypeController extends SuperController{

	public static void addToDB(Object value) {
		ProductType tProductType = (ProductType)value;

		String insert = "INSERT INTO product_type"
				+ "(Productid,Typeid) VALUES"
				+ "(?,?)";
		
		ProductType tmp = new ProductType();
		tmp.setProductid(tProductType.getProductid());
		tmp.setTypeid(tProductType.getTypeid());

		if(searchInDB(tmp) != null)
		{
			System.out.println("ProductType already exists");
		}
		else{
			Object []args = new Object[2];
			args[0]=tProductType.getProductid();
			args[1]=tProductType.getTypeid();
			if(superAddToDB(insert,args))
				System.out.println("ProductType was added");
			else
				System.out.println("ProductType not added");
		}
	}

	/**
	 * remove segment permission from DB
	 * @param value the segment permission to remove
	 */
	public static void removeFromDB(Object value) {
		
		ProductType tProductType = (ProductType)value;
		ProductType tmp = new ProductType();
		tmp.setProductid(tProductType.getProductid());
		tmp.setTypeid(tProductType.getTypeid());
		
		if(searchInDB(tmp) == null)
		{
			System.out.println("no ProductType found");
		}
		else{
			String sqlRemove = "DELETE FROM product_type "
					+ "WHERE Typeid=" + tProductType.getTypeid()
					+ " AND Productid= " + "ifnull("+ tProductType.getProductid() + ",Productid)";
			if(superRemoveFromDB(sqlRemove))
				System.out.println("ProductType was removed");
			else
				System.out.println("ProductType was not removed");
		}

	}

	/**
	 * search all segment permissions in DB
	 * @param value the segment permission to search (can have some values or all)
	 * @return list of segment permissions if found, null if not
	 */
	public static Object searchInDB(Object value) {

		ProductType tmp = (ProductType)value;

		ArrayList<ProductType> segmentpermissionList = new ArrayList<ProductType>();
		
		String sqlSearch = "SELECT * "
				+ "FROM product_type "
				+ "WHERE Typeid=ifnull(?,Typeid) "
				+ "AND Productid=ifnull(?,Productid) ";
		
		Object []args = new Object[2];
		args[0]=tmp.getTypeid();
		args[1]=tmp.getProductid();
		
		ResultSet resultSet;
		
		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null){
				System.out.println("no producttype found");
				return null;
			}
			while (resultSet.next()) {
				ProductType p = new ProductType();
				p.setProductid(resultSet.getInt("Productid"));
				p.setTypeid(resultSet.getInt("Typeid"));
				segmentpermissionList.add(p);
			}
			return segmentpermissionList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search producttype in DB");
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
		ProductType tProductType = (ProductType)value;
		String update = "UPDATE segment permission "
				+ "SET Cid=? ,Cname=? ,Cbd=? ,Clocation=? ,Cphone=?"
				+ "WHERE Cid=?";

		ProductType tmp = new ProductType();
		tmp.setcId(id);
		//check if segment permission exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("ProductType with id " + tProductType.getcId() + " cannot be found");
		}
		else{
			Object []args = new Object[6];
			args[0]=tProductType.getcId();
			args[1]=tProductType.getcName();
			args[2]=tProductType.getcBirthDate();
			args[3]=tProductType.getcLocation();
			args[4]=tProductType.getcPhone();
			args[5]=id;
			if(superUpdateDb(update,args))
				System.out.println("ProductType with id " + tProductType.getcId() + " was updated");
			else
				System.out.println("ProductType with id " + tProductType.getcId() + " was not updated");
		}*/

	}

}
