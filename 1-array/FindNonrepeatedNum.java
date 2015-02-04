/*Given an integer array of size n with every number repeating one time
 * except two numbers.Find the two non repeating numbers
 * */
package com.algorithmica.arrays;

public class FindNonrepeatedNum {

	public static void main(String[] args) {
        int a[]={10,9,-1,3,4,-6,6,10,9,3,4,6};
        findNonrepeatedNum(a);
	}

	public static void findNonrepeatedNum(int a[]) {
		int xorOfAll = 0;
		int bitpostion = 0;
		int mask=0;
		int num1 = 0,num2 = 0;
		int len = a.length;
		for (int i = 0; i < len; i++)
			xorOfAll ^= a[i];
		while (xorOfAll != 0) {
			if ((xorOfAll & 1) > 0)
				break;
			else {
				xorOfAll = xorOfAll >>> 1;
				bitpostion++;
			}
		}
		mask=(1<<bitpostion);
		for (int i = 0; i < len; i++) {
			if((a[i]&mask )>0)
				num1^=a[i];
			else
				num2^=a[i];
		}
		System.out.println("numbers that are not repeating are..."+num1+" and "+num2);
			
	}
}
