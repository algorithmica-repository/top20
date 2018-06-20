package com.alg.top20.ds;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

class FrequencyComparator implements Comparator<Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> left, Entry<String, Integer> right) {
		return right.getValue() - left.getValue();
	}
	
}
public class WordsByFrequency {

	public static void wordsByFreq1(String[] words) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String word: words) {
			Integer tmp = map.get(word);
			if(tmp == null)
				map.put(word, 1);
			else
				map.put(word, tmp+1);
		}
		ArrayList<Entry<String,Integer> > list = new ArrayList<Entry<String, Integer>>();
		for(Entry<String, Integer> entry:map.entrySet()) {
			list.add(entry);
		}
		Collections.sort(list, new FrequencyComparator());
		System.out.println(list);
	}
	public static void main(String[] args) {
		String[] words = {"abc", "abc", "abc", "xyz","xyz", "axy","pqr"};
		wordsByFreq1(words);
	}

}
