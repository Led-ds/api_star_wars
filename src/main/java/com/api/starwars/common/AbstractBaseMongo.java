package com.api.starwars.common;

import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class AbstractBaseMongo {

	 protected MongoTemplate mongoTemplate;

	    public void setMongoTemplate(MongoTemplate template) {
	        this.mongoTemplate = template;
	    }

	    public MongoTemplate getMongoTemplate() {
	        return this.mongoTemplate;
	    }
}
