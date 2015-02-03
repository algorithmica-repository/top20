package com.algorithmica.arrays;

/*Array with size n with every number repeating except 2 numbers 
 * find out the 2 numbers
 * 
 * */
public class FindNonrepeating {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 20, 20, 10, 10, 2, 4 };
		int n = 0;
		int bitposition = 0;
		int h = 0;
		int m = 0;
		for (int i = 0; i < a.length; i++) {
			n ^= a[i];
		}
		System.out.println("XOR of all elements is " + n);
		while (n > 0) {
			if ((n & (1 << bitposition)) > 0)
				break;
			bitposition++;
		}
		for (int i = 0; i < a.length; i++) {
			if ((a[i] & (1 << bitposition)) > 0)
				h = h ^ a[i];
			else
				m = m ^ a[i];
		}
		System.out.println("Non repeated numbers are " + h + " " + m);

	}

}
