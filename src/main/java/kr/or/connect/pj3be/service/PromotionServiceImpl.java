package kr.or.connect.pj3be.service;

import kr.or.connect.pj3be.dao.PromotionDao;
import kr.or.connect.pj3be.dto.promotion.PromotionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    PromotionDao promotionDao;

    @Transactional(readOnly = true)
    @Override
    public PromotionResponse getAllPromotions() {
        PromotionResponse promotionResponse = new PromotionResponse();
        promotionResponse.setItems(promotionDao.getAllPromotions());
        return promotionResponse;
    }
}
