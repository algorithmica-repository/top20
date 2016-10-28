package com.alg.top20.mt;


public class ThreadTest2 {

	public static class Dummy1 extends Thread {

		@Override
		public void run() {
			while(true)
				System.out.println("Dummy1");
		}
		
	}
	
	public static class Dummy2 extends Thread {

		@Override
		public void run() {
			while(true)
				System.out.println("Dummy2");
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		Thread t1 = new Dummy1();
		Thread t2 = new Dummy2();
		t1.start();//register run code as separate thread
		t2.start();//register run code as separate thread
		while(true)
			System.out.println("MainThread");

	}

}

