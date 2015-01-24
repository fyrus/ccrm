/**
 * 
 */
package entities;

/**
 * this class will define user
 * @author Yossi
 */
public class User implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1774519195002151807L;
	private int uid;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String role;
	private boolean loggedin;
	
	/**
	 * Default empty constructor
	 */
	public User(){
		uid=0;
		password="";
		name="";
		address="";
		phone="";
		loggedin=false;
		role="";
	}
	
	/**
	 * New user constructor
	 * @param uid user id
	 * @param name user name
	 * @param password use password
	 * @param address user address
	 * @param phone user phone
	 */
	public User(int uid,String name,String password,String address,String phone){
		this.uid=uid;
		this.name=name;
		this.password=password;
		this.address=address;
		this.phone=phone;
		loggedin=false;
		role="";
	}
	/**
	 * Copy user constructor
	 * @param u User to copy from
	 */
	public User(User u){
		this.uid=u.uid;
		this.name=u.name;
		this.password=u.password;
		this.address=u.address;
		this.phone=u.phone;
		loggedin=false;
		role=u.role;
	}
	

	/**
	 * @return the user id
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uid the user id to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the loggedin 
	 */
	public boolean isLoggedin() {
		return loggedin;
	}

	/**
	 * @param loggedin the loggedin to set
	 */
	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
	
	/**
	 * set user login
	 */
	public void userLogin()
	{
		loggedin=true;
	}
	
	/**
	 * set user logout
	 */
	public void userLogout()
	{
		this.loggedin = false;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return (getName());
	}

	

}
