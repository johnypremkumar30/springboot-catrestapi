package com.cat.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cat.appmodel.CatBreed;

@Service
@Transactional
public class CatBreedServiceImpl implements CatBreedService {

	@Override
	public CatBreed addBreed(CatBreed catBreed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatBreed> getAllCatBreed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CatBreed> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

}
