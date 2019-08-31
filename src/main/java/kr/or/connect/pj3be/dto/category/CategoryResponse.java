package kr.or.connect.pj3be.dto.category;

import java.util.List;

public class CategoryResponse {
    private List<Category> items;

    public List<Category> getItems() {
        return items;
    }

    public void setItems(List<Category> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "items=" + items +
                '}';
    }
}
