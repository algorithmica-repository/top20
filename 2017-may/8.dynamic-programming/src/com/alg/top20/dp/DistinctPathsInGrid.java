
public class DistinctPathsInGrid {

	//TC:O(2 ^ 2n)   SC:O(n) ~ 2n
	public static int distinctPaths1(int n) {
		MyInteger total = new MyInteger();
		total.set(0);
		auxPaths1(1, 1, n, total);
		return total.get();
	}
	private static void auxPaths1(int i, int j, int n, MyInteger total) {
		if(i > n  || j > n) return;
		if(i == n && j == n) {
			total.set(total.get() + 1);
			return;
		}
		auxPaths1(i+1, j, n, total);
		auxPaths1(i, j+1, n, total);
	}
	
	//TC:O(2 ^ 2n)   SC:O(n) ~ 2n
	public static int distinctPaths2(int n) {
		return auxPaths2(n, n);
	}
	private static int auxPaths2(int i, int j) {
		if(i == 1  || j == 1) return 1;
		int top_paths = auxPaths2(i-1, j);
		int left_paths = auxPaths2(i, j-1);
		return top_paths + left_paths;
	}
	
	//TC:O(n ^ 2)   SC:O(n^2) ~ 2n + n^2
	public static int distinctPaths3(int n) {
		int[][] mem = new int[n+1][n+1];
		auxPaths3(n, n, mem);
		return mem[n][n];
	}
	private static int auxPaths3(int i, int j, int[][] mem) {
		if(i == 1  || j == 1) return 1;
		int top_paths = mem[i-1][j]!=0?mem[i-1][j]:auxPaths3(i-1, j, mem);
		int left_paths = mem[i][j-1]!=0?mem[i][j-1]:auxPaths3(i, j-1, mem);
		return mem[i][j] = top_paths + left_paths;
	}
	
	//TC:O(n ^ 2)   SC:O(n^2) ~ n^2
	public static int distinctPaths4(int n) {
		int[][] mem = new int[n+1][n+1];
		for(int j = 1; j <= n; ++j) {
			mem[1][j] = 1;
			mem[j][1] = 1;
		}
		for(int i = 2; i <= n; ++i) {
			for(int j = 2; j <= n; ++j) {
				mem[i][j] = mem[i-1][j] + mem[i][j-1];
			}
		}
		return mem[n][n];
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		//System.out.println(distinctPaths1(n));
		//System.out.println(distinctPaths2(n));
		//System.out.println(distinctPaths3(n));
		System.out.println(distinctPaths4(n));
	}

}
