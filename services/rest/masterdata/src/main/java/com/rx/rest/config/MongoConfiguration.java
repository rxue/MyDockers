package com.rx.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
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
@EnableMongoRepositories(basePackages = "com.rx.rest.dao")
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

		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		return converter;
	}
	
}
