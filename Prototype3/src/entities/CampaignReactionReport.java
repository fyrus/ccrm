/**
 * 
 */
package entities;
import java.util.*;

/**
 * Campaign Reaction Report
 * @author Dima
 *
 */
public class CampaignReactionReport extends AbstractReport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8076429585980904966L;
	
	/*id number of the campaign*/
	private int cmpId;
	/*number of potential clients*/
	private int numOfPotentialClients;
	/* hours spent on phones*/
	private float timeSpentOnCalls;
	/*number of sells*/
	private int numOfSellEvents;
	/*costumer comments*/
	private List<String> nonPurchaseComments;
	
	/**
	 * Default blank constructor
	 */
	public CampaignReactionReport(){
		super();
		this.cmpId=0;
		this.numOfPotentialClients=0;
		this.timeSpentOnCalls=0;
		this.numOfSellEvents=0;
		this.nonPurchaseComments=null;
	}
	/**
	 * Constructor of the report 
	 * @param rid report id
	 * @param date report date
	 * @param cmpid campaign id 
	 * @param poten number of potential clients
	 * @param time hours spent on phones
	 * @param sell number of sells
	 * @param comments costumer comments
	 */
	public CampaignReactionReport(int rid,String date,int cmpid,int poten,float time,int sell,List<String> comments){
		super(rid,date);
		this.cmpId=cmpid;
		this.numOfPotentialClients=poten;
		this.timeSpentOnCalls=time;
		this.numOfSellEvents=sell;
		this.nonPurchaseComments=new ArrayList<String>(comments); 
	}
	/**
	 * 
	 * @return int - campaign id
	 */
	public int getCmpId() {
		return cmpId;
	}
	/**
	 * Set campaign id
	 * @param cmpId campaign id
	 */
	public void setCmpId(int cmpId) {
		this.cmpId = cmpId;
	}
	/**
	 * 
	 * @return int - number of potential clients
	 */
	public int getNumOfPotentialClients() {
		return numOfPotentialClients;
	}
	/**
	 * Set number of potential clients
	 * @param numOfPotentialClients number of potential clients
	 */
	public void setNumOfPotentialClients(int numOfPotentialClients) {
		this.numOfPotentialClients = numOfPotentialClients;
	}
	/**
	 * 
	 * @return float - the hours spent on phones
	 */
	public float getTimeSpentOnCalls() {
		return timeSpentOnCalls;
	}
	/**
	 * Set the hours spent on phones
	 * @param timeSpentOnCalls hours spent on phones
	 */
	public void setTimeSpentOnCalls(float timeSpentOnCalls) {
		this.timeSpentOnCalls = timeSpentOnCalls;
	}
	/**
	 * 
	 * @return int - number of sell events
	 */
	public int getNumOfSellEvents() {
		return numOfSellEvents;
	}
	/**
	 * Set the number of sell events
	 * @param numOfSellEvents number of sell events
	 */
	public void setNumOfSellEvents(int numOfSellEvents) {
		this.numOfSellEvents = numOfSellEvents;
	}
	/**
	 * 
	 * @return List<.String> - non purchase comments from costumers 
	 */
	public List<String> getNonPurchaseComments() {
		return nonPurchaseComments;
	}
	/**
	 * Set a list of comments
	 * @param nonPurchaseComments list of comments
	 */
	public void setNonPurchaseComments(List<String> nonPurchaseComments) {
		this.nonPurchaseComments = nonPurchaseComments;
	}
	/**
	 * Add comment to list
	 * @param cmnt comment to add
	 */
	public void addNonPurchaseComments(String cmnt){
		this.nonPurchaseComments.add(cmnt);
	}
	
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return ("("+getCmpId()+") ");
	}
	
	

}
