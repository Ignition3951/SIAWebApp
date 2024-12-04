package com.utk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.utk.model.Product;

@Service
public class ProductService {

	List<Product> products = new ArrayList<>();

	public void addProducts(Product product) {
		products.add(product);
	}

	public List<Product> findAllProducts() {
		return products;
	}
}
