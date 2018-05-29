
public class NthFibonacci {

	public static int fib1(int n) {
		if(n <=  2) return 1;
		return fib1(n-1) + fib1(n-2);
	}
	public static int fib2(int n) {
		int[] mem = new int[n+1];
		auxfib2(n, mem);
		return mem[n];
	}
	private static int auxfib2(int n, int[] mem) {	
		if(n <= 2) return 1;
		if(mem[n] != 0) return mem[n];
		mem[n]=  auxfib2(n-1, mem) + auxfib2(n-2, mem);
		return mem[n];
	}
	public static int fib3(int n) {
		int[] mem = new int[n+1];
		mem[1] = mem[2] = 1;
		for(int i = 3; i <= n; ++i)
			mem[i] = mem[i-1] + mem[i-2];
		return mem[n];
	}
	public static int fib4(int n) {
		int first = 1, second = 1;
		int current = 0;
		for(int i = 3; i <= n; ++i) {
			current = second + first;
			first = second;
			second = current;
		}
		return current;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		//System.out.println(fib2(n));
		System.out.println(fib3(n));

	}

}
