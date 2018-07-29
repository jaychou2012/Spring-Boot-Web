package com.tandong.testjavaweb.dao;

import com.tandong.testjavaweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
