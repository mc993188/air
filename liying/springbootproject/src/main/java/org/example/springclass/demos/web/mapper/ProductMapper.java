package org.example.springclass.demos.web.mapper;

import java.util.List;
import org.example.springclass.demos.web.pojo.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    Product selectByPrimaryKey(Integer id);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);
}