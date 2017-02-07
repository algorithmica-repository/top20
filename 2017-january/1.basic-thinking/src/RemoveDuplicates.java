import java.util.Arrays;
import java.util.Random;

public class RemoveDuplicates {

	public static int[] removeDuplicates1(int[] in) {
		int ndistict = 0;
		for (int i = 0; i < in.length; ++i) {
			if (in[i] != Integer.MIN_VALUE) {
				++ndistict;
				for (int j = i + 1; j < in.length; ++j) {
					if (in[i] == in[j])
						in[j] = Integer.MIN_VALUE;
				}
			}
		}
		int[] out = new int[ndistict];
		int k = 0;
		for(int i = 0; i < in.length; ++i) {
			if(in[i] != Integer.MIN_VALUE)
				out[k++] = in[i];
		}
		return out;		
	}
	
	public static int[] removeDuplicates2(int[] in) {
		Arrays.sort(in);
		int ndistict = 0, j;
		for(int i = 0; i < in.length; i = j) {
			j = i + 1;
			++ndistict;
			while(j < in.length && in[i] == in[j]) {
				in[j] = Integer.MIN_VALUE;
				++j;
			}
		}
		int[] out = new int[ndistict];
		int k = 0;
		for(int i = 0; i < in.length; ++i) {
			if(in[i] != Integer.MIN_VALUE)
				out[k++] = in[i];
		}
		return out;	
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];

		Random r = new Random();
		for (int i = 0; i < in.length;++i)
			in[i] = r.nextInt(n *n) + 1;
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		int[] out = removeDuplicates2(in);
		long end = System.currentTimeMillis();
		System.out.println(out.length);
		System.out.println("Time taken:" + (end - start) / 1000.0 + " seconds");

		//System.out.println(Arrays.toString(out));

	}

}
