package com.api.starwars.repository;

import org.bson.types.ObjectId;

import com.api.starwars.common.AbstractBaseMongo;
import com.api.starwars.model.Planeta;

public class PlanetaRepositoryImpl extends AbstractBaseMongo implements PlanetaRepository<Planeta>{

	@Override
	public Planeta add(Planeta planeta) {
		 mongoTemplate.insert(planeta);	    
		 return planeta;
	}

	@Override
	public Planeta get(ObjectId id) {
		 return (Planeta)mongoTemplate.findById(id, Planeta.class);
	}

}
