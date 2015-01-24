/**
 * 
 */
package entities;
import java.util.*;
/**
 * SegmentPermission will contain Segment id and Permission id
 * @author alex
 *
 */
public class SegmentPermission implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5909137016175083636L;
	private int Segmentid;
	private int Permissionid;
	
	/**
	 * Default constructor - blank segment permission
	 */
	public SegmentPermission(){
		this.Permissionid=0;
		this.Segmentid=0;
	}
	/**
	 * New segment permission
	 * @param Segmentid Segment id
	 * @param Permissionid Permission id
	 * @param type list of types in domain
	 */
	public SegmentPermission(int Segmentid,int Permissionid){
		this.Segmentid = Segmentid;
		this.Permissionid = Permissionid;
	}

	/**
	 * @return the Segmentid
	 */
	public int getSegmentid() {
		return this.Segmentid;
	}

	/**
	 * @param did the domain id to set
	 */
	public void setSegmentid(int Segmentid) {
		this.Segmentid = Segmentid;
	}
	
	/**
	 * @return the Permissionid
	 */
	public int getPermissionid() {
		return this.Permissionid;
	}

	/**
	 * @param did the Permissionid
	 */
	public void setPermissionid(int Permissionid) {
		this.Permissionid = Permissionid;
	}
	
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return (""+getPermissionid()+getSegmentid());
	}

}
