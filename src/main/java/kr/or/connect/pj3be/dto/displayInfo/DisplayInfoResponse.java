package kr.or.connect.pj3be.dto.displayInfo;

import kr.or.connect.pj3be.dto.comment.Comment;

import java.util.List;

public class DisplayInfoResponse {
    private Double averageScore; // 평점 평균
    private List<Comment> comments; // 한줄평 목록
    private DisplayInfo displayInfo; // 전시 정보
    private DisplayInfoImage displayInfoImage; //전시 정보 이미지
    private List<ProductImage> productImages; // 제품 이미지 목록
    private List<ProductPrice> productPrices; // 제품 가격 목록

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    public void setDisplayInfo(DisplayInfo displayInfo) {
        this.displayInfo = displayInfo;
    }

    public DisplayInfoImage getDisplayInfoImage() {
        return displayInfoImage;
    }

    public void setDisplayInfoImage(DisplayInfoImage displayInfoImage) {
        this.displayInfoImage = displayInfoImage;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    @Override
    public String toString() {
        return "DisplayInfoResponse{" +
                "averageScore=" + averageScore +
                ", comments=" + comments +
                ", displayInfo=" + displayInfo +
                ", displayInfoImage=" + displayInfoImage +
                ", productImages=" + productImages +
                ", productPrices=" + productPrices +
                '}';
    }
}
