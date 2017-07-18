package com.kyzimobiliaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyzimobiliaria.model.Profissional;
import com.kyzimobiliaria.repository.Profissionais;

@Service
public class ProfissionalService {

	@Autowired
	private Profissionais profissionais;
	
	public void salvarProfissional(Profissional profissional){
		profissionais.save(profissional);
	}
		
	public Profissional getProfissional(String email, String senha){
		return profissionais.findByEmailAndSenha(email, senha);
	}

	public Profissional getProfissionalId(int id) {
		return profissionais.getOne(id);
	}

	public void deletarProfissional(Profissional profissional) {
		profissionais.delete(profissional);		
	}

}
