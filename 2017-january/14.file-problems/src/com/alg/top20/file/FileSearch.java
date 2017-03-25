package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileSearch {

	public static String fileSearch1(String filename, String empid) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		while((line = br.readLine()) != null) {
			String id = line.split(",")[0];
			if(id.equals(empid))
				return line;
		}			
		br.close();
		return null;
	}
	
	public static Map<String,Long> buildIndex(String filename) throws Exception {
		HashMap<String, Long> eindex = new HashMap<String, Long>();
		RandomAccessFile raf = new RandomAccessFile(filename, "r");
		String line;
		long rec_off = raf.getFilePointer();
		while((line=raf.readLine()) != null) {
			String eid = line.split(",")[0];
			eindex.put(eid, rec_off);
			rec_off = raf.getFilePointer();
		}
		System.out.println(eindex);
		return eindex;		
	}
	
	public static String fileSearch2(String filename, String empid, Map<String, Long> eindex) throws Exception {
		long offset = eindex.get(empid);
		RandomAccessFile raf = new RandomAccessFile(filename, "r");
		raf.seek(offset);
		return raf.readLine();
}
	public static void main(String[] args) throws Exception {
		String filename = "D:/dummy.txt";
		Map<String, Long> eindex = buildIndex(filename);
		
		Scanner scanner = new Scanner(System.in);
		String eid;
		while((eid = scanner.next()) != null) {
			System.out.println(fileSearch2(filename, eid, eindex));
		}
		
	}

}
