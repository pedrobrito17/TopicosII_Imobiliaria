package com.kyzimobiliaria.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="locacao")
public class Locacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_locacao;
	
	@OneToOne
	private Imovel imovel;
	
	@OneToOne
	private Cliente inquilino;
	
	@OneToOne
	private Profissional profissional;
	
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valor_aluguel;
	
	@NotNull(message="{perc.multa.vazio}")
	private double percentual_multa;
	
	@Min(value = 1, message = "Data do vencimento inválida.")
	@Max(value = 31, message = "Data do vencimento inválida.")
	private int venc;
	
	@NotNull(message="data.inicio.invalida")
	private Date data_inicio_contrato;
	
	@NotNull(message="data.fim.invalida")
	private Date data_fim_contrato;
	
	private boolean ativo = true;
	
	private String observacao;

	public int getId_locacao() {
		return id_locacao;
	}

	public void setId_locacao(int id_locacao) {
		this.id_locacao = id_locacao;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Cliente getInquilino() {
		return inquilino;
	}

	public void setInquilino(Cliente inquilino) {
		this.inquilino = inquilino;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public double getPercentual_multa() {
		return percentual_multa;
	}

	public void setPercentual_multa(double percentual_multa) {
		this.percentual_multa = percentual_multa;
	}

	public Date getData_inicio_contrato() {
		return data_inicio_contrato;
	}

	public void setData_inicio_contrato(Date data_inicio_contrato) {
		this.data_inicio_contrato = data_inicio_contrato;
	}

	public Date getData_fim_contrato() {
		return data_fim_contrato;
	}

	public void setData_fim_contrato(Date data_fim_contrato) {
		this.data_fim_contrato = data_fim_contrato;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getVenc() {
		return venc;
	}

	public void setVenc(int venc) {
		this.venc = venc;
	}

	public BigDecimal getValor_aluguel() {
		return valor_aluguel;
	}

	public void setValor_aluguel(BigDecimal valor_aluguel) {
		this.valor_aluguel = valor_aluguel;
	}
	
	

	

	
	
	
	
	
}
