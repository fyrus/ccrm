/**
 * 
 */
package entities;
import java.util.*;
/**
 * MarketingCustomer will contain marketing id and custoemr id
 * @author alex
 *
 */
public class MarketingCustomer implements java.io.Serializable{
	private String Customerid;
	private int Campaignid;
	
	/**
	 * Default constructor - blank marketing customer
	 */
	public MarketingCustomer(){
		this.Campaignid=0;
		this.Customerid="";
	}
	/**
	 * New marketing customer
	 * @param id domain id
	 * @param name domain name
	 * @param type list of types in domain
	 */
	public MarketingCustomer(String Customerid,int Campaignid){
		this.Customerid = Customerid;
		this.Campaignid = Campaignid;
	}

	/**
	 * @return the Customerid
	 */
	public String getCustomerid() {
		return this.Customerid;
	}

	/**
	 * @param did the domain id to set
	 */
	public void setCustomerid(String Customerid) {
		this.Customerid = Customerid;
	}
	
	/**
	 * @return the Campaignid
	 */
	public int getCampaignid() {
		return this.Campaignid;
	}

	/**
	 * @param did the Campaignid
	 */
	public void setCampaignid(int Campaignid) {
		this.Campaignid = Campaignid;
	}
}
