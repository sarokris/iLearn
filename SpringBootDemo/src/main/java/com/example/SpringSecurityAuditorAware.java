/**
 * Edit
 */
package com.example;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Admin
 *
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

	/* (non-Javadoc)
	 * @see org.springframework.data.domain.AuditorAware#getCurrentAuditor()
	 */
	@Override
	public Optional<String> getCurrentAuditor() {
		Optional<Authentication> authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
		return Optional.of(authentication.map(Authentication::getName).orElse(AppConstants.SYSTEM));
	}

}
