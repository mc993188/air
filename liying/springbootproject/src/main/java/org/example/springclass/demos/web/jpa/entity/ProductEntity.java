package org.example.springclass.demos.web.jpa.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name ="t_product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private Integer sales;
    @Column(name = "image_url")
    private String imageUrl;
    private Integer status;
    @Column(name = "create_time")
    private Date createTime;

    // 多对一：多个商品属于同一个分类，对应MyBatis中的<association>
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
