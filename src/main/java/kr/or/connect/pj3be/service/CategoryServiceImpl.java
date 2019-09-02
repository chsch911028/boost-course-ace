package kr.or.connect.pj3be.service;

import kr.or.connect.pj3be.dao.CategoryDao;
import kr.or.connect.pj3be.dto.category.Category;
import kr.or.connect.pj3be.dto.category.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Transactional(readOnly = true)
    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
