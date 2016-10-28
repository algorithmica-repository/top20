package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.TreeMap;

public class FileSearch {

	public static void buildIndexFromOrigFile(String file, String indexfile)  throws Exception {
		TreeMap<Integer, Long> empid_idx = new TreeMap<Integer, Long>();
		RandomAccessFile rf = new RandomAccessFile(new File(file), "r");
		String line;
		long start = System.currentTimeMillis();
		long current = 0;
		while((line = rf.readLine()) != null) {
			long next = rf.getFilePointer();			
			Integer key = Integer.parseInt(line.split(",")[0]);
			empid_idx.put(key, current);
			current = next;
		}
		long end = System.currentTimeMillis();
		System.out.println("Time to build index from source file:" + (end-start)/1000.0 +" seconds");
		
		System.out.println(empid_idx);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(indexfile));
		oos.writeObject(empid_idx);		
	}
	
	public static TreeMap<Integer, Long> buildIndexFromIndexFile(String indexfile)  throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(indexfile));
		long start = System.currentTimeMillis();
		TreeMap<Integer, Long> index = (TreeMap<Integer, Long>)ois.readObject();
		long end = System.currentTimeMillis();
		System.out.println("Time to build index from index file:" + (end-start)/1000.0 +" seconds");
		System.out.println(index);
		return index;
	}
	
	public static void generateTestData(String file, long n) throws Exception {
		Random r = new Random(100);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file)));
		for(long i = 1; i <= n; ++i) {
			long empid = i;
			String ename = "emp"+i;
			int sal = r.nextInt(100000) + 5000;
			String dname = "dname" +i;
			bw.write(empid+","+ename+","+sal+","+dname);
			bw.newLine();
		}
		bw.close();		
	}
	public static String query(TreeMap<Integer, Long> index, String file, Integer empid) throws Exception {
		Long offset = index.get(empid);
		RandomAccessFile rf = new RandomAccessFile(new File(file), "r");
		rf.seek(offset);
		return  rf.readLine();
	}
	
	public static void main(String[] args) throws Exception {
		String file = args[0];
		long n = Long.parseLong(args[1]);
		String indexfile = "D:\\input\\index";
		//generateTestData(file, n);
		buildIndexFromOrigFile(file, indexfile);
		TreeMap<Integer, Long> index = buildIndexFromIndexFile(indexfile);
		System.out.println(query(index, file, 300));
	}

}
