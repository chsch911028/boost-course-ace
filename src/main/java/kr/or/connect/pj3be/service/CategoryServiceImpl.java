package kr.or.connect.pj3be.service;

import kr.or.connect.pj3be.dao.CategoryDao;
import kr.or.connect.pj3be.dto.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao repository;

    @Transactional
    @Override
    public List<Category> getList() {
        return repository.selectAll();
    }
}
