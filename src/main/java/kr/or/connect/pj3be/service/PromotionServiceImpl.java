package kr.or.connect.pj3be.service;

import kr.or.connect.pj3be.dao.PromotionDao;
import kr.or.connect.pj3be.dto.promotion.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    PromotionDao repository;

    @Transactional
    @Override
    public List<Promotion> getList() {
        return repository.selectAll();
    }
}
