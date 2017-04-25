/*
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.common.base;

import java.lang.reflect.ParameterizedType;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * 2016年11月11日下午2:43:29
 * 
 * @author xiaoyu
 * @description
 */
public class BaseDaoImpl<T extends BaseMongoEntity> implements BaseDao {

	@Autowired
	private MongoTemplate template;
	protected String collectionName = null;

	/**
	 * 反射获取泛型T.class
	 * 
	 * @author xiaoyu
	 * @return
	 * @time 2016年5月11日下午2:26:01
	 */
	@SuppressWarnings({ "unchecked" })
	protected Class<T> getTClass() {
		System.out.println(this.getClass().getSuperclass().getSuperclass().getName());
		return (Class<T>) ((ParameterizedType) this.getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T findById(String id) {
		// try {
		// if (ObjectId.isValid(id))
		// throw new Exception("the given string id:" + id + " cannot convert to
		// ObjectId.");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		ObjectId oid = new ObjectId(id);
		return template.findById(oid, getTClass(), this.collectionName);
	}

	@Override
	public void insert(BaseMongoEntity t) {
		template.insert(t, collectionName);

	}
}
