package kr.or.connect.pj3be.service;

import kr.or.connect.pj3be.dto.Product;

import java.util.List;

public interface ProductService {
    public static final Integer LIMIT = 4;
    public List<Product> getList(Integer categoryId, Integer start);
    public Integer getCount(Integer categoryId);
}
