package puzzles;

import java.util.Arrays;

public class Nqueens {

	public static void nqueens1(int n) {
		int[] res = new int[n];
		auxNqueens1(0, n, res);
	}

	private static boolean isValid1(int[] res) {
		for (int i = 0; i < res.length; ++i) {
			for (int j = i + 1; j < res.length; ++j) {
				if (res[i] == res[j] || Math.abs(i - j) == Math.abs(res[i] - res[j]))
					return false;
			}
		}
		return true;
	}

	private static void auxNqueens1(int d, int n, int[] res) {
		if (d == n) {
			if (isValid1(res))
				System.out.println(Arrays.toString(res));
			return;
		}
		for (int c = 0; c < n; ++c) {
			res[d] = c;
			auxNqueens1(d + 1, n, res);
		}
	}

	public static void nqueens2(int n) {
		int[] res = new int[n];
		auxNqueens2(0, n, res);
	}

	private static boolean isValid2(int d, int c, int[] res) {
		for (int i = 0; i < d; ++i) {
				if (res[i] == c || Math.abs(i - d) == Math.abs(res[i] - c))
					return false;
		}
		return true;
	}

	private static void auxNqueens2(int d, int n, int[] res) {
		if (d == n) {
			System.out.println(Arrays.toString(res));
			return;
		}
		for (int c = 0; c < n; ++c) {
			if (isValid2(d, c, res)) {
				res[d] = c;
				auxNqueens2(d + 1, n, res);
			}
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		nqueens2(n);
	}

}
