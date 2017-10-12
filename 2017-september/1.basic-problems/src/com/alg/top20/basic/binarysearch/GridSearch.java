package com.alg.top20.basic.binarysearch;

import java.util.Arrays;

public class GridSearch {
	public boolean searchMatrix1(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; ++i) {
        	if(Arrays.binarySearch(matrix[i], target) >= 0)
        		return true;
        }
        return false;
    }
	
	public boolean searchMatrix2(int[][] matrix, int target) {
		int m = matrix.length;
		if(m < 1 || matrix[0].length == 0 ) return false;
		int n = matrix[0].length;
        for(int i = 0; i < m; ++i) {
        	if(target >= matrix[i][0] && target <= matrix[i][n-1])
        		return Arrays.binarySearch(matrix[i], target) >= 0;
        }
        return false;
    }
	public boolean searchMatrix3(int[][] matrix, int target) {
		int m = matrix.length;
		if(m < 1 || matrix[0].length == 0 ) return false;
		int n = matrix[0].length;
		int l = 0, r = m*n - 1;
		while (l <= r) {
			int mid = (l + r) / 2; 
			int e = matrix[mid/n][mid%n];
			if (target == e)
				return true;
			if (target < e)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return false;
	}
}
