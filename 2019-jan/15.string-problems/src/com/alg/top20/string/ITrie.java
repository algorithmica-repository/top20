package com.alg.top20.string;

import java.util.List;

public interface ITrie {
	void add(String s);
	void remove(String s);
	List<String> autocomplete(String s);
	String lcp(String s);
	void display();
}
