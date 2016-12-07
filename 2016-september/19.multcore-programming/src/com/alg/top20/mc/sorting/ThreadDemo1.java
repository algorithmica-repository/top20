package com.alg.top20.mc.sorting;

public class ThreadDemo1 {

	static class Thread1 extends Thread {
		public void run() {
			while (true) {
				System.out.println("Thread1");
			}
		}
	}

	static class Thread2 extends Thread {
		public void run() {
			while (true) {
				System.out.println("Thread2");
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread1();
		Thread t2 = new Thread2();
		t1.start();
		t2.start();
		while(true) {
			System.out.println("main");
		}
	}

}
