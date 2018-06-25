package com.alg.top20.ds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

class ElementComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer left, Integer right) {
		return right.compareTo(left);
	}
	
}
public class Selection {

	public static int selection1(int[] in, int k) {
		Arrays.sort(in);
		return in[k-1];
	}
	public static int selection2(int[] in, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int x: in)
			pq.add(x);
		//System.out.println(pq);
		for(int i = 1; i < k; ++i) 
			pq.remove();
		return pq.remove();
	}
	
	public static int selection3(int[] in, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new ElementComparator());
		int i;
		for(i = 0; i < k; ++i)
			pq.add(in[i]);
		//System.out.println(pq);
		for(;i < in.length; ++i) {
			int tmp = pq.peek();
			if(in[i] < tmp) {
				pq.remove();
				pq.add(in[i]);
			}
			//System.out.println(pq);
		}
		return pq.remove();
	}
	
	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	} 
	private static int partition(int[] in, int l, int r) {
		int lastmin, current;
		for(int j = l; j <= r; ++j)
			System.out.print(in[j] + " ");
		System.out.println();
		for(current = l+1, lastmin= l; current <= r; ++current) {
			if(in[current] < in[l]) {
				swap(in, ++lastmin, current);
			}
		}
		swap(in, lastmin, l);
		for(int j = l; j <= r; ++j)
			System.out.print(in[j] + " ");
		System.out.println("\n"+lastmin);
		System.out.println();
		return lastmin;		
	}
	public static int selection4(int[] in, int k) {
		return auxSelection(in, 0, in.length-1, k);
	}
	//fix the bug
	private static int auxSelection(int[] in, int l, int r, int k) {
		if(l > r) return Integer.MIN_VALUE;
		int p = partition(in, l, r);
		if(k == p+1) return in[p];
		if(k < p+1)
			return auxSelection(in, l, p-1, k);
		else
			return auxSelection(in, p+1, r, k-(p+1));
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int[] in = new int[n];
		Random r = new Random(10);
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		//System.out.println(Arrays.toString(in));
		//System.out.println(selection1(in, k));
		//System.out.println(selection2(in, k));
		//System.out.println(selection3(in, k));
		System.out.println(selection4(in, k));
	}

}
