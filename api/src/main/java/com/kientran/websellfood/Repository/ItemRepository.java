package com.kientran.websellfood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kientran.websellfood.Entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
