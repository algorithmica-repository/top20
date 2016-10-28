import java.util.Arrays;
import java.util.Random;

public class GridSearch {

	public static boolean gridSearch1(int[][] in, int x) {
		int n = in.length;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (in[i][j] == x)
					return true;
			}
		}
		return false;
	}

	public static boolean gridSearch2(int[][] in, int x) {
		int n = in.length;
		for (int i = 0; i < n; ++i) {
			if (Arrays.binarySearch(in[i], x) >= 0)
				return true;
		}
		return false;
	}

	public static boolean gridSearch3(int[][] in, int x) {
		int n = in.length;
		int r = 0, c = n - 1;

		while (r <= n - 1 && c >= 0) {
			if (x == in[r][c])
				return true;
			else if (x < in[r][c])
				--c;
			else
				++r;
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = new int[n][n];
		Random r = new Random(100);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				in[i][j] = r.nextInt(1000);
			}
		}
		long start = System.currentTimeMillis();
		gridSearch1(in, 1100);
		long end = System.currentTimeMillis();
		System.out.println("Time of " + n + "^2 operations "
				+ (float) (end - start) / 1000 + " seconds");

	}

}
