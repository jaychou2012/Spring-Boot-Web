package com.tandong.testjavaweb.service;

import com.tandong.testjavaweb.dao.ProductDao;
import com.tandong.testjavaweb.entity.Product;
import com.tandong.testjavaweb.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    @Autowired
    private ProductMapper productMapper;


    public List<Product> getProductsMapper() {
        return productMapper.getList();
    }

    public Product getProductByIdMapper(int id) {
        return productMapper.findById(id);
    }

    public void addProductMapper(Product product) {
        productMapper.addProduct(product.getName(),product.getDescription(),product.getPrice(),product.getDate());
    }

    public List<Product> getProducts() {
        return productDao.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productDao.findById(id);
    }

    public void addProduct(Product product) {
        productDao.saveAndFlush(product);
    }

}
