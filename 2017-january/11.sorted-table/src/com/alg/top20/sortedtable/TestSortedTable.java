package com.alg.top20.sortedtable;

import java.util.ArrayList;

public class TestSortedTable {

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(args[0]);
		
		MapTable table = new MapTable();
		ArrayList<String> sfields = new ArrayList<String>();
		sfields.add("fare");
		sfields.add("nseats");
		//sfields.add("rating");
		table.addSortedFields(sfields);
		
		for(int i = 0; i < n; ++i) {
			String tname = "Travels" + (i+1);
			float fare = 10.0f + i;
			int nseats = 40 - i;
			int rating = i % 6;
			TravelsInfo tmp = new TravelsInfo(tname, fare, nseats, rating);
			table.add(tmp);
		}
		table.display();
		System.out.println();
		table.display("nseats");
		System.out.println();
		table.display("fare");
	}

}
