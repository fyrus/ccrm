/**
 * 
 */
package entities;

/**
 * This is the location class
 * @author Yossi
 *
 */


public class Location implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9063762680653706777L;
	private int lid;
	private String location;

	/**
	 * Empty constructor
	 */
	public Location(){
		lid=0;
		location="";
	}

	/**
	 * constructor with:
	 * @param lid the location id
	 * @param location
	 */
	public Location(int lid,String location){
		this.lid=lid;
		this.location=location;
	}
	/**
	 * @return the location id
	 */
	public int getLid() {
		return lid;
	}
	/**
	 * @param lid the location id to set
	 */
	public void setLid(int lid) {
		this.lid = lid;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return getLocation();
	}

}
