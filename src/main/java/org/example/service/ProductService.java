package org.example.service;

import org.example.documents.Products;
import org.example.repository.ProductRepository;

public class ProductService {
    ProductRepository productRepository;
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public void addProduct(Products product)
    {
        productRepository.addProduct(product);
    }
}
