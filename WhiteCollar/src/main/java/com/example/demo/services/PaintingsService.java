package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DTO.PaintingDTO;
import com.example.demo.entities.Painting;
import com.example.demo.entities.Store;
import com.example.demo.repository.PaintingsRepository;
import com.example.demo.repository.StoreRepository;

public class PaintingsService {
	@Autowired
	StoreRepository repo;
	@Autowired
	PaintingsRepository repoP;
	
	public void save (PaintingDTO paintingDTO){
		
		Painting painting = new Painting();
		painting.setAuthorName(paintingDTO.getAuthorName());
		painting.setName(paintingDTO.getName());
		painting.setPrice(paintingDTO.getPrice());
		
		Store store = repo.findById(paintingDTO.getStoreId()).get();
		painting.setStore(store);
		repoP.save(painting);
	}
	
	public List<Painting>findAll()
	{
		return repoP.findAll();
	}
	
	public List<Painting>paintingsByStoreId(Integer storeId)
	{
		return repoP.paintingsByStoreId(storeId);
	}
	
}
