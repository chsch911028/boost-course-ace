package kr.or.connect.pj3be.dto.product;

public class ProductPrice {
    private String createDate; // ($date-time) 생성일
    private Double discountRate; // 할인율
    private String modifyDate; // ($date-time) 수정일
    private Integer price; // 가격
    private String priceTypeName; // 가격 타입명
    private Integer productId; // 상품 Id
    private Integer productPriceId; // 상품 가격 Id

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPriceTypeName() {
        return priceTypeName;
    }

    public void setPriceTypeName(String priceTypeName) {
        this.priceTypeName = priceTypeName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(Integer productPriceId) {
        this.productPriceId = productPriceId;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "createDate='" + createDate + '\'' +
                ", discountRate=" + discountRate +
                ", modifyDate='" + modifyDate + '\'' +
                ", price=" + price +
                ", priceTypeName='" + priceTypeName + '\'' +
                ", productId=" + productId +
                ", productPriceId=" + productPriceId +
                '}';
    }
}

