package com.backslashwelsh.myquery.service;

import com.backslashwelsh.myquery.model.store.Product;
import com.backslashwelsh.myquery.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void create(Product product) {
        repository.save(product);
    }

    public List<Product> findAll(Sort sort) {
        return sort.isSorted() ? repository.findAll(sort)
                : repository.findAll(Sort.by("name"));
    } //todo maybe later https://howtodoinjava.com/spring-boot2/pagination-sorting-example/

    public Product findById(int id) {
        return repository.findById(id).orElseThrow();
    }

    public void update(int id, Product product) {
        Product productDatabase = findById(id);
        BeanUtils.copyProperties(product, productDatabase, "id");
        repository.save(productDatabase);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public boolean isDependsOnOrderItem(int id) {
        return repository.isDependsOnOrderItem(id);
    }

}
