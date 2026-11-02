package org.example.springclass;

import org.example.springclass.demos.web.jpa.entity.ProductEntity;
import org.example.springclass.demos.web.jpa.repository.ProductRepository;
import org.example.springclass.demos.web.mapper.ArticleMapper;
import org.example.springclass.demos.web.mapper.CommentMapper;
import org.example.springclass.demos.web.pojo.article;
import org.example.springclass.demos.web.pojo.comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringclassApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private ArticleMapper articleMapper;
    @Test
    public void test3(){
        article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }

    @Autowired
    private CommentMapper commentMapper;
    @Test
    public void test4(){
        comment comment = commentMapper.findById(2);
        System.out.println(comment);
    }

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void teatMethodName(){
        productRepository.findByNameContainingAndStatus("小米",1)
                .forEach(p -> System.out.println(p.getName()));

    }
}
