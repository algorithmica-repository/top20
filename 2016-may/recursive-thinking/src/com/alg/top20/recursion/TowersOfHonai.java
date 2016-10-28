package com.alg.top20.recursion;

public class TowersOfHonai {

	public static void honai(int n, char src, char aux, char target) {
		if(n==1) {
			System.out.println(src + "->" + target);
			return;
		}
		honai(n-1,src,target,aux);
		System.out.println(src + "->" + target);
		honai(n-1,aux,src,target);
	}
	
	public static void main(String[] args) {
		honai(4, 'A', 'B', 'C');
	}

}
