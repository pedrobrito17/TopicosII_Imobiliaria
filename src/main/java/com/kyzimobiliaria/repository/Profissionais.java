package com.kyzimobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyzimobiliaria.model.Cliente;
import com.kyzimobiliaria.model.Profissional;

public interface Profissionais extends JpaRepository<Profissional, Integer>{
	
	Profissional findByEmailAndSenha(String email, String senha);
}
