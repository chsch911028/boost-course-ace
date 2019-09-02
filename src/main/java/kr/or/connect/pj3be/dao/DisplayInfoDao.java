package kr.or.connect.pj3be.dao;

import kr.or.connect.pj3be.dto.displayInfo.DisplayInfo;
import kr.or.connect.pj3be.dto.displayInfo.DisplayInfoImage;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

import static kr.or.connect.pj3be.sql.DisplayInfoDaoSqls.*;


@Repository
public class DisplayInfoDao {

    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<DisplayInfo> displayInfoRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
    private RowMapper<DisplayInfoImage> displayInfoImageRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);

    public DisplayInfoDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public DisplayInfo getDisplayInfo(Integer displayInfoId){
        Map<String, Integer> params = Collections.singletonMap("displayInfoId", displayInfoId);
        return this.jdbc.queryForObject(SELECT_DISPLAY_INFO_BY_DISPLAY_INFO_ID, params, displayInfoRowMapper);
    }

    public DisplayInfoImage getDisplayInfoImage(Integer displayInfoImageId) {
        Map<String, Integer> params = Collections.singletonMap("displayInfoImageId", displayInfoImageId);
        return this.jdbc.queryForObject(SELECT_DISPLAY_INFO_IMAGE_BY_DISPLAY_INFO_IMAGE_ID, params, displayInfoImageRowMapper);
    }
}
