package com.api.starwars.repository;

import java.util.List;

import org.bson.types.ObjectId;

import com.api.starwars.model.Planeta;

public interface PlanetaRepository<T> {

	T add(T log);
	
	T get(ObjectId id);  
	
	T get(String nome);
	
	List<T> getAll();
	
	void delete(ObjectId id);
}
