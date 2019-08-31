package kr.or.connect.pj3be.dto.comment;

public class Comment {
    private String comment; // 상품평
    private Integer commentId; // 상품평 Id
    private List<CommentImage> commentImages; // 상품평 이미지 목록
    private String createDate; // 생성일
    private String modifyDate; // 수정일
    private Integer productId; // 상품 Id
    private String reservationDate; // 예약일
    private String reservationEmail; // 예약자 이메일
    private Integer reservationInfoId; // 예약 Id
    private String reservationName; // 예약자 명
    private String reservationTelephone; // 예약자 전화번호
    private Double score; // 평점

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

    public List<CommentImage> getCommentImages() {
        return commentImages;
    }

    public void setCommentImages(List<CommentImage> commentImages) {
        this.commentImages = commentImages;
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

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public Integer getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(Integer reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationTelephone() {
        return reservationTelephone;
    }

    public void setReservationTelephone(String reservationTelephone) {
        this.reservationTelephone = reservationTelephone;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment='" + comment + '\'' +
                ", commentId=" + commentId +
                ", commentImages=" + commentImages +
                ", createDate='" + createDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", productId=" + productId +
                ", reservationDate='" + reservationDate + '\'' +
                ", reservationEmail='" + reservationEmail + '\'' +
                ", reservationInfoId=" + reservationInfoId +
                ", reservationName='" + reservationName + '\'' +
                ", reservationTelephone='" + reservationTelephone + '\'' +
                ", score=" + score +
                '}';
    }
}
