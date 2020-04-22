package com.learn.ms.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
	
		http.authorizeRequests()
		.antMatchers(env.getProperty("api.h2.console.path.url")).permitAll()
		.antMatchers(HttpMethod.POST, env.getProperty("api.login.path.url")).permitAll()
		.antMatchers(HttpMethod.POST, env.getProperty("api.signup.path.url")).permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilter(new AuthorizationFilter(authenticationManager(), env));
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
