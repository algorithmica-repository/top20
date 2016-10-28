import java.util.Arrays;
import java.util.Random;


public class ParallelSort {
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int[] in = new int[n];
		Random r = new Random(100);
		for (int i = 0; i < n; ++i) {
			in[i] = r.nextInt(100000);
		}		
		long start = System.currentTimeMillis();
		//System.out.println(Arrays.toString(in));
		SubSortThread[] worker = new SubSortThread[k];
		for(int i = 1; i <= k; ++i) {
			int partsize = n/k;
			int s = (i-1)*partsize;
			int e = s + partsize  - 1;
			worker[i-1] = new SubSortThread(in, s, e);
			worker[i-1].start();
			//System.out.println("(" + s + "," + e + ")");
		}
		for(int i = 0; i < k; ++i)
			worker[i].join();
		//Thread.sleep(1000);
		//System.out.println(Arrays.toString(in));
		long end = System.currentTimeMillis();
		System.out.println("sorting time:"+ (float) (end - start) / 1000 + " seconds");


	}


}
