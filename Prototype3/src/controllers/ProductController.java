/**
 * 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Product;

/**
 *controller for the product class
 *allows saving and retrieving product info from the DB
 * @author fyrus
 *
 */
public class ProductController extends SuperController{

	public static void addToDB(Object value) {
		Product tProduct = (Product)value;

		String insert = "INSERT INTO Product"
				+ "(Pid,Pname,Pdesc,Pphoto,Pprice) VALUES"
				+ "(null,?,?,?,?)";

		Object []args = new Object[4];
		args[0]=tProduct.getPname();
		args[1]=tProduct.getPdescription();
		args[2]=tProduct.getPphoto();
		args[3]=tProduct.getPprice();

		if(superAddToDB(insert,args))
			System.out.println("Product with id " + tProduct.getPid() + " was added");
		else
			System.out.println("Product with id " + tProduct.getPid() + " was not added");

	}

	/**
	 * remove Product from DB
	 * @param value the Product to remove
	 */
	public static void removeFromDB(Object value) {

		Product tProduct = (Product)value;
		Product tmp = new Product();
		tmp.setPid(tProduct.getPid());

		if (tProduct.getPid() == 0)
			return;

		if(searchInDB(tmp) == null)
		{
			System.out.println("no Product with id " + tProduct.getPid() + " found");
		}
		else{
			String sqlRemove = "DELETE FROM Product WHERE Pid = " + tProduct.getPid();
			if(superRemoveFromDB(sqlRemove))
				System.out.println("Product with id " + tProduct.getPid() + " was removed");
			else
				System.out.println("Product with id " + tProduct.getPid() + " was not removed");
		}

	}

	/**
	 * search all Products in DB
	 * @return list of Products if found, null if not
	 */
	public static Object searchInDB(Object value) {

		Product tmp = (Product)value;

		ArrayList<Product> ProductList = new ArrayList<Product>();

		String sqlSearch = "SELECT * "
				+ "FROM product "
				+ "WHERE Pid=ifnull(?,Pid) "
				+ "AND Pname=ifnull(?,Pname) "
				+ "AND Pdesc=ifnull(?,Pdesc) "
				+ "AND Pphoto=ifnull(?,Pphoto) "
				+ "AND Pprice=ifnull(?,Pprice) ";

		Object []args = new Object[5];
		args[0]=tmp.getPid();
		args[1]=tmp.getPname();
		args[2]=tmp.getPdescription();
		args[3]=tmp.getPphoto();
		args[4]=tmp.getPprice();

		ResultSet resultSet;

		try {
			resultSet = superSearchInDB(sqlSearch, args);
			if(resultSet == null)
				return null;
			while (resultSet.next()) {
				Product p = new Product();
				p.setPid(resultSet.getInt("Pid"));
				p.setPname(resultSet.getString("Pname"));
				p.setPdescription(resultSet.getString("Pdesc"));
				p.setPphoto(resultSet.getString("Pphoto"));
				p.setPprice(resultSet.getFloat("Pprice"));
				ProductList.add(p);
			}
			return ProductList;
		} catch (SQLException e) {
			System.out.println("ERROR: Could search Product in DB");
			e.printStackTrace();
			return null;
		}
	}

	public static void updateDb(Object value, int id) {

		if (id == 0)
			return;
		Product tProduct = (Product)value;
		String update = "UPDATE Product "
				+ "SET Pid=? ,Pname=? ,Pdesc=? ,Pphoto=? ,Pprice=? "
				+ "WHERE Pid=?";
		Product tmp = new Product();
		tmp.setPid(id);
		//check if Product exists
		if(searchInDB(tmp) == null)
		{
			System.out.println("Product with id " + tProduct.getPid() + " cannot be found");
		}
		else{
			Object []args = new Object[6];
			args[0]=tProduct.getPid();
			args[1]=tProduct.getPname();
			args[2]=tProduct.getPdescription();
			args[3]=tProduct.getPphoto();
			args[4]=tProduct.getPprice();
			args[5]=id;
			if(superUpdateDb(update,args))
				System.out.println("Product with id " + tProduct.getPid() + " was updated");
			else
				System.out.println("Product with id " + tProduct.getPid() + " was not updated");
		}

	}

}
