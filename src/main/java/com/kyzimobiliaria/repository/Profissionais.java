package com.kyzimobiliaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kyzimobiliaria.model.Cliente;
import com.kyzimobiliaria.model.Profissional;

public interface Profissionais extends JpaRepository<Profissional, Integer>{

	Profissional findByCreci(int creci);
	
	@Query(value = "SELECT * FROM profissional WHERE ativo = true", nativeQuery = true)
	List<Profissional> selectTodosProfissionais();
}
