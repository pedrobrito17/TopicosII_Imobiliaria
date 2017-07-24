package com.kyzimobiliaria.model;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="profissional")
public class Profissional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_profissional;
	
	@NotEmpty(message="{nome.vazio}")
	private String nome;
	
	@NotEmpty(message="{email.vazio}")
	@Email(message="{email.invalido}")
	private String email;
	
	@NotEmpty(message="{telefone.vazio}")
	private String telefone01;
	
	private String telefone02;
	
	@NotNull(message="{creci.vazio}")
	private int creci;
	
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valor_hora;
	
	private boolean ativo = true;

	public int getId_profissional() {
		return id_profissional;
	}

	public void setId_profissional(int id_profissional) {
		this.id_profissional = id_profissional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone01() {
		return telefone01;
	}

	public void setTelefone01(String telefone01) {
		this.telefone01 = telefone01;
	}

	public String getTelefone02() {
		return telefone02;
	}

	public void setTelefone02(String telefone02) {
		this.telefone02 = telefone02;
	}

	public int getCreci() {
		return creci;
	}

	public void setCreci(int creci) {
		this.creci = creci;
	}

	

	public BigDecimal getValor_hora() {
		return valor_hora;
	}

	public void setValor_hora(BigDecimal valor_hora) {
		this.valor_hora = valor_hora;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	


}
