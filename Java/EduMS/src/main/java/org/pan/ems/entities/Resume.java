package org.pan.ems.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {

	// id
	private Integer resumeId;
	// 该简历属于哪个员工
	private Employee owner;

	// 地址信息
	private Address address;
	// 最终学历信息
	private School school;

	// 专业
	private String major;
	// 等级: 高中、专科、本科、研究生、博士
	private int level;
	
	//还可以再添加工作经历...

}
