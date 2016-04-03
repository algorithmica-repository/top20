package com.alg.top20.bloomfilter;

import java.util.BitSet;

import com.google.common.hash.Hashing;

class Hash {
	private int k;
	private int m;

	public Hash(int k, int m) {
		this.k = k;
		this.m = m;
	}
	public int[] getHashes(String key) {
		int[] hashes = new int[k];

		int hash1 = (int)Hashing.murmur3_128(0).hashBytes(key.getBytes()).asLong();
		int hash2 = (int)Hashing.murmur3_128(hash1).hashBytes(key.getBytes()).asLong();
		for (int i = 0; i < k; ++i) {
			hashes[i] = Math.abs(hash1 + i * hash2) % m;
		}
		return hashes;
	}
}

public class BloomFilter {
	private BitSet bs;
	private Hash hash;

	public BloomFilter(int n, double p) {
		int m = (int) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
		int k = (int) Math.round(m / n * Math.log(2));
		bs = new BitSet(m);
		hash = new Hash(k, m);
		System.out.println("n=" + n + "p=" + p + "m=" + m + ",k=" + k);
	}

	public void add(String key) {
		int[] indexes = hash.getHashes(key);
		for (int index : indexes) {
			bs.set(index);
		}
	}

	public boolean contains(String key) {
		int[] indexes = hash.getHashes(key);
		for (int index : indexes) {
			if (bs.get(index) == false)
				return false;
		}
		return true;
	}
}
