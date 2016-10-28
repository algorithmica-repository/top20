package com.alg.top20.bitset;

import java.util.BitSet;

public class BloomFilter {
	private BitSet bs;
	private long maxkeys;
	private float fpr;
	private int size;
	private HashFunctions hash;
	
	class HashFunctions {
		private int nhashes;
		public HashFunctions(int nhashes) {
			this.nhashes = nhashes;
		}
		public int[] getIndexes(String key) {
			int[] hashes = new int[nhashes];			
			int hash1 = (int)Hashi .murmur3_128(0).hashBytes(key.getBytes()).asLong();
			int hash2 = (int)Hashing.murmur3_128(hash1).hashBytes(key.getBytes()).asLong();
			for (int i = 0; i < nhashes; ++i) {
				hashes[i] = Math.abs(hash1 + i * hash2) % size;
			}
			return hashes;
		}
	}
	
	public BloomFilter(long maxkeys, float fpr) {
		int nbits = 1;
		int nhashes = 1;
		bs = new BitSet(nbits);
		this.maxkeys = maxkeys;
		this.fpr = fpr;
		hash = new HashFunctions(nhashes);
	}
	
	public void add(String key) {
		int[] ind = hash.getIndexes(key);
		for(int i = 0; i < ind.length; ++i ) {
			bs.set(ind[i]);
		}
		++size;
	}
	
	public boolean contains(String key) {
		int[] ind = hash.getIndexes(key);
		for(int i = 0; i < ind.length; ++i ) {
			if(bs.get(ind[i]) == false) return false;
		}
		return true;
	}
	
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		BloomFilter blmf = new BloomFilter(100000, 0.0001f);
		blmf.add("bacd");
		blmf.add("zyz");
		blmf.contains("bacd");
		blmf.contains("acd");
	}

}
