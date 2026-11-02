package org.example.springclass.demos.web.service.impl;

import org.example.springclass.demos.web.mapper.CategoryMapper;
import org.example.springclass.demos.web.mapper.ProductExtMapper;
import org.example.springclass.demos.web.pojo.Category;
import org.example.springclass.demos.web.pojo.Product;
import org.example.springclass.demos.web.pojo.ProductVO;
import org.example.springclass.demos.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductExtMapper productExtMapper;   // 手写的扩展Mapper
    @Autowired
    private CategoryMapper categoryMapper;       // 逆向生成的Mapper

    @Override
    public List<ProductVO> searchProduct(String name, BigDecimal minPrice, BigDecimal maxPrice, Integer categoryId) {
        return productExtMapper.searchProduct(name, minPrice, maxPrice, categoryId);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.selectAll();
    }

    @Override
    public int updateStatusBatch(List<Integer> ids, Integer status) {
        return productExtMapper.updateStatusBatch(ids, status);
    }

    @Override
    public int updateSelective(Product product) {
        return productExtMapper.updateSelective(product);
    }
}
