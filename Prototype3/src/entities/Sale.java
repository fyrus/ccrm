/**
 * 
 */
package entities;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * This is the sale class
 * @author Alex

 */
public class Sale implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6668057236242752253L;
	
	private int Itemid;
	private String Customerid;
	private String SaleDate;
	private String Comments;
	private boolean Buy;
	
	/**
	 * empty constructor
	 */
	public Sale(){
		Itemid=0;
		Customerid="";
		SaleDate="";
		Comments="";
		Buy=false;
	}
	
	/**
	 * constructor with:
	 * @param pid the product id
	 * @param Customerid the product name
	 * @param Buy the product photo
	 * @param Comments the product description
	 * @param SaleDate the product price
	 */
	public Sale(int Itemid, String Customerid, String Comments, String SaleDate, boolean Buy){
		this.Itemid=Itemid;
		this.Customerid=Customerid;
		this.Comments=Comments;
		this.SaleDate=SaleDate;
		this.Buy=Buy;
	}

	/**
	 * @return the product id
	 */
	public int getItemid() {
		return Itemid;
	}

	/**
	 * @param Itemid the product id to set
	 */
	public void setItemid(int Itemid) {
		this.Itemid = Itemid;
	}

	/**
	 * @return the product name
	 */
	public String getCustomerid() {
		return Customerid;
	}

	/**
	 * @param Customerid the product name to set
	 */
	public void setCustomerid(String Customerid) {
		this.Customerid = Customerid;
	}

	/**
	 * @return the product description
	 */
	public String getComments() {
		return Comments;
	}

	/**
	 * @param Comments the product description to set
	 */
	public void setComments(String Comments) {
		this.Comments = Comments;
	}

	/**
	 * @return the product price
	 */
	public String getSaleDate() {
		return SaleDate;
	}

	/**
	 * @param SaleDate the product price to set
	 */
	public void setSaleDate(String SaleDate) {
		this.SaleDate = SaleDate;
	}
	
	/**
	 * @return the product photo
	 */
	public boolean getBuy() {
		return Buy;
	}

	/**
	 * @param Buy the product photo to set
	 */
	public void setBuy(boolean Buy) {
		this.Buy = Buy;
	}
	
	
	

}
