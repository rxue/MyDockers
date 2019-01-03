package ruixue.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
/**
 * https://www.baeldung.com/spring-data-mongodb-tutorial
 * 
 * @author dingding
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "ruixue.rest.repository")
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	public MongoClient mongoClient() {
		return new MongoClient("localhost", 27017);
	}

	@Override
	protected String getDatabaseName() {
		return "masterdata";
	}
	
}
