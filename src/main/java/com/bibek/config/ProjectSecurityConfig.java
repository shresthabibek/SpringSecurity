package com.bibek.config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().configurationSource(new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setMaxAge(3600L);
				return config;
			}
		}).and().csrf().ignoringAntMatchers("/contact").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().
		authorizeRequests().antMatchers("/myAccount").authenticated().antMatchers("/myBalance").authenticated()
				.antMatchers("/myLoans").authenticated().antMatchers("/myCards").authenticated()
				.antMatchers("/user").authenticated().antMatchers("/notices").permitAll()
				.antMatchers("/contact").permitAll().and().httpBasic();

		/*
		 * The default behavior of spring security is to authenticate the request we can
		 * customize the request. we can permit some endpoints and authenticate some
		 * endpoints like above we have to extend the WebSecurityConfigurerAdapter class
		 * and then override the configure method
		 * 
		 * we can also deny all and permit all the request with the method denyAll() and
		 * permitAll() shown below
		 * 
		 */

		/*
		 * http .authorizeRequests() .anyRequest()
		 * .permitAll().and().formLogin().and().httpBasic();
		 */
	}

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception{
	 * auth.inMemoryAuthentication().withUser("admin").password("12345").authorities
	 * ("admin").and() .withUser("user").password("12345").authorities("read").and()
	 * .passwordEncoder(NoOpPasswordEncoder.getInstance()); }
	 */

	// in memory authentication

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception{ InMemoryUserDetailsManager userDetailsService = new
	 * InMemoryUserDetailsManager(); UserDetails user =
	 * User.withUsername("admin").password("12345").authorities("admin").build();
	 * UserDetails user1 =
	 * User.withUsername("user").password("12345").authorities("read").build();
	 * userDetailsService.createUser(user); userDetailsService.createUser(user1);
	 * auth.userDetailsService(userDetailsService);
	 * 
	 * }
	 */

	/*
	 * @Bean public UserDetailsService userDetailsService(DataSource dataSource) {
	 * return new JdbcUserDetailsManager(dataSource); }
	 */

	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */

	
	 @Bean
	 public PasswordEncoder passwordEncoder() { 
	 	 return new BCryptPasswordEncoder(); 
	 }
	

}
