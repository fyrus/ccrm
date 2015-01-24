/**
 * 
 */
package entities;
/**
 * SegmentPermission will contain Segment id and Permission id
 * @author alex
 *
 */
public class ProductType implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5909137016175283636L;
	private int Productid;
	private int Typeid;
	
	/**
	 * Default constructor - blank segment permission
	 */
	public ProductType(){
		this.Typeid=0;
		this.Productid=0;
	}
	/**
	 * New segment permission
	 * @param Productid Segment id
	 * @param Typeid Permission id
	 * @param type list of types in domain
	 */
	public ProductType(int Productid,int Typeid){
		this.Productid = Productid;
		this.Typeid = Typeid;
	}

	/**
	 * @return the Productid
	 */
	public int getProductid() {
		return this.Productid;
	}

	/**
	 * @param did the domain id to set
	 */
	public void setProductid(int Productid) {
		this.Productid = Productid;
	}
	
	/**
	 * @return the Typeid
	 */
	public int getTypeid() {
		return this.Typeid;
	}

	/**
	 * @param did the Typeid
	 */
	public void setTypeid(int Typeid) {
		this.Typeid = Typeid;
	}
	
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return (""+getProductid()+getTypeid());
	}

}
