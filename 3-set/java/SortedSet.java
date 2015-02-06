package com.collections;

/**
 * @author Srinivas Reddy
 * @email srinivas96alluri@gmail.com
 */

public interface SortedSet<T> extends Set<T> {

	public T findKthSmallest(int pos);

	public T findMax();

	public T findMin();

}
