package com.alg.top20.file;

import java.util.BitSet;

public class BloomFilter implements IFilter {
	private BitSet array;
	private Hashing hashes;
	private long maxkeys;
	private float fpr;

	public BloomFilter(long maxkeys, float fpr) {
		this.maxkeys = maxkeys;
		this.fpr = fpr;
		int n = 1;
		int k = 1;
		array = new BitSet(n);
		hashes = new Hashing(k);
	}

	@Override
	public void add(String key) {
		int[] indexes = hashes.getHash(key, array.size());
		for (int i = 0; i < indexes.length; ++i)
			array.set(indexes[i]);
	}

	@Override
	public boolean contains(String key) {
		int[] indexes = hashes.getHash(key, array.size());
		for (int i = 0; i < indexes.length; ++i) {
			if (array.get(indexes[i]) == false)
				return false;
		}
		return true;
	}

	class Hashing {
		private int k;

		public Hashing(int k) {
			this.k = k;
		}

		public int[] getHash(String key, int n) {
			int[] hashes = new int[k];
			//int hash1 = (int) Hashing.murmur3_128(0).hashBytes(key.getBytes())
			//		.asLong();
			//int hash2 = (int) Hashing.murmur3_128(hash1)
			//		.hashBytes(key.getBytes()).asLong();
			int hash1 = 1,hash2 = 1;
			for (int i = 0; i < k; ++i) {
				hashes[i] = Math.abs(hash1 + i * hash2) % n;
			}
			return hashes;
		}
	}

}
