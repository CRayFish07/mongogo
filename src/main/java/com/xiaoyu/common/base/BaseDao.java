/*
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.common.base;

import org.springframework.stereotype.Repository;

/**
 * 2016年11月11日下午3:43:58
 * 
 * @author xiaoyu
 * @description 二次封装mongo的方法
 */
@Repository
public interface BaseDao<T extends BaseMongoEntity> {

	public T findById(String id);

	public void insert(T t);
}
