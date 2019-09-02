package kr.or.connect.pj3be.sql;

public class ProductDaoSqls {
    public static final String SELECT_PRODUCTS_ABOUT_ALL_CATEGORIES = "SELECT d.id as display_info_id, " +
            "d.place_name, " +
            "p.content as product_content, " +
            "p.description as product_description, " +
            "p.id as product_id, " +
            "f.file_name as product_image_url " +
            "FROM product p " +
            "INNER JOIN product_image img " +
            "ON p.id = img.product_id and img.type = \"th\" " +
            "INNER JOIN file_info f " +
            "ON img.file_id = f.id " +
            "INNER JOIN display_info d " +
            "ON p.id = d.product_id limit :start, :limit";

    public static final String SELECT_PRODUCTS_BY_CATEGORY_ID = "SELECT d.id as display_info_id, " +
            "d.place_name, " +
            "p.content as product_content, " +
            "p.description as product_description, " +
            "p.id as product_id, " +
            "f.file_name as product_image_url " +
            "FROM product p " +
            "INNER JOIN product_image img " +
            "ON p.id = img.product_id and img.type = \"th\" " +
            "INNER JOIN file_info f " +
            "ON img.file_id = f.id " +
            "INNER JOIN display_info d " +
            "ON p.id = d.product_id " +
            "WHERE p.category_id = :categoryId limit :start, :limit";

    public static final String SELECT_ALL_PRODUCT_COUNT = "SELECT count(*) " +
            "FROM product p " +
            "INNER JOIN display_info d " +
            "ON p.id = d.product_id";

    public static final String SELECT_PRODUCT_COUNT_BY_CATEGORY_ID = "SELECT count(*) " +
            "FROM product p " +
            "INNER JOIN display_info d " +
            "ON p.id = d.product_id " +
            "WHERE p.category_id = :categoryId";

    /* ##### PRODUCT IMAGES ##### */
    public static final String SELECT_ALL_PRODUCT_IMAGES_BY_PRODUCT_ID = "select f.content_type as content_type, " +
            "f.create_date, " +
            "f.delete_flag, " +
            "f.id as file_info_id, " +
            "f.file_name, " +
            "f.modify_date, " +
            "img.product_id, " +
            "img.id as product_image_id, " +
            "f.save_file_name, " +
            "img.type " +
            "FROM product_image img " +
            "INNER JOIN file_info f " +
            "ON img.product_id = :productId AND img.file_id = f.id";

    /* ##### PRODUCT PRICES ##### */
    public static final String SELECT_ALL_PRODUCT_PRICES_BY_PRODUCT_ID = "SELECT id as product_price_id, " +
            "product_id, " +
            "price_type_name, " +
            "price, " +
            "discount_rate, " +
            "create_date, " +
            "modify_date " +
            "FROM product_price " +
            "WHERE product_id = :productId";


}
