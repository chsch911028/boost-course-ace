package kr.or.connect.pj3be.dto.comment;

import java.util.List;

public class CommentResponse {

    private String comment; // 평
    private Integer commentId; // 한줄평 Id
    private List<CommentImage> commentImage; // 한줄평 이미지 목록
    private String createDate; // ($date-time)등록일
    private String modifyDate; // ($date-time)수정일
    private Integer  productId; // 상품 Id
    private Integer reservationInfoId; // 예약정보 Id
    private Integer score; // 별점

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public List<CommentImage> getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(List<CommentImage> commentImage) {
        this.commentImage = commentImage;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(Integer reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CommentResponse{" +
                "comment='" + comment + '\'' +
                ", commentId=" + commentId +
                ", commentImage=" + commentImage +
                ", createDate='" + createDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", productId=" + productId +
                ", reservationInfoId=" + reservationInfoId +
                ", score=" + score +
                '}';
    }
}
