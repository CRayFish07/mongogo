/*
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.biz;

import org.springframework.context.annotation.Configuration;
import com.xiaoyu.common.base.BaseDaoImpl;

/**
 * 2016年11月11日下午3:49:47
 * 
 * @author xiaoyu
 * @description
 */
@Configuration
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		//指定具体的collection
		super.collectionName = "t_biz_user";
	}

}
