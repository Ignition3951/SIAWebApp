package com.utk.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.utk.model.Product;
import com.utk.service.ProductService;

@Controller
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/products")
	public String addProducts(Model page, Product product) {
		productService.addProducts(product);
		List<Product> products = productService.findAllProducts();
		page.addAttribute("products", products);
		return "products.html";
	}

	@GetMapping("/products")
	public String viewProduct(Model model) {
		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		return "products.html";
	}

}
