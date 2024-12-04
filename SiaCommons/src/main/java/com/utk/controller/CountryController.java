package com.utk.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utk.model.Country;

@RestController
public class CountryController {

	@GetMapping("/france")
	public ResponseEntity<Country> getCountryFrance() {
		Country country = Country.of("France", 27);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("continent", "europe").header("capital", "Paris")
				.header("favorite_food", "cheese and wine").body(country);

	}

	@GetMapping("/countries")
	public List<Country> getCountries() {
		Country countryFrance = Country.of("France", 27);
		Country countryItaly = Country.of("Italy", 23);
		return List.of(countryFrance, countryItaly);

	}
}
