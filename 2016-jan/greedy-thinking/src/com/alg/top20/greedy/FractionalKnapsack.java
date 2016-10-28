package com.alg.top20.greedy;

import java.util.Arrays;
import java.util.Random;

public class FractionalKnapsack {

	public static class Item implements Comparable<Item> {
		Integer quantity;
		Integer profit;
		public Item(Integer quantity, Integer profit) {
			this.quantity = quantity;
			this.profit = profit;
		}
		@Override
		public int compareTo(Item obj2) {
			return -(this.profit - obj2.profit);
		}
		public String toString() {
			return quantity + " " + profit;
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
		int size = Integer.parseInt(args[0]);
		int w = Integer.parseInt(args[1]);
		
		Random r = new Random();		
		Item[] items = new Item[size];
		for(int i = 0; i < size; ++i) {
			int qnt = r.nextInt(100) + 1;
			int prft = r.nextInt(50) + 1;
			items[i] = new Item(qnt, prft);
			System.out.println(items[i]);
		}
		System.out.println(getMaxProfit(items, w));
	}

}
