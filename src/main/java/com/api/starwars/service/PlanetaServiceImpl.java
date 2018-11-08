package com.api.starwars.service;

import java.util.List;
import java.util.Optional;

import com.api.starwars.common.util.CallHttpRest;

import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.starwars.model.Planeta;
import com.api.starwars.model.ResultsAparicoes;
import com.api.starwars.model.ResultsAparicoes.Results;
import com.api.starwars.repository.PlanetaRepository;
import com.google.gson.Gson;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("planetaService")
@Transactional
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository repository;
	private ResultsAparicoes aparicoes;
	private Gson json;
	private CallHttpRest call;

	public Planeta adicionar(Planeta planeta) throws Exception {

		Planeta newPlaneta = repository.insert(planeta);

		if(newPlaneta != null){
			call = new CallHttpRest();
			String response = call.getRequestSWApi();
			
			json = new Gson();
			aparicoes =  json.fromJson(response, ResultsAparicoes.class);
			
			if(aparicoes!=null && aparicoes.getResults().size()>0) {
				
				for (int i = 0; i < aparicoes.getResults().size(); i++) {
					
					if(aparicoes.getResults().get(i).getName().equals(newPlaneta.getNome())) {
						
						newPlaneta.setQtdAparicao(aparicoes.getResults().get(i).getFilms().size());
					}
				}
				
				if(newPlaneta.getQtdAparicao()>0) {
					
					newPlaneta = repository.save(newPlaneta);
				}
			}
		}
		return newPlaneta;
	}

	public List<Planeta> listarTodosPlanetas() {
		return repository.findAll();
	}

	public Planeta getPlantePorId(String _id) {
		ObjectId id = new ObjectId(_id.getBytes());
		Optional<Planeta> optional = repository.findById(new ObjectId(_id).toString());
		
		return optional==null?null:(Planeta) optional.get();
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
