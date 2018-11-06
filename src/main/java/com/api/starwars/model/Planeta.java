package com.api.starwars.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

@SuppressWarnings("serial")
public class Planeta implements Serializable{

	@Id
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private Integer qtdAparicao;

	public Planeta(){}

	public Planeta(String prNome, String prClima, String prTerreno, Integer prQtdAparicao){
		this.nome = prNome;
		this.clima = prClima;
		this.terreno = prTerreno;
		this.qtdAparicao = prQtdAparicao;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
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

	@Override
	public String toString() {
		return "Planeta{" +
				"nome='" + nome + '\'' +
				", clima='" + clima + '\'' +
				", terreno='" + terreno + '\'' +
				", qtdAparicao=" + qtdAparicao +
				'}';
	}
}
