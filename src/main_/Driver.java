package main_;
/*  Driver for program to test Queue/LinkedList
*/    

import data_structures.*;

public class Driver {
	private Queue<Integer> list;


	public Driver() {
	    list =  new Queue<Integer>();
	    runTests();
	    }
    
	private void runTests() {
		
		//Adding 10 new Integer objects to the queue
	    for(int i=1; i <= 20; i++){
	    	System.out.println("Adding: " + i + " to our Queue");
	        list.enqueue(i);
	    } 
	    
	    System.out.println("");
	    System.out.println("Element at the front: " + list.peek());
	    System.out.println("Element contained in queue: " + list.size());
	    
	    //Removing top 5 elements in the queue
	    for(int i=1; i<= 5; i++){
	    	list.dequeue();
	    }
	    
	    System.out.println("");
	    System.out.println("Element at the front: " + list.peek());
	    System.out.println("Element contained in queue: " + list.size());
	    
	    System.out.println("");
	    System.out.println("Is the Queue Empty? " + list.isEmpty());
  
}

public static void main(String [] args) {
    new Driver();
    }
}