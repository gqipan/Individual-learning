package org.pan.struts2.entities;

import java.util.Comparator;


public class CityComparator implements Comparator<City> {
	@Override
	public int compare(City o1, City o2) {
		return o1.getId().compareTo(o2.getId());
	}
}
