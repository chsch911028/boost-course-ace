package kr.or.connect.pj3be.dto.promotion;

public class Promotion {

    private Integer id; // promotion id
    private Integer productId; // product id
    private String productImageUrl; // image url

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = "img/"+productImageUrl;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", productId=" + productId +
                ", productImageUrl='" + productImageUrl + '\'' +
                '}';
    }
}
