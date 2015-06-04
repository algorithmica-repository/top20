package com.alg.top20.hashmap;

public class TestMyHashMap {

	 public static void main(String[] args) { 
	        String test = "A L G O R I T H M I C A"; 
	        String[] keys = test.split(" "); 
	        int N = keys.length; 
	        MyHashMap<String, Integer> st = new MyHashMap<String, Integer>();
	        for (int i = 0; i < N; i++) 
	            st.put(keys[i], i);
	        
	        System.out.println("The elements of hashmap at start:");
	        for (String s : st.keys()) 
	            System.out.println(s + " " + st.get(s));
	        
	        st.remove("A");
	        
	        System.out.println("The elements of hashmap after removing string A:");
	        for (String s : st.keys()) 
	            System.out.println(s + " " + st.get(s));
	        
	 }
	 
}
