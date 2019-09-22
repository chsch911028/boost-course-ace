package kr.or.connect.pj3be.service;

import kr.or.connect.pj3be.dao.CategoryDao;
import kr.or.connect.pj3be.dao.ProductDao;
import kr.or.connect.pj3be.dto.product.Product;
import kr.or.connect.pj3be.dto.product.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;

    @Transactional(readOnly = true)
    @Override
    public List<Product> getProducts(Integer categoryId, Integer start){

        if(categoryId == null){
            return productDao.getProductsAboutAllCategories(start, LIMIT);
        }

        return productDao.getProductsByCategory(categoryId,start, LIMIT);
    }

    @Transactional(readOnly = true)
    @Override
    public Integer getProductsCount(Integer categoryId){

        if(categoryId == null){
            return productDao.getAllProductsCount();
        }

        return productDao.getProductsCountByCategory(categoryId);
    }



}
