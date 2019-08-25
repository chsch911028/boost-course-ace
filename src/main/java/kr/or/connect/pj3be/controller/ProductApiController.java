package kr.or.connect.pj3be.controller;

import kr.or.connect.pj3be.dto.Product;
import kr.or.connect.pj3be.service.ProductService;
import kr.or.connect.pj3be.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api/products")
public class ProductApiController {

    @Autowired
    ProductService productService;

    @GetMapping
    public Map<String, Object> list(@RequestParam(required = false) Integer categoryId,
                                    @RequestParam(required = false, defaultValue = "0") Integer start){

        System.out.println(categoryId + " " + start);
        List<Product> list = productService.getList(categoryId,start);
        Integer totalCount = productService.getCount(categoryId);

        Map<String, Object> map = new HashMap<>();
        map.put("items", list);
        map.put("totalCount", totalCount);
        return map;
    }

}
