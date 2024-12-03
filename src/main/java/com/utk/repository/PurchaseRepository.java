package com.utk.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.utk.model.Purchase;

@Repository
public class PurchaseRepository {

	private final JdbcTemplate jdbcTemplate;

	public PurchaseRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void storePurchase(Purchase purchase) {
		String sql = "INSERT INTO PURCHASE (PRODUCT , PRICE ) VALUES (?,?);";
		jdbcTemplate.update(sql, purchase.getProduct(), purchase.getPrice());
	}

	public List<Purchase> findAllProducts() {
		String sql = "select * from purchase";
		RowMapper<Purchase> rowMapper = (r, i) -> {
			Purchase rowObject = new Purchase();
			rowObject.setId(r.getInt("id"));
			rowObject.setProduct(r.getString("product"));
			rowObject.setPrice(r.getBigDecimal("price"));
			return rowObject;
		};

		return jdbcTemplate.query(sql, rowMapper);

	}

}
