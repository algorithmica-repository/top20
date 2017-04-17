package com.alg.top20.parallelism.mt.threads;

class DummyThread1 extends Thread {	
	public void run() {
		for(int i  = 1; i <= 100; ++i) {
			long id = Thread.currentThread().getId();
			System.out.println(id +":"+ i);
		}
	}	
}

class DummyThread2 extends Thread {	
	public void run() {
		for(int i  = 101; i <= 200; ++i) {
			long id = Thread.currentThread().getId();
			System.out.println(id +":"+ i);
		}
	}	
}

public class ThreadDemo {
	
	public static void main(String[] args) {
		Thread t1 = new DummyThread1();
		Thread t2 = new DummyThread1();
		Thread t3 = new DummyThread2();
		Thread t4 = new DummyThread2();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
