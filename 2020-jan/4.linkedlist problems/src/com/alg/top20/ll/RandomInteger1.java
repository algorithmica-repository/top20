package com.alg.top20.ll;

public class RandomInteger1 {
    private long a, b, m, seed;
    
    public RandomInteger1() {
    	this(System.currentTimeMillis());
    }
    public RandomInteger1(long seed) {
    	this.seed = seed;
    	this.a = 5;
    	this.b = 7;
    	this.m = 11;
    }
	public int nextInt(int n) {
		seed = (a * seed + b) % m;
		return (int) (seed % n);
	}
	
	public static void main(String[] args) {
		
	}
}
