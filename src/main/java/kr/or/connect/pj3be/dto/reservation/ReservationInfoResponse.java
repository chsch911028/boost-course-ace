package kr.or.connect.pj3be.dto.reservation;

import java.util.List;

public class ReservationInfoResponse {
    private List<ReservationInfo> reservations; // 에약 정보 목록
    private Integer size; // 예약 수

    public List<ReservationInfo> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationInfo> reservations) {
        this.reservations = reservations;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ReservationInfoResponse{" +
                "reservations=" + reservations +
                ", size=" + size +
                '}';
    }
}
