package kr.or.connect.pj3be.service;

import kr.or.connect.pj3be.dto.product.Product;
import kr.or.connect.pj3be.dto.product.ProductResponse;

import java.util.List;

public interface ProductService {
    public static final Integer LIMIT = 4;
    public List<Product> getProducts(Integer categoryId, Integer start);
    public Integer getProductsCount(Integer categoryId);
}
