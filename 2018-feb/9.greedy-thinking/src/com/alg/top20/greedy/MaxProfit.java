package com.alg.top20.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MaxProfit {

	static class Item {
		int quantity;
		int profit;
		Item(int quantity, int profit) {
			this.quantity = quantity;
			this.profit = profit;
		}
		public String toString() {
			return "(" + quantity +","+profit +")";
		}
	}
	static class ProfitComparator implements Comparator<Item> {

		@Override
		public int compare(Item left, Item right) {
			return right.profit - left.profit;
		}
		
	}
	public static int maxProfit1(Item[] items, int w) {
		Arrays.sort(items, new ProfitComparator());
		int maxprofit = 0;
		for(int i = 0; i < items.length; ++i) {
			if(items[i].quantity <= w) {
				maxprofit += items[i].quantity * items[i].profit;
				w = w - items[i].quantity;
			} else {
				maxprofit += w * items[i].profit;
				break;
			}				
		}
		return maxprofit;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random(100);
		Item[] items = new Item[n];
		for(int i = 0; i < n; ++i) {
			int quantity = r.nextInt(10) + 1;
			int profit = r.nextInt(10) + 1;
			Item item = new Item(quantity, profit);
			items[i] = item;
		}
		for(Item item: items)
			System.out.println(item);
		int w = Integer.parseInt(args[1]);
		System.out.println(maxProfit1(items, w));
	}

}
