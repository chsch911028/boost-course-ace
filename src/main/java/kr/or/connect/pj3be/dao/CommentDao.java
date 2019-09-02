package kr.or.connect.pj3be.dao;

import kr.or.connect.pj3be.dto.comment.Comment;
import kr.or.connect.pj3be.dto.comment.CommentImage;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.or.connect.pj3be.sql.CommentDaoSqls.*;

@Repository
public class CommentDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Comment> commentRowMapper = BeanPropertyRowMapper.newInstance(Comment.class);
    private RowMapper<CommentImage> commentImageRowMapper = BeanPropertyRowMapper.newInstance(CommentImage.class);

    public CommentDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Comment> getAllComments(Integer productId){
        Map<String, Integer> params = Collections.singletonMap("productId", productId);
        return this.jdbc.query(SELECT_ALL_COMMENTS_BY_PRODUCT_ID, params, commentRowMapper);
    }

    public List<CommentImage> getAllCommentImagesByComment(Integer commentId){
        Map<String, Integer> params = Collections.singletonMap("commentId", commentId);
        return this.jdbc.query(SELECT_ALL_COMMENT_IMAGES_BY_COMMENT_ID, params, commentImageRowMapper);
    }
}
