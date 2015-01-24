/**
 * 
 */
package entities;

/**
 * This is the Campaign Marketing Pattern class
 * @author Yossi
 *
 */
public class MarketingPatern implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2647389570926962213L;
	
	private int paternid;
	private int productid;
	private int segmentid;
	private String MassageToCustomer;
	
	
	/**
	 * empty constructor
	 */
	public MarketingPatern(){
		paternid=0;
		productid=0;
		segmentid=0;
		MassageToCustomer="";
	}
	
	/**
	 * @param paternid
	 * @param product
	 * @param segmentid
	 * @param massageToCustomer
	 */
	public MarketingPatern(int paternid, int productid,
			int segmentid, String massageToCustomer) {
		this.productid= productid;
		this.segmentid=segmentid;
		this.paternid = paternid;
		this.MassageToCustomer = massageToCustomer;
	}

	/**
	 * @return the paternid
	 */
	public int getPaternid() {
		return paternid;
	}

	/**
	 * @param paternid the paternid to set
	 */
	public void setPaternid(int paternid) {
		this.paternid = paternid;
	}

	/**
	 * @return the product
	 */
	public int getProductid() {
		return this.productid;
	}

	/**
	 * @param product the product to set
	 */
	public void setProductid(int product) {
		this.productid = product;
	}

	/**
	 * @return the segmentid
	 */
	public int getSegmentid() {
		return segmentid;
	}

	/**
	 * @param segmentid the segmentid to set
	 */
	public void setSegmentid(int segmentid) {
		this.segmentid = segmentid;
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
