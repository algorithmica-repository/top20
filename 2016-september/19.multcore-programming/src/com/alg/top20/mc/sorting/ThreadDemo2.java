package com.alg.top20.mc.sorting;

public class ThreadDemo2 {
	
	static class MyThread extends Thread {
		private int id;
		
		MyThread(int id) {
			this.id = id;
		}
		public void run() {
			while (true) {
				System.out.println("Thread" + id);
			}
		}
	}
	
	public static void main(String[] args) {
		MyThread[] threads = new MyThread[100];
		for(int i = 0; i < 100; ++i) {
			threads[i] = new MyThread(i);
			threads[i].start();
		}
			
	}
}
