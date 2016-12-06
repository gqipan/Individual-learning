package org.pan.ems.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

	//id
	private Integer schoolId;
	//学校名称
	private String schoolName;
	
	//学校所在地
	private Address address;
}
