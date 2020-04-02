package com.collections.test;

/**
 * @author	Srinivas Reddy
 * @Email	srinivas96alluri@gmail.com
 */

import java.util.Arrays;
import com.collections.HashMap;

public class HMapApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] elements = { 15, 12, 21, 6, 11, 18, 12, 98 };

		HashMap<Integer, Integer> hmap;
		hmap = new HashMap<>();

		for (int i = 0; i < elements.length; i++) {
			hmap.set((2 * i + 2), elements[i]);
		}
		
		System.out.println("Array form = " + Arrays.toString(elements));
		System.out.println("Map form = " + hmap.toString());
		
		System.out.println("hmap.set(14, 35)");
		hmap.set(14, 35);
		System.out.println("Map form = " + hmap.toString());

		System.out.println("hmap.set(5, 31)");
		hmap.set(5, 31);
		System.out.println("Map form = " + hmap.toString());

		System.out.println("hmap.set(35, 39)");
		hmap.set(35, 39);
		System.out.println("Map form = " + hmap.toString());

	}

}
