package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Store;

//CREATE A STORE REPOSITORY THAT EXTENDS FROM JPAREPOSITORY
@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>
{

}
//---------------------------------------------------------