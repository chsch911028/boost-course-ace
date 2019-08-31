package kr.or.connect.pj3be.dto.promotion;

import java.util.List;

public class PromotionResponse {
    private List<Promotion> items; //프로모션 목록

    public List<Promotion> getItems() {
        return items;
    }

    public void setItems(List<Promotion> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PromotionResponse{" +
                "items=" + items +
                '}';
    }
}
