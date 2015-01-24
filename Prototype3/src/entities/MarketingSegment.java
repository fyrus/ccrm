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
public class MarketingSegment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8147489188792153861L;
	
	private int segmentid;
	private int age;
	private int locationid;
	private int importance;
	private int interest;
	private ArrayList<Permission> permission;
	
	
	
	/**
	 * empty constructor
	 */
	public MarketingSegment(){
		segmentid=0;
		age=0;
		locationid=0;
		importance=0;
		interest=0;
		permission=null;
	}

	/**
	 * @param segmentid
	 * @param age
	 * @param locationid
	 * @param importance
	 * @param interest
	 * @param permission
	 */
	public MarketingSegment(int segmentid, int age, int locationid, int importance,
			int interest, ArrayList<Permission> permission) {
		this.segmentid = segmentid;
		this.age = age;
		this.locationid = locationid;
		this.importance = importance;
		this.interest = interest;
		this.permission = permission;
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
	 * @return the locationid
	 */
	public int getLocation() {
		return locationid;
	}

	/**
	 * @param locationid the locationid to set
	 */
	public void setLocation(int locationid) {
		this.locationid = locationid;
	}

	/**
	 * @return the importance
	 */
	public int getImportance() {
		return importance;
	}

	/**
	 * @param importance the importance to set
	 */
	public void setImportance(int importance) {
		this.importance = importance;
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
	public ArrayList<Permission> getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(ArrayList<Permission> permission) {
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
