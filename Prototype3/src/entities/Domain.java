/**
 * 
 */
package entities;
import java.util.*;
/**
 * The domain will contain product types, and will be a part of the catalog
 * @author Dima
 *
 */
public class Domain implements java.io.Serializable{
	private int did;
	private String dName;
	private List<Type> typeList;
	
	/**
	 * Default constructor - blank registered customer
	 */
	public Domain(){
		this.did=0;
		this.dName="";
		this.typeList=null;
	}
	/**
	 * New domain constructor
	 * @param id domain id
	 * @param name domain name
	 * @param type list of types in domain
	 */
	public Domain(int id,String name,List<Type> type){
		this.did=id;
		this.dName=name;
		this.typeList=new ArrayList<Type>(type);
	}
	
	/**
	 * adds a new type to the domain
	 * @param t type
	 */
	public void addType(Type t){
		typeList.add(t);
	}
	/**
	 * 
	 * @return all types of the domain
	 */
	public List<Type> getTypes(){
		return typeList;
	}
	/**
	 * Clears the list of types
	 */
	public void clearTypes(){
		this.typeList.clear();
	}

	/**
	 * @return the domain id
	 */
	public int getDid() {
		return did;
	}

	/**
	 * @param did the domain id to set
	 */
	public void setDid(int did) {
		this.did = did;
	}

	/**
	 * @return the domain Name
	 */
	public String getdName() {
		return dName;
	}

	/**
	 * @param dName the domain name to set
	 */
	public void setdName(String dName) {
		this.dName = dName;
	}

	/**
	 * @param typeList the typeList to set
	 */
	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}
	

}
