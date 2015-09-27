public class CupsAndSaucers {
	public static void main(String args[]) {
		int T[] = { 15, 20, 20, 22, 30, 89 };
		int S[] = { 10, 19, 26, 30, 35, 90, 95 };
		System.out.println("Max no of pairings are: "
				+ getMaxNumberOfPairs(T, S, 6, 7));

	}

	static int getMaxNumberOfPairs(int T[], int S[], int noOfCups,
			int noOfSaucers) {
		int i = 0;
		int j = 0;
		int maxNoOfPairings = 0;
		while (i < noOfCups && j < noOfSaucers) {
			if (S[j] >= T[i]) {
				System.out.println(T[i] + " " + S[j]);
				i++;
				j++;
				maxNoOfPairings++;
			} else
				j++;

		}
		return maxNoOfPairings;
	}
}