package com.react.service;

import java.util.List;

import com.react.model.Product;

public interface ProductService {
    public Product saveProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(Integer id);
    public String deleteProduct(Integer id);
    public Product editProduct(Product oldProduct,Integer id);
}
