package com.kyzimobiliaria.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class UdsSecurityConfig {
	
	public static final String USUARIO_POR_LOGIN = "SELECT email, password, ativo, nome FROM profissional WHERE email = ?";
	
	public static final String PERMISSOES_POR_USUARIO = "SELECT u.email, p.role as nome_permissao FROM profissional_permissoes up "+
			"JOIN profissional u ON u.id_profissional = up.prof_id "+
			"JOIN role p ON p.id = up.permissoes_id "+
			"WHERE u.email = ?";
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder, 
			PasswordEncoder passwordEncoder, 
			DataSource dataSource) throws Exception {
		builder
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder)
			.usersByUsernameQuery(USUARIO_POR_LOGIN)
			.authoritiesByUsernameQuery(PERMISSOES_POR_USUARIO);
	}
	
}
























