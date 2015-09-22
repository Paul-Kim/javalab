package ticketBox;

import customer.Customer;

public class Ticketer {
	Customer myCustomer;
	public void reciveCustomer(Customer newCustomer, RowForTicket ticketRow){
		if(myCustomer == null){
			this.myCustomer = newCustomer;
			this.myCustomer.gotoTicketer();
		}else if(myCustomer == newCustomer){
			return;
		}else{
			changeCustomer(newCustomer, ticketRow);
		}

	}
	
	private void changeCustomer(Customer newComer, RowForTicket ticketRow){
		if(myCustomer == null)
			return;
		myCustomer.gotoQue(ticketRow);
		myCustomer = newComer;
		myCustomer.gotoTicketer();
	}
	
	public void treatCustomer(Platform platform){
		if(myCustomer != null && myCustomer.isTicketed()){
			myCustomer.gotoPlatform(platform);
			myCustomer = null;
		}
	}
}