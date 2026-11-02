package org.example.springclass.demos.web.jpa.server;



import org.example.springclass.demos.web.jpa.entity.ProductEntity;
import org.example.springclass.demos.web.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class JpaProductService {
    @Autowired
    private ProductRepository productRepository;

    // 构建多条件查询的Specification：参数非空才加入查询条件，作用相当于<where> + <if>
    private Specification<ProductEntity> buildSpec(String name, BigDecimal minPrice, BigDecimal maxPrice, Integer categoryId) {
        return (root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            if (StringUtils.hasText(name)) {
                list.add(cb.like(root.get("name"), "%" + name + "%"));
            }
            if (minPrice != null) {
                list.add(cb.ge(root.get("price"), minPrice));
            }
            if (maxPrice != null) {
                list.add(cb.le(root.get("price"), maxPrice));
            }
            if (categoryId != null) {
                list.add(cb.equal(root.get("category").get("id"), categoryId));
            }
            return cb.and(list.toArray(new Predicate[0]));
        };
    }

    // 多条件查询
    public List<ProductEntity> searchProduct(String name, BigDecimal minPrice, BigDecimal maxPrice, Integer categoryId) {
        return productRepository.findAll(buildSpec(name, minPrice, maxPrice, categoryId), Sort.by("id"));
    }
}
