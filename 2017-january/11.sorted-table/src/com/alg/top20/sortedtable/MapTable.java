package com.alg.top20.sortedtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapTable implements ISortedTable {
	private LinkedList<TravelsInfo> list;
	private HashMap<String, TreeMap<Float,TravelsInfo>> indexes;
	
	public MapTable() {
		list = new LinkedList<TravelsInfo>();
		indexes = new HashMap<String, TreeMap<Float,TravelsInfo>>();
	}

	@Override
	public void add(TravelsInfo tinfo) throws Exception {
		list.add(tinfo);
		for(String key: indexes.keySet()) {
			indexes.get(key).put(tinfo.getValue(key), tinfo);
		}

	}

	@Override
	public void display(String field) {
		TreeMap<Float, TravelsInfo> index = indexes.get(field);
		for(Float key: index.keySet())
			System.out.println(index.get(key));
	}
	
	public void display() {
		for(TravelsInfo t: list)
			System.out.println(t);
	}

	@Override
	public void addSortedFields(List<String> fields) {
		for(String field: fields) {
			TreeMap<Float, TravelsInfo> index = new TreeMap<Float, TravelsInfo>();
			indexes.put(field, index);
		}
		
	}

}
