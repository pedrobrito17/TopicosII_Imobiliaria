package com.kyzimobiliaria.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/kyzimobiliaria/buscar/clientes").hasRole("PROFISSIONAL")
			.antMatchers("/kyzimobiliaria/buscar/locacoes").hasRole("PROFISSIONAL")
			.antMatchers("/kyzimobiliaria/imovel/**").hasRole("PROFISSIONAL")
			.antMatchers("/kyzimobiliaria/locacao/**").hasRole("PROFISSIONAL")
			.antMatchers("/kyzimobiliaria/excluir/imovel").hasRole("PROFISSIONAL")
			
			// permite tudo que não foi bloqueado anteriormente
		    .antMatchers("/**").permitAll()
		    
		    // libera os arquivos estáticos
		    .antMatchers("/resources/**").permitAll()
		    
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
		.and()
			.logout()
				.logoutSuccessUrl("/login?Logout")
				//.logoutUrl("/kyzimobiliaria/home")
				.permitAll();
	}
	
/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("carlos").password("123").roles("PROFISSIONAL")
			.and()
			.withUser("flavio").password("123").roles("PROFISSIONAL");
	}*/

}
