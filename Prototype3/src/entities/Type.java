/**
 * 
 */
package entities;
import java.util.*;
/**
 * @author Dima
 *
 */
public class Type implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6532477867573593224L;
	private int tid;
	private int did;
	private String tName;
	private List<Product> products;
	
	/**
	 * Default constructor - blank registered customer
	 */
	public Type(){
		this.tid=0;
		this.tName="";
		this.products=null;
	}
	/**
	 * New type constructor
	 * @param id type id
	 * @param name type name
	 * @param prod list of products of this type
	 */
	public Type(int id,String name,List<Product> prod){
		this.tid=id;
		this.tName=name;
		this.products=new ArrayList<Product>(prod);
	}
	
	/**
	 * adds a new product to this type
	 * @param p product
	 */
	public void addProduct(Product p){
		products.add(p);
	}
	/**
	 * 
	 * @return all products of the type
	 */
	public List<Product> getProducts(){
		return products;
	}
	/**
	 * Clears the list of products
	 */
	public void clearProducts(){
		this.products.clear();
	}
	/**
	 * @param products the product list to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	/**
	 * @return the type id
	 */
	public int getTid() {
		return tid;
	}
	/**
	 * @param tid the type id to set
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}
	/**
	 * @return the type did
	 */
	public int getDid() {
		return did;
	}
	/**
	 * @param tid the type id to set
	 */
	public void setDid(int did) {
		this.did = did;
	}
	/**
	 * @return the type Name
	 */
	public String getTname() {
		return tName;
	}
	/**
	 * @param tName the type Name to set
	 */
	public void setTname(String tName) {
		this.tName = tName;
	}
	

}
