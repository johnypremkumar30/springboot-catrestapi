package com.cat.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cat.app.service.CatBreedService;
import com.cat.appmodel.CatBreed;

@RestController
public class CatBreedController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CatBreed.class);

	@Autowired
	CatBreedService catBreedService;

	@GetMapping("/breeds")
	public ResponseEntity<List<CatBreed>> getAllBreeds() {
		return ResponseEntity.ok().body(catBreedService.getAllCatBreed());
	}

	@PostMapping("/breeds")
	public ResponseEntity<CatBreed> addBreed(@RequestBody CatBreed catBreed) {
		return ResponseEntity.ok().body(catBreedService.addBreed(catBreed));
	}

}
