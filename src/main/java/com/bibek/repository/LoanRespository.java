package com.bibek.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bibek.model.Loans;

@Repository
public interface LoanRespository extends CrudRepository<Loans, Long>{
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
