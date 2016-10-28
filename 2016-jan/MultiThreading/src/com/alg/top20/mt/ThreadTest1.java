package com.alg.top20.mt;

public class ThreadTest1 {

	public static class Dummy1 extends Thread {

		@Override
		public void run() {
			for(int i = 0; i <= 50; ++i)
				System.out.println(i);
		}
		
	}
	
	public static class Dummy2 extends Thread {

		@Override
		public void run() {
			for(int i = 51; i <= 100; ++i)
				System.out.println(i);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		Thread t1 = new Dummy1();
		Thread t2 = new Dummy2();
		t1.start();//register run code as separate thread
		t2.start();//register run code as separate thread
		for(int i = 101; i <= 150; ++i)
			System.out.println(i);

	}

}
