package com.collections;

/**
 * @author	Srinivas Reddy
 * @Email	srinivas96alluri@gmail.com
 */

public interface Map<Key, Val> {
	
	public void set(Key key, Val value);
	public Val get(Key key);
	public boolean contains(Val value);
	public void clear();
}
