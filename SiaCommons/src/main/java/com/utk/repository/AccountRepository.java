package com.utk.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.utk.constants.Constant;
import com.utk.mapper.AccountRowMapper;
import com.utk.model.Account;

@Repository
public class AccountRepository {

	private final JdbcTemplate jdbcTemplate;

	public AccountRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Account findAccountById(long id) {
		return jdbcTemplate.queryForObject(Constant.GETACCOUNTBYID, new AccountRowMapper(), id);
	}

	public List<Account> getAllAccounts() {
		return jdbcTemplate.query(Constant.GETALLACCOUNTS, new AccountRowMapper());
	}

	public void updateAmount(long id, BigDecimal amount) {
		jdbcTemplate.update(Constant.UPDATEWALLETAMOUNT, amount, id);
	}
}
