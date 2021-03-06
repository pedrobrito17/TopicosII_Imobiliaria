package com.kyzimobiliaria.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

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
	
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valor_aluguel; //valor sugerido pelo proprietário
	
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valor_iptu;
	
	private String obs;
	
	@OneToOne
	private TipoImovel tipoimovel;
	
	private boolean ativo = true;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", referencedColumnName="id")
	public Cliente cliente; //proprietário do imóvel
	
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
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public TipoImovel getTipoimovel() {
		return tipoimovel;
	}
	public void setTipoimovel(TipoImovel tipoimovel) {
		this.tipoimovel = tipoimovel;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public BigDecimal getValor_aluguel() {
		return valor_aluguel;
	}
	public void setValor_aluguel(BigDecimal valor_aluguel) {
		this.valor_aluguel = valor_aluguel;
	}
	public BigDecimal getValor_iptu() {
		return valor_iptu;
	}
	public void setValor_iptu(BigDecimal valor_iptu) {
		this.valor_iptu = valor_iptu;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
	
	
}
