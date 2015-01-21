/**
 * 
 */
package entities;

import java.util.*;

/**
 * This is the Marketing Segment class.
 * @author Yossi
 *
 */
public class MarketSegment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8147489188792153861L;
	
	private int msid;
	private int age;
	private String location;
	private int c_rate;
	private int interest;
	private List<Permission> permission;
	
	
	
	/**
	 * empty constructor
	 */
	public MarketSegment(){
		msid=0;
		age=0;
		location="";
		c_rate=0;
		interest=0;
		permission=null;
	}

	/**
	 * @param msid
	 * @param age
	 * @param location
	 * @param c_rate
	 * @param interest
	 * @param permission
	 */
	public MarketSegment(int msid, int age, String location, int c_rate,
			int interest, List<Permission> permission) {
		this.msid = msid;
		this.age = age;
		this.location = location;
		this.c_rate = c_rate;
		this.interest = interest;
		this.permission = permission;
	}

	/**
	 * @return the msid
	 */
	public int getMsid() {
		return msid;
	}

	/**
	 * @param msid the msid to set
	 */
	public void setMsid(int msid) {
		this.msid = msid;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
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
	 * @return the c_rate
	 */
	public int getC_rate() {
		return c_rate;
	}

	/**
	 * @param c_rate the c_rate to set
	 */
	public void setC_rate(int c_rate) {
		this.c_rate = c_rate;
	}

	/**
	 * @return the interest
	 */
	public int getInterest() {
		return interest;
	}

	/**
	 * @param interest the interest to set
	 */
	public void setInterest(int interest) {
		this.interest = interest;
	}

	/**
	 * @return the permission
	 */
	public List<Permission> getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}
	
	/**
	 * add permission to array
	 * @param permission
	 */
	public void AddPermission(Permission permission){
		this.permission.add(permission);
	}
	
}
