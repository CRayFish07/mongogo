/*
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.biz;

import com.xiaoyu.common.base.BaseMongoEntity;

/**
 * 2016年11月11日下午3:35:53
 * 
 * @author xiaoyu
 * @description
 */
public class User extends BaseMongoEntity {

	private static final long serialVersionUID = 2047597284356925169L;

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

}
