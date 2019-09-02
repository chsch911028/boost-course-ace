package kr.or.connect.pj3be.dto.product;

import java.util.List;

public class ProductResponse {
    private List<Product> items; // 제품 목록
    private Integer totalCount; // 제품 갯수

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "items=" + items +
                ", totalCount=" + totalCount +
                '}';
    }
}
