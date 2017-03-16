package com.alg.top20.sortedtable;

import java.lang.reflect.Field;

public class TravelsInfo {
	private String tname;
	private float fare;
	private float nseats;
	private float rating;
	
	public TravelsInfo(String tname, float fare, int nseats, float rating) {
		super();
		this.tname = tname;
		this.fare = fare;
		this.nseats = nseats;
		this.rating = rating;
	}
	
	public Float getValue(String name) throws Exception {
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field f: fields) {
			if(f.getName().equals(name)) {
				f.setAccessible(true);
				return (Float)f.get(this);
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "TravelsInfo [tname=" + tname + ", fare=" + fare + ", nseats="
				+ nseats + ", rating=" + rating + "]";
	}
	
	
	
	
}
