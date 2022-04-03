package com.bibek.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.bibek.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{

	List<Customer> findByEmail(String email);
}
