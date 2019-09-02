package kr.or.connect.pj3be.service;

import kr.or.connect.pj3be.dto.category.Category;
import kr.or.connect.pj3be.dto.category.CategoryResponse;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();
}
