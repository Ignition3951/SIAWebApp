package com.utk.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.utk.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

	List<Account> findAccountByName(String name);

	@Query("update account set amount= :amount where id= :id")
	@Modifying
	void changeAmount(long id, BigDecimal amount);

	@Query("SELECT * FROM account")
	List<Account> getAllAccountDetails();

}
