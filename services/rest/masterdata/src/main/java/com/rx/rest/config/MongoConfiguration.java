package com.rx.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
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
	
	private MongoCredential mongoCredential() {
		return MongoCredential.createCredential("reader", "masterdata", "reader".toCharArray());
	}
	
	private ServerAddress serverAddress() {
		return new ServerAddress("localhost", 27017);
	}
	private MongoClientOptions mongoClientOptions() {
		MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
		builder.applicationName("test");
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
	
}
