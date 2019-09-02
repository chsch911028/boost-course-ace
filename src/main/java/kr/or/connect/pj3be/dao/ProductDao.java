package kr.or.connect.pj3be.dao;


import static kr.or.connect.pj3be.sql.ProductDaoSqls.*;


import kr.or.connect.pj3be.dto.product.Product;

import kr.or.connect.pj3be.dto.product.ProductImage;
import kr.or.connect.pj3be.dto.product.ProductPrice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDao {

    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Product> productRowMapper = BeanPropertyRowMapper.newInstance(Product.class);
    private RowMapper<ProductImage> productImageRowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
    private RowMapper<ProductPrice> productPriceRowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);

    public ProductDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("product")
                .usingGeneratedKeyColumns("id");
    }

    public List<Product> getProductsAboutAllCategories(Integer start, Integer limit){
        Map<String, Integer> params = new HashMap<>();
        params.put("start", start);
        params.put("limit", limit);
        return this.jdbc.query(SELECT_PRODUCTS_ABOUT_ALL_CATEGORIES, params, productRowMapper);
    }

    public List<Product> getProductsByCategory(Integer categoryId, Integer start, Integer limit){
        Map<String, Integer> params = new HashMap<>();
        params.put("categoryId", categoryId);
        params.put("start", start);
        params.put("limit", limit);
        return this.jdbc.query(SELECT_PRODUCTS_BY_CATEGORY_ID, params, productRowMapper);
    }

    public Integer getAllProductsCount(){
        return jdbc.queryForObject(SELECT_ALL_PRODUCT_COUNT, Collections.emptyMap(), Integer.class);
    }

    public Integer getProductsCountByCategory(Integer categoryId){
        Map<String, Integer> params = Collections.singletonMap("categoryId", categoryId);
        return jdbc.queryForObject(SELECT_PRODUCT_COUNT_BY_CATEGORY_ID, params, Integer.class);
    }

    public Long insert(Product product) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(product);
        return insertAction.executeAndReturnKey(params).longValue();
    }

    /* ##### PRODUCT_IMAGE ##### */

    public List<ProductImage> getAllProductImages(Integer productId){
        Map<String, Integer> params = Collections.singletonMap("productId", productId);
        return this.jdbc.query(SELECT_ALL_PRODUCT_IMAGES_BY_PRODUCT_ID, params, productImageRowMapper);
    }

    /* ##### PRODUCT_PRICE ##### */

    public List<ProductPrice> getAllProductPrices(Integer productId){
        Map<String, Integer> params = Collections.singletonMap("productId", productId);
        return this.jdbc.query(SELECT_ALL_PRODUCT_PRICES_BY_PRODUCT_ID, params, productPriceRowMapper);
    }

}
