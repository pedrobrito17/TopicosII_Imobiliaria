package com.kyzimobiliaria.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email(message="{email.invalido}")
	@NotBlank(message="{email.vazio}")
	private String email;
	
	@NotBlank(message="{cpf.vazio}")
	@CPF(message="CPF inválido")
	public String cpf;
	
	@NotBlank(message="{nome.vazio}")
	private String nome_cliente;
	
	@NotBlank(message="{rg.vazio}")
	private String rg;
	
	private String endereco_completo;
	
	private String cep;
	
	@NotEmpty(message="{telefone.vazio}")
	private String telefone_1;
	
	private String telefone_2;
	
	@NotNull(message="{data.nascimento.vazia}")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dt_nascimento;
	
	@NotBlank(message="{senha.vazia}")
	private String senha;
	
	@NotBlank(message="{conf.senha.vazia}")
	private String conf_senha;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco_completo() {
		return endereco_completo;
	}

	public void setEndereco_completo(String endereco_completo) {
		this.endereco_completo = endereco_completo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone_1() {
		return telefone_1;
	}

	public void setTelefone_1(String telefone_1) {
		this.telefone_1 = telefone_1;
	}

	public String getTelefone_2() {
		return telefone_2;
	}

	public void setTelefone_2(String telefone_2) {
		this.telefone_2 = telefone_2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConf_senha() {
		return conf_senha;
	}

	public void setConf_senha(String conf_senha) {
		this.conf_senha = conf_senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
}
