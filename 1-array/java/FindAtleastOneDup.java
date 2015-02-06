package com.algorithmica.arrays;

/*
 * Given an array of size n and numbers in the range of 1 to n-1.Find any one duplicate 
 * that is present in array*/
public class FindAtleastOneDup {

	public static void main(String[] args) {
		int a[] = { 2, 1, 3, 4, 2 };
		System.out.println(findAtleastOnedup(a));
		System.out.println(findAtleastOnedup1(a));

	}

	// solution using swapping technique and here drawback is input is shuffling
	static int findAtleastOnedup(int a[]) {
		int j = 0;
		int temp;
		while (j < a.length - 1) {
			if (a[a[0]] == a[0])
				return a[0];
			else {
				temp = a[a[0]];
				a[a[0]] = a[0];
				a[0] = temp;
			}
			j++;
		}
		return -1;
	}

	// Using negation trick.Here at the end if we want we can make all elements
	// to positive
	static int findAtleastOnedup1(int a[]) {
		int n = a.length;
		for (int i = 0; i < n; i++)
			if (a[Math.abs(a[i])] < 0)
				return Math.abs(a[i]);
			else
				a[Math.abs(a[i])] *= -1;
		return -1;
	}

}
