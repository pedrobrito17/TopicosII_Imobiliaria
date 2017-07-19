package com.kyzimobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyzimobiliaria.model.TipoImovel;
import com.kyzimobiliaria.repository.TipoImoveis;

@Service
public class TipoImovelService {

	@Autowired
	private TipoImoveis tipoImoveis;
	
	public List<TipoImovel> getTodosTipoImoveis() {
		return tipoImoveis.findAll();
	}

}
