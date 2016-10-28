package com.alg.top20.mt;

class MyInteger {
	private int count;
	
	public MyInteger(int count) {
		this.count = count;
	}
	public void incr() {
		++count;
	}
	public void decr() {
		--count;
	}
	public int get() {
		return count;
	}
}

class Thread1 extends Thread {
	private MyInteger myint;

	public Thread1(MyInteger myint) {
		this.myint = myint;
	}

	@Override
	public void run() {
		myint.incr();
	}	
}

class Thread2 extends Thread {
	private MyInteger myint;

	public Thread2(MyInteger myint) {
		this.myint = myint;
	}

	@Override
	public void run() {
		myint.decr();
	}	
}
public class SharedData {

	public static void main(String[] args) throws Exception {
		MyInteger myint = new MyInteger(10);
		Thread t1 = new Thread1(myint);
		Thread t2 = new Thread2(myint);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(myint.get());
	}

}
