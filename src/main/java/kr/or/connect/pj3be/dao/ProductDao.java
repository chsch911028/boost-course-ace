package kr.or.connect.pj3be.dao;


import static kr.or.connect.pj3be.sql.ProductDaoSqls.*;
import kr.or.connect.pj3be.dto.Product;

import org.springframework.dao.EmptyResultDataAccessException;
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
    private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

    public ProductDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("product")
                .usingGeneratedKeyColumns("id");
    }

    public List<Product> selectAll(Integer categoryId, Integer start, Integer limit){
        Map<String, Integer> params = new HashMap<>();
        params.put("start", start);
        params.put("limit", limit);
        if(categoryId == null){
            return jdbc.query(SELECT_ALL_CATEGORY, params, rowMapper);
        }
        params.put("categoryId", categoryId);
        return jdbc.query(SELECT_BY_CATEGORY_ID, params, rowMapper);

    }

    public Integer selectCount(Integer categoryId){
        if(categoryId == null){
            return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
        }

        Map<String, Integer> params = Collections.singletonMap("categoryId", categoryId);
        return jdbc.queryForObject(SELECT_COUNT_BY_CATEGORY_ID, params, Integer.class);
    }

    public Long insert(Product product) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(product);
        return insertAction.executeAndReturnKey(params).longValue();
    }

}
