package br.com.internet.kelysm.listaDeCompraapp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.internet.kelysm.listaDeCompraapp.service.UsuarioCustomizadoDetalhesService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioCustomizadoDetalhesService userDetailsService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/*/protected/**").hasRole("USER")
				.antMatchers("/*/admin/**").hasRole("ADMIN")
				.and()
			.httpBasic()
			.and()
			.csrf()
			.disable();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("ysmarks").password("{noop}senha2019").roles("USER", "ADMIN")
		.and()
		.withUser("kelly").password("{noop}senha2017").roles("USER");
	}
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//	}
}
