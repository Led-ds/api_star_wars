package com.api.starwars.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.bson.types.ObjectId;

@SuppressWarnings("serial")
@Entity
@Table(name = "planeta")
public class Planeta implements Serializable{

	private ObjectId id;
	private String nome;
	private String clima;
	private String terreno;
	private Integer qtdAparicao;
	
	public ObjectId getId() {
        return id;
    } 
    public void setId(ObjectId id) {
        this.id = id;
    }    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public Integer getQtdAparicao() {
		return qtdAparicao;
	}
	public void setQtdAparicao(Integer qtdAparicao) {
		this.qtdAparicao = qtdAparicao;
	}
}
