import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class MinCostMerging {

	public static int findMinCost1(int[] in) {
		int mincost = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int x : in)
			list.add(x);
		while (list.size() > 1) {
			Collections.sort(list);
			int first_smallest = list.removeFirst();
			int second_smallest = list.removeFirst();
			int tmp = (first_smallest + second_smallest);
			list.add(tmp);
			mincost += tmp;
		}
		return mincost;
	}
	
	public static int findMinCost2(int[] in) {
		int mincost = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : in)
			pq.add(x);
		while (pq.size() > 1) {
			int first_smallest = pq.remove();
			int second_smallest = pq.remove();
			int tmp = (first_smallest + second_smallest);
			pq.add(tmp);
			mincost += tmp;
		}
		return mincost;		
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random(10);
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		//System.out.println(Arrays.toString(in));
		System.out.println(findMinCost1(in));
		//System.out.println(findMinCost2(in));

	}

}
