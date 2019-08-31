package kr.or.connect.pj3be.dto.product;

import java.util.List;

public class ProductResponse {
    private List<Product> productitems; // 제품 목록
    private Integer totalCount; // 제품 갯수

    public List<Product> getProductitems() {
        return productitems;
    }

    public void setProductitems(List<Product> productitems) {
        this.productitems = productitems;
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
                "productitems=" + productitems +
                ", totalCount=" + totalCount +
                '}';
    }
}
