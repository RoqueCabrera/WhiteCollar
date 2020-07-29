package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DTO.PaintingDTO;
import com.example.demo.entities.Store;
import com.example.demo.repository.PaintingsRepository;
import com.example.demo.repository.StoreRepository;

public class StoreService {
	@Autowired
	StoreRepository repo;
	@Autowired
	PaintingsRepository repoP;
	
	public void save(Store store) 
	{
		repo.save(store);
		
	}
	
	public List <Store> findAll()
	{
		return repo.findAll();
	}
}
