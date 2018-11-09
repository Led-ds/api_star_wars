package com.api.starwars.repository;

import com.api.starwars.model.Planeta;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String> {
	
	Planeta findById(ObjectId _id);
	
    @Query("{ 'nome' : ?0 }")
    Planeta findByIdName(String nome);
    
}
