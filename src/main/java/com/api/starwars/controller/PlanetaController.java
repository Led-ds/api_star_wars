package com.api.starwars.controller;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping(method=RequestMethod.POST, value="/add)", 
						headers ="content-type=application/x-www-form-urlencoded", 
							produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planeta> adicionarPlaneta(@ModelAttribute @Valid Planeta planeta, BindingResult errors, Model model) {
		if (errors.hasErrors()) {
            return new ResponseEntity<Planeta>(new Planeta(), HttpStatus.CONFLICT);
        }
        
        Planeta response = service.adicionar(planeta);
        
        return new ResponseEntity<Planeta>(response, HttpStatus.CREATED);
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/buscarPlaneta/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Planeta> buscarPorId(@PathVariable String id){

		Planeta target = service.getPlantePorId(id);
		
		if(target==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Planeta>(target, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/buscarPlaneta/{nome}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Planeta> buscarPorNome(@PathVariable String nome){

		Planeta target = service.getPlantePorNome(nome);
		
		if(target==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Planeta>(target, HttpStatus.OK);
	}
	
}
