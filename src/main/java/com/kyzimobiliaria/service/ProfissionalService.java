package com.kyzimobiliaria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyzimobiliaria.model.Profissional;
import com.kyzimobiliaria.repository.Profissionais;

@Service
public class ProfissionalService {

	@Autowired
	private Profissionais profissionais;
	
	@Transactional
	public void salvarProfissional(Profissional profissional){
		Profissional profissionalDeletado = profissionais.findByCreci(profissional.getCreci());
		if(profissionalDeletado != null){
			profissional.setId_profissional(profissionalDeletado.getId_profissional());
			profissionais.save(profissional);
		}
		
		profissionais.save(profissional);
	}

	public Profissional getProfissionalId(int id) {
		return profissionais.getOne(id);
	}
	
	@Transactional
	public void deletarProfissional(int id) {
		Profissional profissional = profissionais.findOne(id);
		profissional.setAtivo(false);
		profissionais.save(profissional);		
	}

	public List<Profissional> getTodosProfissionais() {
		return profissionais.selectTodosProfissionais();
	}

	public Profissional getProfissionalPeloCreci(int creci) {
		return profissionais.findByCreci(creci);
	}

}
