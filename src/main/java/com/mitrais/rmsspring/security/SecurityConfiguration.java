package com.mitrais.rmsspring.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mitrais.rmsspring.service.MyUserDetailService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	// create users - matthew/test
		
	@Autowired
	private MyUserDetailService userDetailService;
			
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
		throws Exception
	{
		auth.userDetailsService(userDetailService)
			.passwordEncoder(encoder());
		//auth.inMemoryAuthentication().withUser("tests").password("{noop}test").roles("USER","ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/", "/*list*/**").hasAuthority("USER")
		.and()
		.formLogin().defaultSuccessUrl("/", true)
		.usernameParameter("username")
		.passwordParameter("password")
		.permitAll();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
