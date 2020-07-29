package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Painting;

//CREATE A PAINTINGS REPOSITORY THAT EXTENDS FROM JPAREPOSITORY
@Repository
public interface PaintingsRepository extends JpaRepository<Painting, Integer>
{
	@Query("SELECT p FROM Painting p WHERE p.store.id = :storeId")
	List<Painting>paintingsByStoreId(Integer storeId);
	
}
//-------------------------------------------------------------