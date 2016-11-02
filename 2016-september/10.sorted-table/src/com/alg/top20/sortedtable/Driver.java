package com.alg.top20.sortedtable;

public class Driver {

	public static void main(String[] args) {
		ISortedTable table = new SortedTable();
		table.addRow(new Employee(1234, "xyz", 30000));
		table.addRow(new Employee(1000, "abc", 20000));
		table.addRow(new Employee(3456, "axy", 60000));
		table.addRow(new Employee(1111, "pqr", 15000));
		table.addRow(new Employee(4321, "aaa", 15000));
		table.display();
		
		System.out.println(table.retrieveInOrder("ssn"));
		System.out.println(table.retrieveInOrder("name"));
		System.out.println(table.retrieveInOrder("salary"));
	}

}
