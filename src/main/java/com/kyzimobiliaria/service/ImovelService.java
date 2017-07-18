package com.kyzimobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyzimobiliaria.model.Imovel;
import com.kyzimobiliaria.repository.Imoveis;

@Service
public class ImovelService {
	
	@Autowired
	private Imoveis imoveis;
	
	public void salvarImovel(Imovel imovel){
		imoveis.save(imovel);
	}

	public List<Imovel> getTodosImoveis() {
		return imoveis.findAll();
	}
}
