package com.alg.top20.sortedtable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortedTable implements ISortedTable {
	private DLinkedList list;
	private TreeMap<Integer, DListNode> index_ssn;
	private TreeMap<String, DListNode> index_name;
	private TreeMap<Float, DListNode> index_salary;

	public SortedTable() {
		list = new DLinkedList();
		index_ssn = new TreeMap<Integer, DListNode>();
		index_name = new TreeMap<String, DListNode>();
		index_salary = new TreeMap<Float, DListNode>();
	}

	@Override
	public void addRow(Employee e) {
		DListNode node = list.addLast(e);
		index_ssn.put(e.getSsn(), node);
		index_name.put(e.getName(), node);
		index_salary.put(e.getSalary(), node);
	}

	@Override
	public List<Employee> retrieveInOrder(String column) {
		List<Employee> employees = new ArrayList<Employee>();
		if(column.equals("ssn")) {
			Iterator<Entry<Integer, DListNode>> entries = index_ssn.entrySet().iterator();
			while(entries.hasNext()) {
				employees.add(entries.next().getValue().value);
			}			
		} else if(column.equals("name")) {
			Iterator<Entry<String, DListNode>> entries = index_name.entrySet().iterator();
			while(entries.hasNext()) {
				employees.add(entries.next().getValue().value);
			}
		} else if(column.equals("salary")) {
			Iterator<Entry<Float, DListNode>> entries = index_salary.entrySet().iterator();
			while(entries.hasNext()) {
				employees.add(entries.next().getValue().value);
			}
		} else {
			System.out.println("Invalid column");
			return null;
		}			
		return employees;
	}

	@Override
	public void display() {
		list.print();
	}

	@Override
	public boolean removeRow() {
		// TODO Auto-generated method stub
		return false;
	}

}
