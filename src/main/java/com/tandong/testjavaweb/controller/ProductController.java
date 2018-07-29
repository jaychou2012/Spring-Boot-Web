package com.tandong.testjavaweb.controller;

import com.tandong.testjavaweb.entity.Product;
import com.tandong.testjavaweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@SpringBootApplication
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @ResponseBody
    @GetMapping(value = "/addProduct")
    public Object addProduct() {
        Product product = new Product();
        product.setDate(new Date());
        product.setDescription("描述");
        product.setName("名字");
        product.setPrice(20);
        productService.addProduct(product);
        return "插入成功";
    }

    @GetMapping(value = "/getList")
    public List<Product> getList() {
        return productService.getProducts();
    }

    @GetMapping(value = "/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @ResponseBody
    @GetMapping(value = "/addProductMapper")
    public Object addProductMapper() {
        Product product = new Product();
        product.setDate(new Date());
        product.setDescription("描述");
        product.setName("名字");
        product.setPrice(20);
        productService.addProductMapper(product);
        return "插入成功";
    }

    @GetMapping(value = "/getListMapper")
    public List<Product> getListMapper() {
        return productService.getProductsMapper();
    }

    @GetMapping(value = "/mapper/{idMapper}")
    public Product getProductByIdMapper(@PathVariable Integer idMapper) {
        return productService.getProductByIdMapper(idMapper);
    }
}
