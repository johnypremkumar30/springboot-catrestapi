package com.cat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cat.app.model.CatBreed;

@Repository
public interface CatBreedRepository extends JpaRepository<CatBreed, Long>{

	
	
	
}