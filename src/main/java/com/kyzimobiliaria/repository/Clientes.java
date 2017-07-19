package com.kyzimobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyzimobiliaria.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, String>{

	Cliente findByEmailAndSenha(String email, String senha);
	
	Cliente findById(Long id);

	Cliente findByCpf(String cpfProprietario);
	
}
