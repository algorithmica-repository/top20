package com.alg.top20.greedy;

import java.util.Arrays;

public class FractionalKnapsack {

	class Item implements Comparable<Item> {
		Integer id;
		Integer quantity;
		Integer profit;
		public Item(Integer id, Integer quantity, Integer profit) {
			super();
			this.id = id;
			this.quantity = quantity;
			this.profit = profit;
		}
		@Override
		public int compareTo(Item obj2) {
			return -(this.profit - obj2.profit);
		}
	}
	
	public static Integer getMaxProfit(Item[] items, Integer w) {
		int totProfit = 0;
		Arrays.sort(items);
		for(Item item:items) {
			if(item.quantity <= w) {
				totProfit += (item.quantity * item.profit);
				w -= item.quantity;
			} else {
				totProfit += (w * item.profit);
				break;
			}
		}
		return totProfit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
