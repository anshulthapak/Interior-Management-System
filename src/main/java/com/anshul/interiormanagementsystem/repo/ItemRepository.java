package com.anshul.interiormanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anshul.interiormanagementsystem.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	
//	@Query("SELECT i FROM Item i WHERE i.name = name AND i.brand = brand")
//	Item findByNameAndBrand(String name, String brand);
	

}
