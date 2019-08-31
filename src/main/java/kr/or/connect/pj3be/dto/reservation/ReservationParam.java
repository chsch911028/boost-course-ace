package kr.or.connect.pj3be.dto.reservation;

import java.util.List;

public class ReservationParam {
    private Integer displayInfoId; // 전시상품 Id
    private List<ReservationPrice> prices; // 가격 목록
    private Integer productId; // 상품 Id
    private String reservationEmail; // 예약자 이메일
    private String reservationName; // 예약자명
    private String reservationTelephone; // 예약자 전화번호
    private String reservationYearMonthDay; // 예약일

    public Integer getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(Integer displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public List<ReservationPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ReservationPrice> prices) {
        this.prices = prices;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
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

    public String getReservationYearMonthDay() {
        return reservationYearMonthDay;
    }

    public void setReservationYearMonthDay(String reservationYearMonthDay) {
        this.reservationYearMonthDay = reservationYearMonthDay;
    }

    @Override
    public String toString() {
        return "ReservationParam{" +
                "displayInfoId=" + displayInfoId +
                ", prices=" + prices +
                ", productId=" + productId +
                ", reservationEmail='" + reservationEmail + '\'' +
                ", reservationName='" + reservationName + '\'' +
                ", reservationTelephone='" + reservationTelephone + '\'' +
                ", reservationYearMonthDay='" + reservationYearMonthDay + '\'' +
                '}';
    }
}
