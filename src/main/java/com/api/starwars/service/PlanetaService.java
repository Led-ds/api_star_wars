package com.api.starwars.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.api.starwars.model.Planeta;

public interface PlanetaService {

	public Planeta adicionar(Planeta planeta);
	
	public List<Planeta> listarTodosPlanetas();
	
    public Planeta getPlantePorId(ObjectId id);
    
    public Planeta getPlantePorNome(String nome);
    
    public void deletar(ObjectId id);
}
