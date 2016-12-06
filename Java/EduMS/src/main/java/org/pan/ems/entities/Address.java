package org.pan.ems.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	// id
	private Integer addressId;

	// 市, City 中可以包含 Province, 所以 Address 中就不需要再包含 Province
	private City city;
	// 邮编
	private String postCode;

	// 具体住址
	private String details;
}
