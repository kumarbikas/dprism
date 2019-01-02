package com.hcl.dprism.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hcl.dprism.service.UserDetailsServiceImpl;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	    private UserDetailsServiceImpl userDetailsService;
	
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
		http.authorizeRequests().antMatchers("/").access("hasAnyRole('USER', 'ADMIN','MANAGER')")					
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

		/*auth.inMemoryAuthentication()
        .withUser("appuser").password(passwordEncoder().encode("app123")).roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN");*/
		
		// Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
}
