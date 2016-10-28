package com.alg.top20.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class FileMerge {

	public static int getMinMergeCost1(int[] files) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int e : files) {
			list.add(e);
		}
		int total = 0;
		while (list.size() > 1) {
			Collections.sort(list);
			int tmp = list.removeFirst() + list.removeFirst();
			total = total + tmp;
			list.add(tmp);
		}
		return total;
	}

	public static int getMinMergeCost2(int[] files) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int e : files) {
			pq.add(e);
		}
		int total = 0;
		while (pq.size() > 1) {
			int tmp = pq.remove() + pq.remove();
			total = total + tmp;
			pq.add(tmp);
		}
		return total;
	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int[] files = new int[size];
		Random r = new Random(100);
		for (int i = 0; i < size; ++i) {
			files[i] = r.nextInt(100) + 1;
		}
		System.out.println(Arrays.toString(files));
		System.out.println(getMinMergeCost2(files));

	}

}
