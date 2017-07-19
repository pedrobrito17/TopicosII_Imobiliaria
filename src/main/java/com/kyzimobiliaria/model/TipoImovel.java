package com.kyzimobiliaria.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_imovel")
public class TipoImovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipoimovel;
	
	private String descricao;
	
	private boolean condominio;

	public int getId_tipoimovel() {
		return id_tipoimovel;
	}

	public void setId_tipoimovel(int id_tipoimovel) {
		this.id_tipoimovel = id_tipoimovel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isCondominio() {
		return condominio;
	}

	public void setCondominio(boolean condominio) {
		this.condominio = condominio;
	}
	
	
}
