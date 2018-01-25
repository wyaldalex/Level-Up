package com.focus.levelup.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				// TODO: needs to be change to only static files and login page
				.antMatchers("/resources/**").permitAll()
				//.antMatchers("/Roles/**").denyAll()
			.and()
			.formLogin()
				.loginPage("/").failureUrl("/login?error=true")
				.defaultSuccessUrl("/loginsuccess")
				.permitAll();
	}
}