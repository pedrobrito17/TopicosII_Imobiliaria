package com.kyzimobiliaria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="imoveis")
public class Imovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_imovel;
	
	@NotEmpty(message="{endereco.vazio}")
	private String endereco;
	
	@NotEmpty(message="{bairro.vazio}")
	private String bairro;
	
	@NotNull(message="{cep.vazio}")
	@Min(11111111)
	private long cep;
	
	private String pontodereferencia;
	
	@NotNull(message="{metragem.vazio}")
	@Min(30)
	private double metragem;
	
	@NotNull(message="{dormitorio.vazio}")
	@Min(1)
	private int dormitorios;
	
	@NotNull(message="{banheiro.vazio}")
	@Min(1)
	private int banheiros;
	
	private int suites;	
	
	private int vagas_garagem;
	
	@NotNull(message="{valor.aluguel.vazio}")
	@Min(100)
	private double valor_aluguel;
	
	@NotNull(message="{iptu.vazio}")
	@Min(100)
	private double valor_iptu;
	
	private String obs;
	
	@ManyToOne
	@JoinColumn(name="id_profissional", referencedColumnName="id_profissional")
	public Profissional prof;
	
	public int getId_imovel() {
		return id_imovel;
	}
	public void setId_imovel(int id_imovel) {
		this.id_imovel = id_imovel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public long getCep() {
		return cep;
	}
	public void setCep(long cep) {
		this.cep = cep;
	}
	public String getPontodereferencia() {
		return pontodereferencia;
	}
	public void setPontodereferencia(String pontodereferencia) {
		this.pontodereferencia = pontodereferencia;
	}
	public double getMetragem() {
		return metragem;
	}
	public void setMetragem(double metragem) {
		this.metragem = metragem;
	}
	public int getDormitorios() {
		return dormitorios;
	}
	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}
	public int getBanheiros() {
		return banheiros;
	}
	public void setBanheiros(int banheiros) {
		this.banheiros = banheiros;
	}
	public int getSuites() {
		return suites;
	}
	public void setSuites(int suites) {
		this.suites = suites;
	}
	public int getVagas_garagem() {
		return vagas_garagem;
	}
	public void setVagas_garagem(int vagas_garagem) {
		this.vagas_garagem = vagas_garagem;
	}
	public double getValor_aluguel() {
		return valor_aluguel;
	}
	public void setValor_aluguel(double valor_aluguel) {
		this.valor_aluguel = valor_aluguel;
	}
	public double getValor_iptu() {
		return valor_iptu;
	}
	public void setValor_iptu(double valor_iptu) {
		this.valor_iptu = valor_iptu;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Profissional getProf() {
		return prof;
	}
	public void setProf(Profissional prof) {
		this.prof = prof;
	}
	
	
	
	
	
}
