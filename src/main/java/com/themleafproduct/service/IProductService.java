package com.themleafproduct.service;

import com.themleafproduct.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void update(Long id, Product product);

    void remove(Long id);

    List<Product> FindByName(String name);
}
