package kr.or.connect.pj3be.controller;

import kr.or.connect.pj3be.dto.displayInfo.DisplayInfo;
import kr.or.connect.pj3be.dto.displayInfo.DisplayInfoResponse;
import kr.or.connect.pj3be.dto.product.Product;
import kr.or.connect.pj3be.dto.product.ProductResponse;
import kr.or.connect.pj3be.service.DisplayInfoService;
import kr.or.connect.pj3be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api/products")
public class ProductApiController {

    @Autowired
    private ProductService productService;
    @Autowired
    private DisplayInfoService displayInfoService;

    @GetMapping
    public ProductResponse getProducts(@RequestParam(required = false) Integer categoryId,
                                       @RequestParam(required = false, defaultValue = "0") Integer start){

        List<Product> items = productService.getProducts(categoryId,start);
        Integer totalCount = productService.getProductsCount(categoryId);

        ProductResponse productResponse = new ProductResponse();
        productResponse.setItems(items);
        productResponse.setTotalCount(totalCount);

        return productResponse;
    }

    @GetMapping("/{displayInfoId}")
    public DisplayInfoResponse getDisplayInfo(@PathVariable Integer displayInfoId){
        return displayInfoService.getDisplayInfoResponse(displayInfoId);
    }
}
