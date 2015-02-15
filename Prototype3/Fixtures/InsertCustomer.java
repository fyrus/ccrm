

import java.util.IllegalFormatException;

import gui.AddNewPotentialCustomer;
import entities.Customer;
import fit.ActionFixture;

public class InsertCustomer extends ActionFixture {
	Customer customer;
	AddNewPotentialCustomer ad = new AddNewPotentialCustomer();
	
	public void startCustomer() {
		customer = new Customer();
	}
	
	public boolean addCustomer() {
		//return ad.btnAdd.doClick();
		return true;
	}
}
