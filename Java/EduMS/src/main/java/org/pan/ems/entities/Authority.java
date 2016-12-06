package org.pan.ems.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 权限名称. 供 SpringSecurity 使用的权限的名字. 例如: ROLE_USER_UPDATE
	 */
	private String name; // ROLE_USER_UPDATE
	/**
	 * 在页面上显示的权限的名称. 例如: 用户信息的修改
	 */
	private String displayName; // 用户信息修改
	/**
	 * 与当前权限关联的权限信息, 多个权限的 id 使用 "," 分隔. 例如: ,3,4,6,
	 */
	private String relatedAuthorites;
	/**
	 * 当前权限的父权限
	 */
	private Authority parentAuthority; // 用户管理
	/**
	 * 当前权限的子权限
	 */
	private Set<Authority> subAuthorities = new HashSet<Authority>();
	/**
	 * 进入当前权限的 Resource 引用, 和 Resource 之间是多对一的关联关系
	 */
	private Resource mainResource;

}
