package com.alg.top20.sortedtable;

import java.util.List;

public interface ISortedTable {
	void add(TravelsInfo tinfo) throws Exception;
	void addSortedFields(List<String> fields);
	void display(String field);
}
