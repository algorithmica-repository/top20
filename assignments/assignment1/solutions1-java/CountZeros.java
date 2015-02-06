
public class CountZeros {

	public static void main(String[] args) {

		int a[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 10, 15, 89, 90, 22, 24,
				35, 45, 67 };
		int n = a.length;
		System.out.println("no of zeros are: " + countZeros(a, n));

	}

	static int countZeros(int a[], int n) {
		int l = 0;
		int r = n - 1;
		int m;
		while (l + 1 < r) {
			m = l + (r - l) / 2;
			if (a[m] == 0)
				l = m;
			else
				r = m - 1;
		}
		if (a[r] == 0)
			return r + 1;
		if (a[l] == 0)
			return l + 1;
		return -1;

	}

}
