package org.pan.ems.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {

	// id
	private Integer resourceId;
	// 对应的 url. 为相对于当前 WEB 应用的根路径
	private String url;
	//能够访问当前资源的权限的集合
	private Set<Authority> authorities;

}
