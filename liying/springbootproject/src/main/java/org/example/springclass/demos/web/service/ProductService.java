package org.example.springclass.demos.web.service;

import org.example.springclass.demos.web.pojo.Category;
import org.example.springclass.demos.web.pojo.Product;
import org.example.springclass.demos.web.pojo.ProductVO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductVO> searchProduct(String name, BigDecimal minPrice, BigDecimal maxPrice, Integer categoryId);

    List<Category> getAllCategory();

    int updateStatusBatch(List<Integer> ids, Integer status);
    int updateSelective(Product product);
}
