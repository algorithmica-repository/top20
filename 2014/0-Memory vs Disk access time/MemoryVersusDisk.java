import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Program to demo time difference between memory access and disk access
 *
 */
public class MemoryVersusDisk {

	private static void runMemoryTest(int n)
	{
		int[] buffer1 = new int[n];
		int[] buffer2 = new int[n];
		long start = System.currentTimeMillis();
		for (int k=0; k<1000000; k++) {
			System.arraycopy(buffer1, 0, buffer2, 0, n);
		}
		long end = System.currentTimeMillis();
		System.out.printf("time for memory acces " + (end - start) + " milli seconds\n");
	}
	
	private static void runDiskTest(int n)
	{
		long start, end;
		
		try {
			char[] charBuffer = new char[n*2];
			start = System.currentTimeMillis();;
			FileWriter fout = new FileWriter("E:/data1");
			for (int k=0; k<1000000; k++) {
				fout.write(charBuffer);
				fout.flush();
			}
			fout.close();
			end = System.currentTimeMillis();;
			System.out.printf("time for disk acces " + (end - start) + " milli seconds\n");

		} catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
	
	private static void runBufferedDiskTest(int n)
	{
		long start, end;
		
		try {
			char[] charBuffer = new char[n*2];
			start = System.currentTimeMillis();;
			FileWriter fout = new FileWriter("E:/data2");
			for (int k=0; k<1000000; k++) {
				fout.write(charBuffer);
			}
			fout.close();
			end = System.currentTimeMillis();;
			System.out.printf("time for buffered disk access " + (end - start) + " milli seconds\n");
		} catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int n = 1024;
		
		runMemoryTest(n);
		
		runBufferedDiskTest(n);
		
		runDiskTest(n);
		
	}

}
