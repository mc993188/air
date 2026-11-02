package org.example.springclass.demos.web.Controller;


import org.example.springclass.demos.web.mapper.ProductMapper;
import org.example.springclass.demos.web.pojo.Product;
import org.example.springclass.demos.web.pojo.ProductVO;
import org.example.springclass.demos.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;

    // 商品多条件查询：所有条件均为可选
    @GetMapping("/product/list")
    public String list(Model model,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) BigDecimal minPrice,
                       @RequestParam(required = false) BigDecimal maxPrice,
                       @RequestParam(required = false) Integer categoryId) {
        List<ProductVO> products = productService.searchProduct(name, minPrice, maxPrice, categoryId);
        model.addAttribute("products", products);
        model.addAttribute("categories", productService.getAllCategory());
        // 把查询条件放回页面，实现条件回显
        model.addAttribute("name", name);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("categoryId", categoryId);
        return "product/manageProduct";
    }

    // 批量上架/下架
    @PostMapping("/product/status")
    public String updateStatus(@RequestParam(required = false) List<Integer> ids, Integer status) {
        if (ids != null && !ids.isEmpty()) {
            productService.updateStatusBatch(ids, status);
        }
        return "redirect:/product/list";
    }

    // 1. 跳转到编辑页面（GET请求）
    @GetMapping("/product/edit/{id}")
    public String editPage(@PathVariable("id") Integer id, Model model) {
        // 这里需要用到逆向生成的 ProductMapper 来根据 ID 查询商品
        Product product = productMapper.selectByPrimaryKey(id);

        model.addAttribute("product", product);
        model.addAttribute("categories", productService.getAllCategory());
        return "product/editProduct"; // 返回编辑页面模板
    }

    // 2. 接收修改表单并更新数据库（POST请求）
    @PostMapping("/product/update")
    public String updateProduct(Product product) {
        // 调用 Service 动态更新（因为 XML 里用了 <if>，所以传过去的对象里哪些属性有值，就只会 update 哪些字段）
        productService.updateSelective(product);
        // 修改成功后，重定向回商品列表页
        return "redirect:/product/list";
    }

//    @GetMapping("/products")
//    public String GetproductList(Model model){
//        ArrayList<produce>produceArrayList=new ArrayList<>();
//        produceArrayList.add(new produce(1,"五金","https://img14.360buyimg.com/n2/s480x480_jfs/t20280819/496254/37/14565/113909/6a8695b0F6ba9fb7e/0a023203203dd9a8.jpg",170.53,30000,"五金专卖店"));
//        produceArrayList.add(new produce(2,"儿童椅子","https://img11.360buyimg.com/n2/s480x480_jfs/t1/426787/38/364/604127/69eb44feF7be44e10/093532032038ef06.png",14.9,6000,"儿童用品专卖店"));
//        produceArrayList.add(new produce(3,"真皮沙发","https://img14.360buyimg.com/n2/s480x480_jfs/t1/419921/11/2505/146152/69dca7c3F3df37b52/00833203202f1541.jpg",2600.00,900,"家具专卖店"));
//        produceArrayList.add(new produce(4,"分段式实木衣柜","https://img12.360buyimg.com/n2/s480x480_jfs/t1/464267/21/930/66505/6a389e53Fc3955dd2/00833203207945ef.jpg",2537.89,10000,"实木用品专卖店"));
//        model.addAttribute("productList",produceArrayList);
//        return "products";
//    }
}
