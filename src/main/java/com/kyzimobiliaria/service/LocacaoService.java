package com.kyzimobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyzimobiliaria.model.Locacao;
import com.kyzimobiliaria.repository.Locacoes;

@Service
public class LocacaoService {
	
	@Autowired
	private Locacoes locacoes;
	
	public void salvarLocacao(Locacao locacao){
		locacoes.save(locacao);
	}

	public List<Locacao> getTodasLocacoes() {
		return locacoes.findAll();
	}
}