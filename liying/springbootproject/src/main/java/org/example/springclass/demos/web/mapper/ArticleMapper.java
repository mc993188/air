package org.example.springclass.demos.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.springclass.demos.web.pojo.article;

@Mapper
public interface ArticleMapper {
    public article selectArticle(Integer id);
    public int updateArticle(article article);

}
