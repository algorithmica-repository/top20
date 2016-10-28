package com.alg.top20.genericlist;

public class TestList {
	
	public static void test1(IList<Integer> list) {
		list.add(10);
		list.add(20);
		list.display();
	}

	public static void main(String[] args) {
	    ArrayList<Integer> al = new ArrayList<Integer>();
	/*	al.add(10);
			al.add(20);
		al.display(); */
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		/*ll.add(40);
		ll.add(50);
		ll.display();*/
		test1(al);
		test1(ll);
	}

}
