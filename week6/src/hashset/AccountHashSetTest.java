package hashset;

import java.util.HashSet;

public class AccountHashSetTest {
	public static void main (String[] args){
		AccountManagerHashSet manager = new AccountManagerHashSet();
		
		manager.insertAccount("1231", "Paul", 3000.0f);
		manager.insertAccount("1232", "Tomas", 4000.0f);
		manager.insertAccount("1233", "James", 5000.0f);
		manager.insertAccount("1234", "Percy", 5000.0f);
		manager.insertAccount("1231", "Paul2", 5000.0f);
		
		manager.setDeposite("1231",500);
		manager.setDeposite("1232",500);
		manager.setDeposite("1233",500);
		manager.setDeposite("1234",500);
		
		manager.displayAll();
		
		
	}
}