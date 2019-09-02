package kr.or.connect.pj3be.dao;

import static kr.or.connect.pj3be.sql.PromotionDaoSqls.*;
import kr.or.connect.pj3be.dto.promotion.Promotion;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository
public class PromotionDao {

    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Promotion> promotionRowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);

    public PromotionDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);

    }

    public List<Promotion> getAllPromotions(){
        return this.jdbc.query(SELECT_ALL_PROMOTIONS, Collections.emptyMap(), promotionRowMapper);
    }
}
