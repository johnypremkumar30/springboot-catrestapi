package com.cat.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cat.app.model.CatBreed;
import com.cat.app.repository.CatBreedRepository;

@Service
@Transactional
public class CatBreedServiceImpl implements CatBreedService {

	@Autowired
	CatBreedRepository catBreedRepository;
	
	@Override
	public CatBreed addBreed(CatBreed catBreed) {
		return catBreedRepository.save(catBreed);
	}

	@Override
	public List<CatBreed> getAllCatBreed() {
		return catBreedRepository.findAll();
	}

	@Override
	public Page<CatBreed> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return catBreedRepository.findAll(pageable);
	}

	public CatBreedRepository getCatBreedRepository() {
		return catBreedRepository;
	}

	public void setCatBreedRepository(CatBreedRepository catBreedRepository) {
		this.catBreedRepository = catBreedRepository;
	}

	public CatBreedServiceImpl(CatBreedRepository catBreedRepository) {
		super();
		this.catBreedRepository = catBreedRepository;
	}
}
