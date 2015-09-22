package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import customer.Customer;
import customer.CustomerList;
import strategy.Strategy;
import ticketBox.Platform;
import ticketBox.Row;
import ticketBox.RowForTicket;
import ticketBox.TicketCenter;

public class TestModule extends Thread{
	final int TIME_MAX = 200;
	int ticketer = 3;
	String fileName;
	int time;
	Strategy strategy;
	CustomerList customerList;
	
	public TestModule(String fileName,Strategy strategy){
		this.fileName = fileName;
		this.time = 0;

		//load customer list
		customerList = new CustomerList(fileName);
		this.strategy = strategy;
	}

	
	public void run(){
		System.out.println(this.toString()+"\tTicketing start");
		 
		RowForTicket ticketRow = new RowForTicket();
		Platform platform = new Platform();
		TicketCenter office = new TicketCenter(ticketer, strategy);

		//custommer comming start.
		while(customerList.isAllFinished() == false){
			//treat customer
			System.out.println(this.toString()+"\tProceeding... time : "+ time);
			proceeding(platform, ticketRow, office);
			
			//time is going on....
			timespend();	
		}

		System.out.println(this.toString()+"\tTicketing finished");
		
		
		//printing file;
		try {
			printSummaryToFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	private void proceeding(Platform platform, RowForTicket ticketRow, TicketCenter office){
		//finished Customer => platform
		office.treatCustomer(platform);
		
		// platform -> train
		if(time % 3  == 2){
			Row train =  new Row();
			trainCome();
			platform.getTrain(train);
			customerList.checkCustomerList();
		}
		
		// new customer arrived
		customerList.newCustomersCome(ticketRow);
		
		// change customer
		office.changeCustomer(customerList, ticketRow);
		
		//treat finished customer
		customerList.finishedCustomersGo();
	}
	
	private void trainCome(){
		System.out.println(this.toString()+"\tA train comes.");
	}
	
	private void timespend(){
		this.time++;
		customerList.timeSpend();
		try {
			sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void printSummaryToFile() throws IOException {
		String outfileName = "";
		BufferedWriter br = null;
		String line = "";
		
		outfileName += "report";
		outfileName += this.strategy.toString();
		outfileName += ".txt";
		
		try {
			br = new BufferedWriter(new FileWriter(outfileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<Customer> i = this.customerList.iterator();
		while(i.hasNext()){
			Customer c = i.next();
			line = "";
			line += c.toString();
			
			br.write(line);
			br.newLine();
		}
		
		line = "Elapsed time : "+this.time;
		br.write(line);
		br.newLine();
		line = "sum of waiting time for ticket : "+customerList.getTotalWaitForTicket();
		br.write(line);
		br.newLine();
		line = "sum of waiting time for Train : "+customerList.getTotalWaitForTrain();
		br.write(line);
		br.newLine();
		line  ="TOTAL wait :"+customerList.getTotalWait();
		br.write(line);
		br.newLine();
		
		br.close();
	}

}