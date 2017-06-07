package com.alg.top20.oostyle3;

public class Driver {

	public static void main(String[] args) {
		//l is reference to ? type object
		//List l = new List();
		
		//l refers to arraylist object type
		List l = new ArrayList();
		//add method call binds to arraylist add implmentation
		l.add(10);
		l.display();
		
		//l refers to linkedlist object type
		l = new LinkedList();
		//add method call binds to linkedlist add implmentation
		l.add(20);
		l.display();
		
		//l = new String();
		
	}

}
