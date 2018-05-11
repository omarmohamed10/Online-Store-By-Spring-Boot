package com.SWEPROJECT.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.SWEPROJECT.Entities.Product;

public interface ProductRepository extends 
CrudRepository<Product , Integer>
{

}
