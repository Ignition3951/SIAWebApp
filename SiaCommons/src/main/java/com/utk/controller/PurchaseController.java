package com.utk.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utk.model.Purchase;
import com.utk.repository.PurchaseRepository;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	private final PurchaseRepository purchaseRepository;

	public PurchaseController(PurchaseRepository purchaseRepository) {
		this.purchaseRepository = purchaseRepository;
	}

	@PostMapping
	public void storePurchase(@RequestBody Purchase purchase) {
		purchaseRepository.storePurchase(purchase);
	}

	@GetMapping
	public List<Purchase> findAllPurchases() {
		return purchaseRepository.findAllProducts();
	}

}
