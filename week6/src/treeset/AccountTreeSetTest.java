package treeset;

import java.util.TreeSet;

public class AccountTreeSetTest {
	public static void main (String[] args){
		AccountManagerTreeSet manager = new AccountManagerTreeSet();
		
		manager.insertAccount("1231", "Paul", 3000.0f);
		manager.insertAccount("1232", "Tomas", 4000.0f);
		manager.insertAccount("1233", "James", 5000.0f);
		manager.insertAccount("1234", "Percy", 6000.0f);
		manager.insertAccount("1235", "Elizabeth", 7000.0f);
		
		manager.setDeposite("1231",500);
		manager.setDeposite("1232",500);
		manager.setDeposite("1233",500);
		manager.setDeposite("1234",500);
		manager.setDeposite("1235",500);
		
		manager.displayAll();
		
	}
}