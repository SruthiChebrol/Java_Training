package com.example.user.management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Configure the AuthenticationManagerBuilder
	 *
	 * @param auth The AuthenticationManagerBuilder
	 * @throws Exception If an error occurs
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password(bCryptPasswordEncoder()
		.encode("admin123")) // Encoded
		.roles("ADMIN");
	}

	/**
	 * Configures the HTTPSecurity
	 *
	 * @param http The HttpSecurity object to configure
	 * @throws Exception If an error occurs
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests.antMatchers("/api/**").hasRole("ADMIN").anyRequest().permitAll()).httpBasic().and().csrf().disable();
	}

	/**
	 * Provides a BCryptPasswordEncoder bean
	 *
	 * @return A BCryptPasswordEncoder instance used to encode passwords.
	 */
	@Bean
	public static BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
