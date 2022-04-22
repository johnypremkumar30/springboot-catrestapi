package com.cat.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cat.app.service.CatBreedService;

@RestController
public class CatBreedController {

	@Autowired
	CatBreedService catBreedService;
	
}
