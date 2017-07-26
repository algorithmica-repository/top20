package com.alg.top20.dset;
import java.util.Random;

public class TestDisjointSet {

	public static void test1(IDisjointSet dset, int n) {
		Random r = new Random();
		// System.out.println(dset.find(r.nextInt(dset.size())));
		dset.display();
		for (int i = 1; i <= 5; ++i) {
			int x = r.nextInt(n);
			int y = r.nextInt(n);
			if (x != y) {
				System.out.println("union of " + x + " " + y);
				dset.union(x, y);
				dset.display();
			}
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		test1(new WeightedUnionCompressionSet(n), n);

	}

}
