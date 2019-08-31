package kr.or.connect.pj3be.dto.category;

public class Category {

    private Integer id; // Category id
    private String name; // Category name
    private Integer count; // Category에 속한 전시상품 수

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Category{" +
                "count=" + count +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
