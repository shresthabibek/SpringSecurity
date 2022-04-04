package com.bibek.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bibek.model.Accounts;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long>{
	
	Accounts findByCustomerId(int customerId);

}
