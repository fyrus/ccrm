/**
 * 
 */
package entities;
import java.util.*;

/**
 * This is the Marketing campaign class
 * @author Yossi
 *
 */

/*
 * 
 * NEW METHOD -
 * void AddCustomer (Customer customer)
 */
public class MarketingCampaign implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3694368127324301985L;
	
	
	private int cmpid;
	private String cdate;
	private List<Customer> cust;
	
	
	/**
	 * empty constructor
	 */
	public MarketingCampaign(){
		cmpid=0;
		cdate="";
		cust=null;
	}
	
	
	/**
	 * constructor with params:
	 * @param cmpid
	 * @param cdate
	 */
	public MarketingCampaign(int cmpid,String cdate){
		this.cmpid=cmpid;
		this.cdate=cdate;
		cust=null;
	}
	
	/**
	 * If the new campaign have this information.
	 * @param cmpid
	 * @param cdate
	 * @param cust
	 */
	public MarketingCampaign(int cmpid,String cdate,List<Customer> cust){
		this.cmpid=cmpid;
		this.cdate=cdate;
		this.cust=cust;
	}


	/**
	 * @return the cmpid
	 */
	public int getCmpid() {
		return cmpid;
	}


	/**
	 * @param cmpid the cmpid to set
	 */
	public void setCmpid(int cmpid) {
		this.cmpid = cmpid;
	}


	/**
	 * @return the cdate
	 */
	public String getCdate() {
		return cdate;
	}


	/**
	 * @param cdate the cdate to set
	 */
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}


	/**
	 * @return the cust
	 */
	public List<Customer> getCust() {
		return cust;
	}


	/**
	 * @param cust the cust to set
	 */
	public void setCust(List<Customer> cust) {
		this.cust = cust;
	}
	
	
	/**
	 * add customer to Array
	 * @param customer
	 */
	public void AddCustomer(Customer customer){
		cust.add(customer);
	}
	

}
