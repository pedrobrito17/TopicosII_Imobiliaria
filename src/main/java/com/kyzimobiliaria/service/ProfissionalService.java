package com.kyzimobiliaria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kyzimobiliaria.model.Profissional;
import com.kyzimobiliaria.model.Role;
import com.kyzimobiliaria.repository.Profissionais;
import com.kyzimobiliaria.repository.Roles;

@Service
public class ProfissionalService {

	@Autowired
	private Profissionais profissionais;
	
	@Autowired
	private Roles roles;
	
	@Transactional
	public void salvarProfissional(Profissional profissional){
		Profissional profissionalDeletado = profissionais.findByCreci(profissional.getCreci());
		if(profissionalDeletado != null){
			profissional.setId_profissional(profissionalDeletado.getId_profissional());
			profissionais.save(profissional);
		}
		Role role = roles.findOne(1); //ROLE_PROFISSIONAL
		profissional.getPermissoes().add(role);
		String senhaCriptografada = new BCryptPasswordEncoder().encode(profissional.getPassword());
		profissional.setPassword(senhaCriptografada);
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

	public Profissional getProfissionalEmail(String email) {
		return profissionais.findByEmail(email);
	}

}
