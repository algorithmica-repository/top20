package com.collections;

/**
 * @author	Srinivas Reddy
 * @Email	srinivas96alluri@gmail.com
 */

interface List<Type> {

    public int addElement(Type data, int pos);

    public int addElement(Type data);

    public boolean removeElement(int pos);

    public void clear();
}
