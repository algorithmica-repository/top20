package com.alg.top20.sortedtable;

import java.util.List;

public interface ISortedTable {
	void addRow(Employee e);
	List<Employee> retrieveInOrder(String column);
	void display();
	boolean removeRow();
}
