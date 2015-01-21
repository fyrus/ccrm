package entities;
/**
 * This class is the report class
 * has report number and date
 * @author Dima
 * 
 */
public class AbstractReport implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6212928359226427978L;
	private int rid;
	private String rdate;
	
	/**
	 * Default blank constructor
	 */
	public AbstractReport(){
		this.rid=0;
		this.rdate="";
	}
	
	/**
	 * Constructor with id and date of the report
	 * @param id
	 * @param date
	 */
	public AbstractReport(int id,String date){
		this.rid=id;
		this.rdate=date;
	}
	/**
	 * Gets report id
	 */
	public int getRid(){
		return this.rid;
	}
	
	/**
	 * Sets the report id
	 * @param id reports id number
	 */
	public void setRid(int id){
		this.rid=id;
	}
	
	/**
	 * Gets report date
	 */
	public String getRdate(){
		return this.rdate;
	}
	
	/**
	 * Sets the report date
	 * @param date reports date
	 */
	public void setRid(String date){
		this.rdate=date;
	}

}
