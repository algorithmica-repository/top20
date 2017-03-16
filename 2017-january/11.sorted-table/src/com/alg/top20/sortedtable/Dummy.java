package com.alg.top20.sortedtable;

import java.lang.reflect.Field;

public class Dummy {

	static class Test {
		int a;
		int b;
		
		public Test(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int getValue(Field field) throws Exception {
			field.setAccessible(true);
			return (Integer)field.get(this);
		}
		public void display() {
			
		}
	}
	public static void main(String[] args) throws Exception {
		Test t1 = new Test(10, 20);
		Field[] fields = t1.getClass().getDeclaredFields();
		System.out.println(fields.length);
		for(Field f: fields) {
			System.out.println(f.getName());
			System.out.println(t1.getValue(f));
		}
	}

}
