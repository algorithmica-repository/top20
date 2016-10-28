package com.alg.top20.memory;

public class MemorySegments {
	
	public static void testStack() {
		try {
			testStack();
		} catch(StackOverflowError e) {
			System.out.println(e.getStackTrace().length);
		}
	}
	
	public static void testCores() {
		Runtime r = Runtime.getRuntime();
		System.out.println(r.availableProcessors());
	}

	public static void testHeap() {
		Runtime r = Runtime.getRuntime();
		r.gc();
		System.out.println(r.freeMemory());
		byte[] b1 = new byte[1000000000];
		System.out.println(r.freeMemory());
		byte[] b2 = new byte[1000000000];
		System.out.println(r.freeMemory());
	}
	public static void main(String[] args) {
		testHeap();
		testStack();
		testCores();
	}

}
