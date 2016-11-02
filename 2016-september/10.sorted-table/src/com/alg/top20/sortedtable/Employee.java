package com.alg.top20.sortedtable;

public class Employee {
	private int ssn;
	private String name;
	private float salary;
	
	public Employee(int ssn, String name, float salary) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.salary = salary;
	}

	public int getSsn() {
		return ssn;
	}

	public String getName() {
		return name;
	}

	public float getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [ssn=" + ssn + ", name=" + name + ", salary=" + salary
				+ "]";
	}
	
	
}
