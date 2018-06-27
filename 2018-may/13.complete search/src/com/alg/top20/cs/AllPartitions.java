package com.alg.top20.cs;

public class AllPartitions {
	public static void partitions11(String in) {
		auxPartitions11(0, in, "");
	}
	private static void auxPartitions11(int start, String in, String path)  {
		if(start == in.length()) {
			System.out.println(path);
			return;
		}
		for(int i = start; i < in.length(); ++i) {
			String tmp = in.substring(start, i+1);
			auxPartitions11(i+1, in, path+ "+" + tmp);
		}
	}
	
	public static void partitions12(String in) {
		auxPartitions12(in, "");
	}
	private static void auxPartitions12(String in, String path)  {
		if(in.length() == 0) {
			System.out.println(path);
			return;
		}
		for(int i = 0; i < in.length(); ++i) {
			String tmp = in.substring(0, i+1);
			auxPartitions12(in.substring(i+1), path+ "+" + tmp);
		}
	}
	public static void main(String[] args) {
		partitions12(args[0]);

	}

}
