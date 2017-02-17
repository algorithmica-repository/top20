package com.alg.top20.oop;

interface IList {
	Integer get(int index);
}

class ArrayList implements IList {
	private int[] array;
	private int size;
	
	public ArrayList() {
		
	}

	public Integer get(int index) {
		if(index >= size) return null;
		return array[index];
	}	
}

class LinkedList implements IList {

	@Override
	public Integer get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
public class Encapsulation2 {
	
	//client depends on interfaces(encapsulated implementations)
	//list is polymorphic variable i.e., it can hold address of either ArrayList or LinkedList object
	public static void testList(IList list) {
		//get method call will be attached to either ArrayList's get or LinkedList's get at runtime
		System.out.println(list.get(0));
		System.out.println(list);
	}

	public static void main(String[] args) {
		//use DI frameworks
		testList(new ArrayList());
		testList(new LinkedList());
	}

}
