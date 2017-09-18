package com.kyzimobiliaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kyzimobiliaria.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, String>{
	
	Cliente findById(Long id);

	Cliente findByCpf(String cpfProprietario);
	
	@Query(value = "SELECT * FROM cliente where ativo = true", nativeQuery = true)
	List<Cliente> selectTodosClientes();

	Cliente findByEmail(String email);
	
}
