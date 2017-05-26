import java.util.Random;

public class RemoveDuplicates {

	public static int[] removeDuplicates1(int[] in) {
		int ndistinct = 0;
		for (int i = 0; i < in.length; ++i) {
			if (in[i] != Integer.MAX_VALUE) {
				++ndistinct;
				for (int j = i + 1; j < in.length; ++j) {
					if (in[i] == in[j])
						in[j] = Integer.MAX_VALUE;
				}
			}
		}
		int[] out = new int[ndistinct];
		int k = 0;
		for (int i = 0; i < in.length; ++i) {
			if (in[i] != Integer.MAX_VALUE)
				out[k++] = in[i];
		}
		return out;
	}
	
	public static void main(String[] args) {
		//int[] in = { 10,20,10,10};
		int size = Integer.parseInt(args[0]);
		int[] in = new int[size];
		//test case
		Random r = new Random();
		for(int i = 0; i < in.length; ++i) {
			in[i] = r.nextInt(size) + 1;
		}
		/*for(int i = 0; i < in.length;  ++i)
			System.out.print(in[i] + " ");
		System.out.println();*/
		long start = System.currentTimeMillis();
		int[] out = removeDuplicates1(in);
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0 + "seconds");
		/*for(int i = 0; i < out.length;  ++i)
			System.out.print(out[i] + " ");
*/	}

}
