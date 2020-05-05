package com.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.AppConstants;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private CustomAuthProvider authProvider;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.authenticationProvider(authProvider);
//
//	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles(AppConstants.ROLE_USER).and()
				.withUser("admin").password("{noop}admin").roles(AppConstants.ROLE_ADMIN);

	}

//	@Bean
//	public PasswordEncoder getEncoder() {
//		return new Noop
//	}

	// Secure the endpoins with HTTP Basic authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/customer/**").hasAnyRole(AppConstants.ROLE_ADMIN).and()
				.authorizeRequests().antMatchers("/h2console/**").permitAll().and().formLogin().and().csrf().disable();
		http.headers().frameOptions().disable();
	}
}