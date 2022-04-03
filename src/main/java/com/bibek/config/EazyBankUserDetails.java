package com.bibek.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bibek.model.Customer;
import com.bibek.model.SecurityCustomer;
import com.bibek.repository.CustomerRepository;

@Service
public class EazyBankUserDetails implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Customer> customer =  customerRepository.findByEmail(username);
		if(customer.size() == 0) {
			throw new UsernameNotFoundException("User details not found for the user: " + username );
		}
//		System.out.println(customer);
//		SecurityCustomer securityCustomer = new SecurityCustomer(customer.get(0));
//		System.out.println("**********" + securityCustomer);
//		return securityCustomer;
		return new SecurityCustomer(customer.get(0));
		
	}
	
	
}
