package com.kientran.websellfood.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kientran.websellfood.Entity.Category;
import com.kientran.websellfood.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByCategory(Category category);
	
}
