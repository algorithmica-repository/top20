import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RandomGenerator {

	public static void getRandom1() {
		long[] rand = new long[1000];
		Date d = new Date();
		for (int i = 0; i < 1000; ++i)
			rand[i] = d.getTime() % 10;
		System.out.println(Arrays.toString(rand));
	}

	public static void simulateCoin(int n) {
		int nh = 0, nt = 0;
		for (int i = 1; i <= n; ++i) {
			if (Math.random() >= 0.5)
				++nh;
			else
				++nt;
		}
		System.out.println("nheads:" + nh);
		System.out.println("ntails:" + nt);
	}

	public static void simulateDice(int n) {
		int[] outcomes = new int[6];
		Random r = new Random();
		for (int i = 1; i <= n; ++i) {
			++outcomes[r.nextInt(6)];
		}
		System.out.println(Arrays.toString(outcomes));
	}

	public static void main(String[] args) {
		// getRandom1();
		// System.out.println(Math.random());
		/*
		 * Random r = new Random(100); for(int i = 1; i <= 10; ++i)
		 * System.out.print(r.nextInt(10)+ " ");
		 */
		//simulateCoin(1000);
		simulateDice(120);
	}

}
