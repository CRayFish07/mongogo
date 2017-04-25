/*
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2016年11月17日下午6:15:33
 * 
 * @author xiaoyu
 * @description
 */
@Configuration
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("save")
	public String save(String name, String password) {
		return this.userService.saveUser(name, password);
	}

	@RequestMapping("get")
	public String get(String userId) {
		return this.userService.getUserInfo(userId);
	}

}
