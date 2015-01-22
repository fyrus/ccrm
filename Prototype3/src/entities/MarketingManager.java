/**
 * 
 */
package entities;

/**
 * This is the Marketing Manager class 
 * +maintainLocations()
 * +setTypeInCatalog()
 * +setDomainInCatalog()
 * +setProductType()
 * +setProductDomain()
 * +activateMarketingCampaign()
 * +prepareListOfCustomers()
 * +checkDoubleCustomerContact(cid : int, caid : int) : boolean
 * +checkWeeklyCustomerContact(cid : int) : int
 * +marketingCampaignReactionReport
 * +customerCharacterizationReport()
 * @author Yossi
 *
 */
public class MarketingManager extends MarketingMan {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9018538110110563517L;
	
	
	public MarketingManager(){
		super();
		setRole("Marketing Manager");
	}
	
	public MarketingManager(int uid,String name,String password,String address,String phone){
		super(uid,name,password,address,phone);
		setRole("Marketing Manager");
	}


}
