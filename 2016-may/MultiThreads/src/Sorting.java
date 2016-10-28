import java.util.Arrays;
import java.util.Random;


public class Sorting {
	
	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}
	public static void sort(int[] in) {
		for(int i = 0; i < in.length-1; ++i) {
			int min = i;
			for(int j = i+1; j < in.length; ++j) {
				if(in[j] < in[min])
					min = j; 
			}
			swap(in, i, min);
		}		
	}
	
	public static void subsort(int[] in, int l, int r) {
		for(int i = l; i < r; ++i) {
			int min = i;
			for(int j = i+1; j <= r; ++j) {
				if(in[j] < in[min])
					min = j; 
			}
			swap(in, i, min);
		}		
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int[] in = new int[n];
		Random r = new Random(100);
		for (int i = 0; i < n; ++i) {
			in[i] = r.nextInt(100000);
		}		
		long start = System.currentTimeMillis();
		System.out.println(Arrays.toString(in));
		for(int i = 1; i <= k; ++i) {
			int partsize = n/k;
			int s = (i-1)*partsize;
			int e = s + partsize  - 1;
			//subsort(in,s,e);
			System.out.println("(" + s + "," + e + ")");
		}
		System.out.println(Arrays.toString(in));
		long end = System.currentTimeMillis();
		System.out.println("sorting time:"+ (float) (end - start) / 1000 + " seconds");


	}

}
