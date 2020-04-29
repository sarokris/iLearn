package com.example.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthProvider  implements AuthenticationProvider{
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
			String userName = authentication.getName();
			String pwd = authentication.getCredentials().toString().trim();
			String pswd = "password";
			Set<GrantedAuthority> roles = new HashSet<>();
			if("User".equalsIgnoreCase(userName) && (pswd).equals(pwd)) {
				roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			}else if ("Admin".equalsIgnoreCase(userName) && (pswd).equals(pwd)){
				roles.add(new SimpleGrantedAuthority("ROLE_USER"));
				roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
			authentication = new UsernamePasswordAuthenticationToken(userName,pwd,roles);
			return authentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
