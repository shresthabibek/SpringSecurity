package com.bibek.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http .authorizeRequests() .antMatchers("/myAccount").authenticated()
		  .antMatchers("/myBalance").authenticated()
		  .antMatchers("/myCards").authenticated()
		  .antMatchers("/myLoans").authenticated() .antMatchers("/notices").permitAll()
		  .antMatchers("/contact").permitAll() .and() .formLogin() .and() .httpBasic();
		
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
	
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
