package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Store;
import com.example.demo.repository.PaintingsRepository;
import com.example.demo.repository.StoreRepository;

@SpringBootApplication
public class WhiteCollarApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(WhiteCollarApplication.class, args);
	}
	
	@Component
	@Order(1)
	public class ApplicationStarttupRunner implements CommandLineRunner
	{
		@Autowired
		StoreRepository repo;
		@Autowired
		PaintingsRepository paintingRepo;
		
		@Override
		public void run(String...args)throws Exception{
			repo.save(new Store("StoreOne",10));
			repo.save(new Store("StoreTwo",10));
		}
	}

}
