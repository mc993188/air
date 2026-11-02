package org.example.springclass.demos.web.jpa.repository;

import org.example.springclass.demos.web.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends
        JpaRepository<CategoryEntity,Integer> {

}
