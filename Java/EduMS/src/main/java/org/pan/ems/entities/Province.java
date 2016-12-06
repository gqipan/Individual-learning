package org.pan.ems.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {

	// id
	private Integer provinceId;
	// 省的名称
	private String provinceName;
	
	// 省里有哪些市
	private Set<City> cities = new HashSet<City>();

}
