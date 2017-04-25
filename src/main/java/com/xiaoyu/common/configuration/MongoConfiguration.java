/*
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.common.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * 2016年11月11日上午10:42:07
 * 
 * @author xiaoyu
 * @description mongo的一些配置
 */
@Configuration
public class MongoConfiguration {

	@Value("${mongo.username}")
	private String username;

	@Value("${mongo.password}")
	private String password;

	@Value("${mongo.authdbname}")
	private String authdbname;

	@Value("${mongo.replica-set}")
	private String replicaSet;

	@Value("${mongo.host}")
	private String host;

	@Value("${mongo.dbname}")
	private String dbname;

	@Value("${mongo.port}")
	private Integer port;

	/*
	 * mongo的工厂，通过它来取得mongo实例, dbname为mongodb的数据库名，没有的话会自动创建
	 */
	private MongoDbFactory factory() {
		String uri = "mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + authdbname + "?"
				+ "replicaSet=" + replicaSet + ";connect-timeout=1000;safe=true;slaveOk=true";

		uri = "mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + authdbname + "?"
				+ "connect-timeout=1000;safe=true";

		MongoClientURI clientUri = new MongoClientURI(uri);
		MongoClient mongoClient = new MongoClient(clientUri);
		MongoDbFactory factory = new SimpleMongoDbFactory(mongoClient, dbname);
		return factory;
	}

	/* collection的映射 */
	private MappingMongoConverter mongoConverter() {
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory());
		MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext = new MongoMappingContext();
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mappingContext);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		return converter;
	}

	/* mongodb的主要操作对象，所有对mongodb的增删改查的操作都是通过它完成 */
	@Bean(name = "mongoTemplate")
	public MongoTemplate mongoTemplate() {
		MongoTemplate template = new MongoTemplate(factory(), mongoConverter());
		return template;
	}
}
