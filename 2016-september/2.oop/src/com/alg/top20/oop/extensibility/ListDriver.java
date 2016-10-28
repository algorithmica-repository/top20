package com.alg.top20.oop.extensibility;

public class ListDriver {
	
	public static void testList(IList list) {
		System.out.println(list.get(0));
	}
	public static void main(String[] args) {
		testList(new ArrayList());
		testList(new LinkedList());
	}

}
