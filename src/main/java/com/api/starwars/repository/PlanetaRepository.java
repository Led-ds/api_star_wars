package com.api.starwars.repository;

import com.api.starwars.model.Planeta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String> {

    @Query("{ 'nome' : ?0 }")
    Planeta findByIdName(String nome);
}
