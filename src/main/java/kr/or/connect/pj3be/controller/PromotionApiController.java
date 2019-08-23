package kr.or.connect.pj3be.controller;

import kr.or.connect.pj3be.dto.Promotion;
import kr.or.connect.pj3be.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/promotions")
public class PromotionApiController {

    @Autowired
    PromotionService promotionService;

    @GetMapping
    public Map<String, Object> list(){

        List<Promotion> list = promotionService.getList();
        Map<String, Object> map = new HashMap<>();
        map.put("items", list);
        return map;
    }
}
