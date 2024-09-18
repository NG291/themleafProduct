package com.themleafproduct.service;

import com.themleafproduct.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {
    private static final Map<Long, Product> products;

    static {
        products = new HashMap<>();
        products.put(1L, new Product(1L, "iPhone 1", 10.0, "Sản phẩm Apple", "Việt Nam"));
        products.put(2L, new Product(2L, "iPhone 2", 20.0, "Sản phẩm Apple", "Việt Nam"));
        products.put(3L, new Product(3L, "iPhone 3", 30.0, "Sản phẩm Apple", "Việt Nam"));
        products.put(4L, new Product(4L, "iPhone 4", 40.0, "Sản phẩm Apple", "Việt Nam"));
        products.put(5L, new Product(5L, "iPhone 5", 50.0, "Sản phẩm Apple", "Việt Nam"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(Long id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(Long id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(Long id) {
        products.remove(id);
    }

    @Override
    public List<Product> FindByName(String name) {
        List<Product> result = new ArrayList<>();
        for(Product product : products.values()){
            if(product.getName().equalsIgnoreCase(name)){
                result.add(product);
            }
        }
        return result;
    }


}
