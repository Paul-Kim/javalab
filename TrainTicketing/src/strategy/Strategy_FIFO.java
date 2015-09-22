package strategy;

import customer.Customer;
import ticketBox.Row;

public class Strategy_FIFO implements Strategy{
	String name = "FIFO";
	
	public String toString(){
		return name;
	}
	
	public Customer getCustomer(Row row) {
		return getCustomer(row, 1).get(0);
	}

	@Override
	public Row getCustomer(Row row, int num) {
		Row result = new Row();

		
		if(row.size() < num)
			num = row.size();
		for(int i=0; i<num; i++){
			result.add(row.get(i));
		}
		return result;
	}
	
}