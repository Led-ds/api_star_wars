package com.api.starwars.controller;

import javax.validation.Valid;

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
	
	@RequestMapping(value = "/buscarPlanetaPorId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Planeta> buscarPorId(@PathVariable String id){

		Planeta target = service.getPlantePorId(id);
		
		if(target==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Planeta>(target, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscarPlanetaPorNome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Planeta> buscarPorNome(@PathVariable String nome){

		Planeta target = service.getPlantePorNome(nome);
		
		if(target==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Planeta>(target, HttpStatus.OK);
	}
	
}
