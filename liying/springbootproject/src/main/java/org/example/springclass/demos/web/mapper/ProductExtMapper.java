package org.example.springclass.demos.web.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.springclass.demos.web.pojo.Product;
import org.example.springclass.demos.web.pojo.ProductVO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductExtMapper {
    // 多条件动态查询（<where> + <if> + <resultMap>）
    List<ProductVO> searchProduct(@Param("name") String name,
                                  @Param("minPrice") BigDecimal minPrice,
                                  @Param("maxPrice") BigDecimal maxPrice,
                                  @Param("categoryId") Integer categoryId);

    // 批量上架/下架（<foreach>）
    int updateStatusBatch(@Param("ids") List<Integer> ids, @Param("status") Integer status);

    // 只修改非空字段（<set> + <if>）
    int updateSelective(Product product);
}
