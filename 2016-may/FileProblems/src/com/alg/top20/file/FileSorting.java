package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.LinkedList;

public class FileSorting {

	public static  void fileSort1(String infile, String outfile) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(infile));
		String line;
		LinkedList<Integer> buffer = new LinkedList<Integer>();
		while((line = br.readLine()) != null) {
			buffer.add(Integer.parseInt(line.trim()));
		}
		Collections.sort(buffer);
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(outfile));
		while(! buffer.isEmpty()) {
			bw.write(buffer.removeFirst().toString());
			bw.newLine();
		}
		bw.close();
	}
	
	public static  void fileSort2(String infile, String outfile) throws Exception {
		//fill externl merge sort logic
	}
	public static void main(String[] args) throws Exception {
		String infile = args[0];
		String outfile = args[1];
		fileSort1(infile, outfile);
	}

}
