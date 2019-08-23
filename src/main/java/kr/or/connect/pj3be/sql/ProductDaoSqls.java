package kr.or.connect.pj3be.sql;

public class ProductDaoSqls {
    public static final String SELECT_ALL_CATEGORY = "SELECT d.id as display_info_id, d.place_name as place_name, p.content as product_content, p.description as product_description, p.id as product_id, f.file_name as product_image_url  FROM product p INNER JOIN product_image img on p.id = img.product_id and img.type = \"th\" INNER JOIN file_info f on img.file_id = f.id INNER JOIN display_info d on p.id = d.product_id limit :start, :limit";
    public static final String SELECT_BY_CATEGORY_ID = "SELECT d.id as display_info_id, d.place_name as place_name, p.content as product_content, p.description as product_description, p.id as product_id, f.file_name as product_image_url  FROM product p INNER JOIN product_image img on p.id = img.product_id and img.type = \"th\" INNER JOIN file_info f on img.file_id = f.id INNER JOIN display_info d on p.id = d.product_id where p.category_id = :categoryId limit :start, :limit";
    public static final String SELECT_COUNT = "SELECT count(*) FROM product p INNER JOIN display_info d on p.id = d.product_id";
    public static final String SELECT_COUNT_BY_CATEGORY_ID = "SELECT count(*) FROM product p INNER JOIN display_info d on p.id = d.product_id where p.category_id = :categoryId";
}
