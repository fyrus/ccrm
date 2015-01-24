/**
 * 
 */
package entities;

import java.sql.Date;

/**
 * This is the sale class
 * @author Alex

 */
public class Sale implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6668057236242752253L;
	
	private int Saleid;
	private int Itemid;
	private String Customerid;
	private Date SaleDate;
	private String Comments;
	private int Call_Time;
	private boolean Buy;
	
	/**
	 * empty constructor
	 */
	public Sale(){
		Saleid=0;
		Itemid=0;
		Customerid="";
		SaleDate=new Date(0);
		Comments="";
		Buy=false;
		Call_Time=0;
	}
	
	/**
	 * constructor with:
	 * @param Saleid the sale id
	 * @param pid the product id
	 * @param Customerid the product name
	 * @param Buy the product photo
	 * @param Comments the product description
	 * @param SaleDate the product price
	 * @param Call_Time the sales call time
	 */
	public Sale(int Saleid, int Itemid, String Customerid, String Comments, Date SaleDate, boolean Buy,int Call_Time){
		this.setSaleid(Saleid);
		this.Itemid=Itemid;
		this.Customerid=Customerid;
		this.Comments=Comments;
		this.SaleDate=SaleDate;
		this.Buy=Buy;
		this.Call_Time=Call_Time;
	}
	
	/**
	 * @return the saleid
	 */
	public int getSaleid() {
		return Saleid;
	}

	/**
	 * @param saleid the saleid to set
	 */
	public void setSaleid(int saleid) {
		Saleid = saleid;
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
	public Date getSaleDate() {
		return SaleDate;
	}

	/**
	 * @param SaleDate the product price to set
	 */
	public void setSaleDate(Date SaleDate) {
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
	
	/**
	 * 
	 * @return the sale call time
	 */
	public int getCallTime(){
		return Call_Time;
	}
	
	/**
	 * 
	 * @param CallTime the sale call time to set
	 */
	public void setCallTime(int CallTime){
		this.Call_Time=CallTime;
	}
	
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return (getCustomerid()+getItemid());
	}
}
