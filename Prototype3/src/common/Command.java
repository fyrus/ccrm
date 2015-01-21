package common;

public class Command implements java.io.Serializable{
	/**
	 *  A class that contain the value for the server and the type of command to carry
	 */
	private static final long serialVersionUID = 1L;
	
	private Com com;	//the command we wanna tell the server to do (com is enum)
	private String[] extra;	//extra commands or values the server need to get
	private Object value;	//the object we send to the server like User or Item
	
	//command constructor
	public Command(){
		this.com = null;
		this.extra = new String[2];
		this.value = null;
	}
	
	//setters and getters
	/**
	 * set the type of command
	 * @param com the Enum command
	 */
	public void setComNum(Com com){
		this.com = com;
		
	}
	
	public void setComVal(Object v){
		
		this.value=v;
	}
	/**
	 * set the extra info for searches
	 * @param extra1 name,id, etc...
	 * @param extra2
	 */
	public void setComExtra(String extra1, String extra2){

		this.extra[0] = extra1;
		this.extra[1] = extra2;
	}

	public Com getCom(){
		return this.com;
	}
	
	public String[] getExtra(){
		return this.extra;
	}
	
	public Object getValue(){
		return this.value;
	}
	
	

}