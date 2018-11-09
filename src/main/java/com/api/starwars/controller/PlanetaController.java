package com.api.starwars.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.api.starwars.model.Planeta;
import com.api.starwars.service.PlanetaService;

@RestController
@RequestMapping(value = "/rest")
public class PlanetaController {

	private PlanetaService service;
	
	@Autowired
	public PlanetaController(PlanetaService prPlanetaService){
		this.service = prPlanetaService;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Planeta> adicionarPlaneta(@RequestBody @Valid Planeta planeta) {
		Planeta response = null;
		try {
			response = service.adicionar(planeta);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Planeta>(response, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/excluirPlaneta/{id}", method = RequestMethod.GET)
	public void excluirPlaneta(@PathVariable ObjectId id) {
		service.deletar(service.getPlantePorId(id));
	}
	
	@RequestMapping(value ="/all", method = RequestMethod.GET)
	public List<Planeta> bucarTodosPlaneta() {
	  return service.listarTodosPlanetas();
	}
	
	@RequestMapping(value = "/buscarPlanetaPorId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Planeta> buscarPorId(@PathVariable ObjectId id){

		Planeta response = service.getPlantePorId(id);
		
		if(response==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Planeta>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscarPlanetaPorNome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Planeta> buscarPorNome(@PathVariable String nome){

		Planeta response = service.getPlantePorNome(nome);
		
		if(response==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Planeta>(response, HttpStatus.OK);
	}
	
}
