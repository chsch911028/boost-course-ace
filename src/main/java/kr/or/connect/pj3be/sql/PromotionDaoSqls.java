package kr.or.connect.pj3be.sql;

public class PromotionDaoSqls {
    public static final String SELECT_ALL_PROMOTIONS="SELECT pr.id, " +
            "p.id as product_id, " +
            "f.file_name as product_image_url " +
            "FROM promotion pr " +
            "INNER JOIN product p " +
            "ON pr.product_id = p.id " +
            "INNER JOIN product_image img " +
            "ON p.id = img.product_id AND img.type = \"th\" " +
            "INNER JOIN file_info f " +
            "ON img.file_id = f.id";
}
