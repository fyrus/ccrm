
package entities;

/**
 * Customer Characterization Report
 * @author Dima
 *
 */
public class CustomerCharacterizationReport extends AbstractReport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5784372388630244533L;
	/* The id number of the customer*/
	private String customerId;
	/* the number of purchases a customer did in last month/week */
	private int customerPurchaseActivity;
	
	/* 
	 * description of the efficiency of marketing on client.
	 * expected: non-efficient, mildly-efficient, efficient, highly-efficient.
	 */
	private String marketingEfficiencyOnClient;
	
	/**
	 * Default blank constructor
	 */
	public CustomerCharacterizationReport(){
		super();
		this.customerId="0";
		this.customerPurchaseActivity=0;
		this.marketingEfficiencyOnClient="non-efficient";
	}
	
	/**
	 * Constructor of the report
	 * @param rid report id
	 * @param date report date
	 * @param cid customer id
	 * @param act number that represent purchase activity
	 * @param eff string that represent efficiency
	 */
	public CustomerCharacterizationReport(int rid,String date,String cid,int act,String eff){
		super(rid,date);
		this.customerId=cid;
		this.customerPurchaseActivity=act;
		this.marketingEfficiencyOnClient=eff;
	}
	
	/**
	 * Get customer ID
	 * @return String - customer ID
	 */
	public String getCustomerId() {
		return this.customerId;
	}
	/**
	 * Set customer ID
	 * @param id of customer
	 */
	public void setCustomerId(String id) {
		this.customerId = id;
	}
	/**
	 * Gets customers Purchase activity
	 * @return int - the number of purchases this week/month
	 */
	public int getCustomerPurchaseActivity() {
		return this.customerPurchaseActivity;
	}
	/**
	 * Set Customers Purchase number this week/month
	 * @param customerPurchaseActivity number of Purchases
	 */
	public void setCustomerPurchaseActivity(int customerPurchaseActivity) {
		this.customerPurchaseActivity = customerPurchaseActivity;
	}
	/**
	 * Get marketing efficiency rating
	 * @return String - efficiency rating
	 */
	public String getMarketingEfficiencyOnClient() {
		return this.marketingEfficiencyOnClient;
	}
	/**
	 * Set marketing efficiency rating
	 * @param marketingEfficiencyOnClient efficiency rating
	 */
	public void setMarketingEfficiencyOnClient(String marketingEfficiencyOnClient) {
		this.marketingEfficiencyOnClient = marketingEfficiencyOnClient;
	}

	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return (getCustomerId()+getMarketingEfficiencyOnClient());
	}


}
