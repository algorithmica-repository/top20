import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;


public class CommonElements {
	
	public static int findCommon1(int[] in1, int[] in2) {
		int ncommon = 0;
		for(int i = 0; i< in1.length; ++i) {
			for(int j = 0; j < in2.length; ++j) {
				if(in1[i] == in2[j])
					++ncommon;
			}
		}
		return ncommon;
	}
	
	public static int findCommon2(int[] in1, int[] in2) {
		int ncommon = 0;
		 Arrays.sort(in1);
		 Arrays.sort(in2);
		 int i = 0, j = 0;
		 while(i < in1.length && j < in2.length) {
			 if(in1[i] == in2[j]) {
				 ++i; ++j; ++ncommon;
			 } else if(in1[i] < in2[j]) {
				 ++i; 
			 } else {
				 ++j;
			 }
		 }
		return ncommon;
	}
	
	public static int findCommon3(int[] in1, int[] in2) {
		int ncommon = 0;
		Arrays.sort(in2);
		for(int i = 0; i< in1.length; ++i) {
			if(Arrays.binarySearch(in2, in1[i]) >= 0)
				++ncommon;
		}
		return ncommon;
	}
	
	public static int findCommon4(int[] in1, int[] in2) {
		int ncommon = 0;
		HashSet<Integer> hs = new HashSet<Integer>();
		for(Integer e: in1) {
			hs.add(e);
		}
		for(Integer e: in2) {
			if(hs.contains(e))
				++ncommon;
		}
		return ncommon;
	}

	
	public static void main(String[] args) {		
		/*int[] in1 = {10,20,30,40,5};
		int[] in2 = {20,15,50,35,10};
		System.out.println(findCommon2(in1, in2));*/
		int size = Integer.parseInt(args[0]);
		int[] in1 = new int[size];
		int[] in2 = new int[size];
		Random r = new Random();
		for(int i = 0; i < size; ++i) {
			in1[i] = r.nextInt(2*size) + 1;
			in2[i] = r.nextInt(2*size) + 1;
		}
		System.out.println(Arrays.toString(in1));
		System.out.println(Arrays.toString(in2));
		
		/*long start = System.currentTimeMillis();
		System.out.println(findCommon2(in1, in2));
		long end = System.currentTimeMillis();
		System.out.println("time:" + (float)(end-start)/1000 + " seconds");
		*/
		
	}


}





