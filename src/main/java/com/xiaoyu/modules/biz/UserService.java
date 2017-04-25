/*
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

/**
 * 2016年11月17日下午6:05:17
 * 
 * @author xiaoyu
 * @description
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public String getUserInfo(String userId) {
		User user;
		user = (User) this.userDao.findById(userId);
		return JSON.toJSONString(user);
	}

	public String saveUser(String name, String password) {
		User u = new User();
		u.setName(name).setPassword(password);
		this.userDao.insert(u);
		return JSON.toJSONString("success");
	}
}
