package com.cat.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cat.appmodel.CatBreed;

public interface CatBreedService {

	CatBreed addBreed(CatBreed catBreed);
	
	List<CatBreed> getAllCatBreed();
	
	Page<CatBreed> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
}
