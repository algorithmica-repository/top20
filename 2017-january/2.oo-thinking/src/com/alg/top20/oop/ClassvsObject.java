package com.alg.top20.oop;

class Dummy {
	int a;
	int b;
	
	public Dummy(int a, int b) {
		this.a = a ;
		this.b = b;
	}
	
	public int sum() {
		return a +b;
	}
	
	public int mul() {
		return a * b;
	}
}
public class ClassvsObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dummy d1 = new Dummy(10,20);
		//d1.init();
		Dummy d2 = new Dummy(30, 40);
		Dummy d3 = new Dummy(1, 5);
		System.out.println(d1.sum());
		System.out.println(d2.sum());
		System.out.println(d3.mul());
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		//d1 = d1 + 1;
	}

}
