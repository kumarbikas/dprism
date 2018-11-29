package com.hcl.dprism.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println("configure method");
		  http.authorizeRequests().antMatchers("/login", "/logout").permitAll();
		http.authorizeRequests().antMatchers("/company").access("hasAnyRole('USER', 'ADMIN')");
		 http.csrf().disable().authorizeRequests().anyRequest().permitAll();
		//http.authorizeRequests().antMatchers("/").permitAll()				
		http.authorizeRequests().and().formLogin()
		//.anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().defaultSuccessUrl("/company").
				and().logout().permitAll();
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/").access("hasAnyRole('USER', 'ADMIN')")					
				.antMatchers("/css/**", "/images/**","/**/*.js").permitAll()				
				.anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll();
	}

	
	/**
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("appuser")
		.password("app123").roles("USER")
		.and()
		.withUser("admin")
		.password("admin123")
		.roles("USER", "ADMIN");;
	}

	
	
}
