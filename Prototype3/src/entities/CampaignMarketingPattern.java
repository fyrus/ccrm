/**
 * 
 */
package entities;

/**
 * This is the Campaign Marketing Pattern class
 * @author Yossi
 *
 */
public class CampaignMarketingPattern implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2647389570926962213L;
	
	private int cmpid;
	private Product product;
	private MarketSegment marketsegment;
	private String MassageToCustomer;
	
	
	/**
	 * empty constructor
	 */
	public CampaignMarketingPattern(){
		cmpid=0;
		product= new Product();
		marketsegment=new MarketSegment();
		MassageToCustomer="";
	}
	
	/**
	 * @param cmpid
	 * @param product
	 * @param marketsegment
	 * @param massageToCustomer
	 */
	public CampaignMarketingPattern(int cmpid, Product product,
			MarketSegment marketsegment, String massageToCustomer) {
		this.product= new Product();
		this.marketsegment=new MarketSegment();
		this.cmpid = cmpid;
		this.product = product;
		this.marketsegment = marketsegment;
		MassageToCustomer = massageToCustomer;
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
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the marketsegment
	 */
	public MarketSegment getMarketsegment() {
		return marketsegment;
	}

	/**
	 * @param marketsegment the marketsegment to set
	 */
	public void setMarketsegment(MarketSegment marketsegment) {
		this.marketsegment = marketsegment;
	}

	/**
	 * @return the massageToCustomer
	 */
	public String getMassageToCustomer() {
		return MassageToCustomer;
	}

	/**
	 * @param massageToCustomer the massageToCustomer to set
	 */
	public void setMassageToCustomer(String massageToCustomer) {
		MassageToCustomer = massageToCustomer;
	}
	
	
	
	
	
	

}
