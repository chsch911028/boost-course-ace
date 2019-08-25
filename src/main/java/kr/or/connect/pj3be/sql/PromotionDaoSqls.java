package kr.or.connect.pj3be.sql;

public class PromotionDaoSqls {
    public static final String SELECT_ALL="select pr.id, p.id as product_id, f.file_name as product_image_url FROM promotion pr INNER JOIN product p on pr.product_id = p.id INNER JOIN product_image img on p.id = img.product_id and img.type = \"th\" INNER JOIN file_info f on img.file_id = f.id";
}
