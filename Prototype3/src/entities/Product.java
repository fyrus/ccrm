/**
 * 
 */
package entities;

/**
 * This is the product class
 * @author Yossi

 */
public class Product implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6668057226242752253L;
	
	private int pid;
	private int tid;
	private String pname;
	private String pdescription;
	private String pphoto;
	private float pprice;
	
	/**
	 * empty constructor
	 */
	public Product(){
		pid=0;
		pname="";
		pdescription="";
		pprice=0;
		pphoto="";
	}
	
	/**
	 * constructor with:
	 * @param pid the product id
	 * @param pname the product name
	 * @param pphoto the product photo
	 * @param pdescription the product description
	 * @param pprice the product price
	 */
	public Product(int pid,String pname,String pphoto,String pdescription,float pprice){
		this.pid=pid;
		this.pname=pname;
		this.pdescription=pdescription;
		this.pprice=pprice;
		this.pphoto=pphoto;
	}

	/**
	 * @return the product id
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * @param pid the product id to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * @return the product name
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the product name to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the product description
	 */
	public String getPdescription() {
		return pdescription;
	}

	/**
	 * @param pdescription the product description to set
	 */
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	/**
	 * @return the product price
	 */
	public float getPprice() {
		return pprice;
	}

	/**
	 * @param pprice the product price to set
	 */
	public void setPprice(float pprice) {
		this.pprice = pprice;
	}
	
	/**
	 * @return the product photo
	 */
	public String getPphoto() {
		return pphoto;
	}

	/**
	 * @param pphoto the product photo to set
	 */
	public void setPphoto(String pphoto) {
		this.pphoto = pphoto;
	}

	/**
	 * @return the type id
	 */
	public int getTid() {
		return tid;
	}

	/**
	 * @param tid the type id to set
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	
	

}
