package kr.or.connect.pj3be.sql;

public class DisplayInfoDaoSqls {
    public static final String SELECT_DISPLAY_INFO_BY_DISPLAY_INFO_ID = "SELECT c.id as category_id, " +
            "c.name as category_name, " +
            "d.id as display_info_id, " +
            "d.create_date, " +
            "d.modify_date, " +
            "d.opening_hours, " +
            "d.tel as telephone, " +
            "d.email as email, " +
            "d.homepage as homepage, " +
            "d.place_lot, " +
            "d.place_name, " +
            "d.place_street, " +
            "p.content as product_content, " +
            "p.description as product_description, " +
            "p.event as product_event, " +
            "p.id as product_id " +
            "FROM (SELECT * FROM display_info WHERE id=:displayInfoId) d " +
            "INNER JOIN product p ON d.product_id = p.id " +
            "INNER JOIN category c ON p.category_id = c.id";

    public static final String SELECT_DISPLAY_INFO_IMAGE_BY_DISPLAY_INFO_IMAGE_ID = "SELECT f.id as file_id, " +
            "f.content_type, " +
            "f.create_date, " +
            "f.modify_date, " +
            "f.delete_flag, " +
            "f.file_name, " +
            "f.save_file_name, " +
            "f.id as file_id, " +
            "img.display_info_id, " +
            "img.id as display_info_image_id " +
            "FROM (SELECT * FROM display_info_image WHERE id = :displayInfoImageId) img " +
            "INNER JOIN file_info f " +
            "ON img.file_id = f.id";
}
