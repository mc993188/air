package org.example.springclass.demos.web.mapper;

import java.util.List;
import org.example.springclass.demos.web.pojo.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    Category selectByPrimaryKey(Integer id);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
}