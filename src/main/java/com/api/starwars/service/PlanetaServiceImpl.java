package com.api.starwars.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.starwars.model.Planeta;
import com.api.starwars.repository.PlanetaRepository;

public class PlanetaServiceImpl implements PlanetaService {

	private PlanetaRepository repository;
	
	@Autowired
	public PlanetaServiceImpl(PlanetaRepository prPlanetaRepository){
		this.repository = prPlanetaRepository;
	}
	
	
	@Override
	public Planeta adicionar(Planeta planeta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planeta> listarTodosPlanetas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planeta getPlantePorId(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planeta getPlantePorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(ObjectId id) {
		// TODO Auto-generated method stub
		
	}

}
