public class FindMissing {

	public static void main(String[] args) {
		int a[] = { 0, 1, 2, 4, 5, 6 };
		System.out.println("missing element in the given array is: "
				+ findMissing(a, 6));
	}

	static int findMissing(int a[], int n) {
		int res = 0;
		int i = 0;
		for (i = 0; i < n; i++)
			res = res ^ a[i] ^ i;
		res = res ^ i;
		return res;

	}

}
