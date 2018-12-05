package com.alg.top20.greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
	int quantity;
	int profit;
	
}
class MyComparator implements Comparator<Item> {

	@Override
	public int compare(Item i1, Item i2) {
		return i2.profit - i1.profit;
	}
	
}
public class FractionalKnapsack {

	public static int maxProfit(Item[] items, int w) {
		Arrays.sort(items, new MyComparator());
		int profit = 0;
		for(Item item: items) {
			if(item.quantity <= w) {
				profit += (item.quantity * item.profit);
				w = w - item.quantity;
			} else {
				profit += (w * item.profit);
				break;
			}
		}
		return profit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
