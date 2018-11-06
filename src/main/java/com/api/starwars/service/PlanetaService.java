package com.api.starwars.service;

import java.util.List;
import com.api.starwars.model.Planeta;

public interface PlanetaService {

	public Planeta adicionar(Planeta planeta) throws Exception;
	
	public List<Planeta> listarTodosPlanetas();
	
    public Planeta getPlantePorId(String id);
    
    public Planeta getPlantePorNome(String nome);
    
    public void deletar(Planeta planeta);
}
