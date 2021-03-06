package com.rx.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
/**
 * https://www.baeldung.com/spring-data-mongodb-tutorial
 * 
 * @author dingding
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.rx.repository")
public class MongoConfiguration extends AbstractMongoConfiguration {
	private ServerAddress serverAddress() {
		return new ServerAddress("localhost", 27017);
	}
	private MongoCredential mongoCredential() {
		return MongoCredential.createCredential("root", "admin", "root".toCharArray());
	}
	private MongoClientOptions mongoClientOptions() {
		MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
		return builder.build();
	}

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(serverAddress(), mongoCredential(), mongoClientOptions());
	}

	@Override
	protected String getDatabaseName() {
		return "masterdata";
	}
	/**
	 * Remove the _class field
	 */
	@Override
	public MappingMongoConverter mappingMongoConverter() throws Exception {
		MappingMongoConverter converter = super.mappingMongoConverter();
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		return converter;
	}
	
}
