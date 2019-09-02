package kr.or.connect.pj3be.sql;

public class CommentDaoSqls {
    public static final String SELECT_ALL_COMMENTS_BY_PRODUCT_ID = "SELECT c.comment, " +
            "c.id as comment_id, " +
            "c.create_date, " +
            "c.modify_date, " +
            "c.product_id, " +
            "r.reservation_date, " +
            "r.reservation_email, " +
            "r.id as reservation_info_id, " +
            "r.reservation_name, " +
            "r.reservation_tel as reservation_telephone, " +
            "c.score " +
            "FROM reservation_user_comment c " +
            "INNER JOIN reservation_info r " +
            "ON c.product_id = :productId AND c.reservation_info_id = r.id";

    public static final String SELECT_ALL_COMMENT_IMAGES_BY_COMMENT_ID = "SELECT f.content_type, " +
            "f.create_date, " +
            "f.delete_flag, " +
            "f.id as file_id, " +
            "f.file_name, " +
            "img.id as image_id, " +
            "f.modify_date, " +
            "img.reservation_info_id, " +
            "img.reservation_user_comment_id, " +
            "f.save_file_name " +
            "FROM reservation_user_comment_image as img " +
            "INNER JOIN file_info f " +
            "ON img.reservation_user_comment_id = :commentId and img.file_id = f.id";

}
