package kr.or.connect.pj3be.service;

import kr.or.connect.pj3be.dao.ProductDao;
import kr.or.connect.pj3be.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    public static final Integer LIMIT = 4;

    @Autowired
    ProductDao repository;

    @Transactional
    public List<Product> getList(Integer categoryId, Integer start){
        return repository.selectAll(categoryId, start, ProductService.LIMIT);
    }

}
