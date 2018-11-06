package com.api.starwars.service;

import java.util.List;
import java.util.Optional;

import com.api.starwars.common.util.ExternalRequestHttp;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.starwars.model.Planeta;
import com.api.starwars.repository.PlanetaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("planetaService")
@Transactional
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository repository;

	
	public Planeta adicionar(Planeta planeta) throws Exception {

		Planeta newPlaneta = repository.insert(planeta);

		if(newPlaneta != null){
			ExternalRequestHttp restExternal = new ExternalRequestHttp();
			String response = restExternal.getRequestSWApi();

			System.out.println(response);
		}

		return planeta;
	}

	public List<Planeta> listarTodosPlanetas() {
		return repository.findAll();
	}

	public Planeta getPlantePorId(String id) {
		Optional optional = repository.findById(id);
		return (Planeta) optional.get();
	}

	@Override
	public Planeta getPlantePorNome(String nome) {
		return (Planeta) repository.findByIdName(nome);
	}

	@Override
	public void deletar(Planeta planeta) {
		repository.delete(planeta);
	}

}
