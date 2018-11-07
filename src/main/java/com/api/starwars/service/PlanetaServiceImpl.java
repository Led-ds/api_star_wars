package com.api.starwars.service;

import java.util.List;
import java.util.Optional;

import com.api.starwars.common.util.ExternalRequestHttp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.starwars.model.Planeta;
import com.api.starwars.model.ResultsAppearances;
import com.api.starwars.model.ResultsAppearances.Results;
import com.api.starwars.repository.PlanetaRepository;
import com.google.gson.Gson;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("planetaService")
@Transactional
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository repository;
	private ResultsAppearances aparicoes;
	
	public Planeta adicionar(Planeta planeta) throws Exception {

		Planeta newPlaneta = repository.insert(planeta);

		if(newPlaneta != null){
			ExternalRequestHttp restExternal = new ExternalRequestHttp();
			String response = restExternal.getRequestSWApi();

			Gson json = new Gson();
			aparicoes =  json.fromJson(response, ResultsAppearances.class);
			if(aparicoes!=null && aparicoes.getResults().size()>0) {
				for (ResultsAppearances.Results result : aparicoes.getResults()) {
					if(result != null) {
						
					}					
				}
			}
			
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
