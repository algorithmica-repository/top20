package com.alg.top20.mc.sorting;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadResourceSharing {

	static class Thread1 extends Thread {
		private ConcurrentHashMap<Integer, String> map;

		public Thread1(ConcurrentHashMap<Integer, String> map) {
			super();
			this.map = map;
		}
		
		public void run() {
			map.put(10,"abc");
			map.put(20, "def");
		}
	}
	
	static class Thread2 extends Thread {
		private ConcurrentHashMap<Integer, String> map;

		public Thread2(ConcurrentHashMap<Integer, String> map) {
			super();
			this.map = map;
		}
		
		public void run() {
			System.out.println(map.remove(10));
		}
	}
	public static void main(String[] args) {
		//Hashmap is not thread safe
		//HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//Concurrent hashmap is thread-safe
		ConcurrentHashMap<Integer, String> cmap = new ConcurrentHashMap<Integer, String>();
		Thread t1 = new Thread1(cmap);
		Thread t2 = new Thread2(cmap);
		t1.start();
		t2.start();
	}

}
