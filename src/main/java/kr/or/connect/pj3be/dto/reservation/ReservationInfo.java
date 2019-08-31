package kr.or.connect.pj3be.dto.reservation;

import kr.or.connect.pj3be.dto.displayInfo.DisplayInfo;

public class ReservationInfo {
    private Boolean cancelYn; //예약 취소 여부
    private String createDate; // ($date-time) 예약 생성일시
    private DisplayInfo displayInfo; // 전시 정보
    private Integer displayInfoId; // 전시상품 Id
    private String modifyDate; // ($date-time) 예약 수정일시
    private Integer productId; // 상품 Id
    private String reservationDate; // ($date) 예약일
    private String reservationEmail; // 예약자 이메일
    private Integer reservationInfoId; // 예약 Id
    private String reservationName; // 예약자명
    private String reservationTelephone; // 예약자 전화번호
    private Integer totalPrice; // 예약한 상품 총 가격

    public Boolean getCancelYn() {
        return cancelYn;
    }

    public void setCancelYn(Boolean cancelYn) {
        this.cancelYn = cancelYn;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    public void setDisplayInfo(DisplayInfo displayInfo) {
        this.displayInfo = displayInfo;
    }

    public Integer getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(Integer displayInfoId) {
        this.displayInfoId = displayInfoId;
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

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ReservationInfo{" +
                "cancelYn=" + cancelYn +
                ", createDate='" + createDate + '\'' +
                ", displayInfo=" + displayInfo +
                ", displayInfoId=" + displayInfoId +
                ", modifyDate='" + modifyDate + '\'' +
                ", productId=" + productId +
                ", reservationDate='" + reservationDate + '\'' +
                ", reservationEmail='" + reservationEmail + '\'' +
                ", reservationInfoId=" + reservationInfoId +
                ", reservationName='" + reservationName + '\'' +
                ", reservationTelephone='" + reservationTelephone + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
