public class PrintSpiral {
	public static void main(String args[]) {
		char a[][] = { { 'a', 'b', 'c' }, { '1', '2', '3' }, { 'p', 'q', 'r' } };
		printSpiral1(a, 3, 3);
	}

	static void printSpiral(char a[][], int n) {
		int i, rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
		while(rowStart <= rowEnd && colStart <= colEnd) {
			for (i = colStart; i < colEnd; i++)
				System.out.print(a[rowStart][i] + " ");
			for (i = rowStart; i < rowEnd; i++)
				System.out.print(a[i][colEnd] + " ");
			for (i = colEnd; i > colStart; i--)
				System.out.print(a[rowEnd][i] + " ");
			for (i = rowEnd; i > rowStart; i--)
				System.out.print(a[i][colStart] + " ");

			rowStart++; colStart++;rowEnd--;colEnd--;
		}
		System.out.println();
	}
}


/* Alternative implementation

static void printSpiral(char a[][], int n) {
		int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
		int i;
		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (i = colStart; i <= colEnd; i++)
				System.out.print(a[rowStart][i] + " ");
			rowStart++;
			for (i = rowStart; i <= rowEnd; i++)
				System.out.print(a[i][colEnd] + " ");
			colEnd--;

			for (i = colEnd; i >= colStart; i--)
				System.out.print(a[rowEnd][i] + " ");
			rowEnd--;

			for (i = rowEnd; i >= rowStart; i--)
				System.out.print(a[i][colStart] + " ");
			colStart++;
		}
		System.out.println();
	}
}
*/