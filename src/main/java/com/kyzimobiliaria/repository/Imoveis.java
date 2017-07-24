package com.kyzimobiliaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kyzimobiliaria.model.Imovel;

public interface Imoveis extends JpaRepository<Imovel, Integer>{
	
	@Query(value = "SELECT * FROM imoveis WHERE ativo = true", nativeQuery=true)
	List<Imovel> selectTodosImoveis();
}
