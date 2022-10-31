package com.sebrown.app.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

//	@Bean
//	public MongoTemplate mongoTemplate() throws IOException {
//	    EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
//	    mongo.setBindIp("localhost");
//	    MongoClient mongoClient = (MongoClient) mongo.getObject();
//	    MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "test_or_whatever_you_want_to_call_this_db");
//	    return mongoTemplate;
//	}
	
//	@Bean
//	public CommandLineRunner dataLoader(IngredientRepository repo) {
//	  return args -> {
//	    repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
//	    repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
//	    repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
//	    repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
//	    repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
//	    repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
//	    repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
//	    repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
//	    repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
//	    repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
//	  };
//	}
	
}
