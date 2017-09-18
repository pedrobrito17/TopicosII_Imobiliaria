package com.kyzimobiliaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.GrantedAuthority;

import com.kyzimobiliaria.model.Role;

public interface Roles extends JpaRepository<Role, Integer> {
	
	@Query(value="SELECT u.email, p.role as nome_permissao FROM profissional_permissoes up "+
			"JOIN profissional u ON u.id_profissional = up.prof_id "+
			"JOIN role p ON p.id = up.permissoes_id "+
			"WHERE u.email = :email ", nativeQuery=true)
	List<GrantedAuthority> getPermissoesUsuario(String email);


}
