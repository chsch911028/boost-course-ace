package kr.or.connect.pj3be.sql;

public class CategoryDaoSqls {
    public static final String SELECT_ALL = "select c.id, c.name, COUNT(d.id) as count FROM category c INNER JOIN product p on c.id = p.category_id INNER JOIN display_info d on p.id = d.product_id GROUP BY c.id;";

}
