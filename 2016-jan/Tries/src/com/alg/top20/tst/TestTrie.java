package com.alg.top20.tst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class TestTrie {

	public static void main(String[] args) throws Exception {
		String line = null;
		TernarySearchTree tst = new TernarySearchTree();
		File file = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((line = br.readLine())!=null) {
			StringTokenizer tokens = new StringTokenizer(line);
			while(tokens.hasMoreTokens()) {
				tst.add(tokens.nextToken().toLowerCase());
			}				
		}
		br.close();
		System.out.println(tst.autocomplete(""));
		System.out.println(tst.autocomplete("j"));
		System.out.println(tst.autocomplete("i"));
	}

}
