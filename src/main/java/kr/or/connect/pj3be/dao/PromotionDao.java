package kr.or.connect.pj3be.dao;

import static kr.or.connect.pj3be.sql.PromotionDaoSqls.*;
import kr.or.connect.pj3be.dto.Promotion;

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
    private SimpleJdbcInsert insertAction;
    private RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);

    public PromotionDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("promotion")
                .usingGeneratedKeyColumns("id");
    }

    public List<Promotion> selectAll(){
        return this.jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
    }
}
