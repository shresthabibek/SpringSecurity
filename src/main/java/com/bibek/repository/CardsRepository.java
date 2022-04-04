package com.bibek.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bibek.model.AccountTransactions;
import com.bibek.model.Cards;

@Repository
public interface CardsRepository extends CrudRepository<AccountTransactions, Long>{

	List<Cards> findByCustomerId(int customerId);
	
}
