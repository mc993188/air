package org.example.springclass.demos.web.Controller;

import org.example.springclass.demos.web.jpa.repository.CategoryRepository;
import org.example.springclass.demos.web.jpa.server.JpaProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class JpaProductController {
    @Autowired
    private JpaProductService jpaProductService;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/jpa/product/list")
    public String list(Model model,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) BigDecimal minPrice,
                       @RequestParam(required = false) BigDecimal maxPrice,
                       @RequestParam(required = false) Integer categoryId) {
        model.addAttribute("products", jpaProductService.searchProduct(name, minPrice, maxPrice, categoryId));
        model.addAttribute("categories", categoryRepository.findAll());
        // 把查询条件放回页面，实现条件回显
        model.addAttribute("name", name);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("categoryId", categoryId);
        return "jpa/productList";
    }
}
