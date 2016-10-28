
public class SubSortThread extends Thread {
	private int[] in;
	private int l;
	private int r;	

	public SubSortThread(int[] in, int l, int r) {
		this.in = in;
		this.l = l;
		this.r = r;
	}
	
	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}
	@Override
	public void run() {
		for(int i = l; i < r; ++i) {
			int min = i;
			for(int j = i+1; j <= r; ++j) {
				if(in[j] < in[min])
					min = j; 
			}
			swap(in, i, min);
		}
	}	

}
