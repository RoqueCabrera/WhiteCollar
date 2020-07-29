package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PaintingDTO;
import com.example.demo.entities.Painting;
import com.example.demo.entities.Store;
import com.example.demo.repository.PaintingsRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.services.PaintingsService;
import com.example.demo.services.StoreService;

@RestController
public class Controller 
{

	//DEFINING STORE REPOSITORY
	@Autowired
	StoreService storeService;
	//-------------------------
	
	//DEFINING PAINTING REPOSITORY
	@Autowired
	PaintingsService paintingsService;
	//----------------------------
	
	//ADD STORE AT ENDPOINT
	@RequestMapping(method=RequestMethod.POST,value={"/stores"})
	public void createStore(@RequestBody Store store)
	{
		storeService.save(store);
	}
	//----------------------
	
	
	//GET THE LIST OF STORES AT ENDPOINT
	@RequestMapping(method=RequestMethod.GET,value={"/stores"})
	public List<Store> getStores()
	{
		return storeService.findAll();
	}
	//----------------------------------
	
	
	//ADD PAINTING AT ENDPOINT
	@RequestMapping(method=RequestMethod.POST,value={"/paintings"})
	public void createPainting(@RequestBody PaintingDTO paintingDTO)
	{
		paintingsService.save(paintingDTO);
		
		
	}
	//-----------------------
	
	/*//GET THE LIST OF PAINTINGS AT ENDPOINT
	@RequestMapping(method=RequestMethod.GET,value={"/paintings"})
	public List<Painting> getPaintings()
	{
		return repoP.findAll();
	}
	//-------------------------------------*/
	
	//GET THE LIST OF PAINTINGS AT ENDPOINT
		@RequestMapping(method=RequestMethod.GET,value={"/stores/{storeId}"})
		public List<Painting> getPaintingsByStoreId(@PathVariable Integer storeId)
		{
			return paintingsService.paintingsByStoreId(storeId);
		}
		//-------------------------------------
}
