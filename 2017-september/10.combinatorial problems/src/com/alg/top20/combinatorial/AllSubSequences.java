package com.alg.top20.combinatorial;


public class AllSubSequences {

	public static void displayAllSubSeq1(char[] in) {
		for(int i = 0; i <= 1; ++i) {
			for(int j = 0; j <= 1; ++j) {
				for(int k = 0; k <= 1; ++k) {
					System.out.println( (i==1?in[0]:"") + "" + (j==1?in[1]:"") + "" + (k==1?in[2]:""));
				}
			}
		}
	}
	
	public static void displayAllSubSeq2(char[] in) {
		auxAllSubSeq2(0, in, "");		
	}
	private static void auxAllSubSeq2(int d, char[] in, String prefix) {
		if(d == in.length)  {
			System.out.println(prefix);
			return;
		}
		auxAllSubSeq2(d+1, in, prefix);
		auxAllSubSeq2(d+1, in, prefix+in[d]);
	}
	
	public static void displayAllSubSeq3(char[] in) {
		auxAllSubSeq3(0, in, "");		
	}
	private static void auxAllSubSeq3(int d, char[] in, String prefix) {
		if(d == in.length)  {
			System.out.println(prefix);
			return;
		}
		for(int i = 0; i <= 1; ++i) 
			auxAllSubSeq3(d+1, in, i==0?prefix:(prefix+in[d]) );
	}
	
	public static void main(String[] args) {
		char[] in = args[0].toCharArray();
		displayAllSubSeq3(in);
	}

}
