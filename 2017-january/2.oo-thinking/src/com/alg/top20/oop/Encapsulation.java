package com.alg.top20.oop;

class Dummy1 {
	private int a;
	private int b;
	
	public Dummy1(int a, int b) {
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
public class Encapsulation {

	public static void main(String[] args) {
		Dummy1 d1 = new Dummy1(10,20);
		d1.sum();
		d1.mul();
	}

}
