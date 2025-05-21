package com.luminous.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.luminous.domain.Category;

@Mapper
public interface CategoryMapper {
	// 부모 카테고리의 최대 서브 ID 조회
    Long findMaxSubIdByParentCategory(Long parentCategoryId);
    // 카테고리 저장
    void insertCategory(Category category);
    // parentCategory가 null인 루트 카테고리만 조회
    List<Category> selectRootCategories();
    // 특정 parentCategory 하위 카테고리 조회 (트리 탐색용)
    List<Category> selectByParentCategory(@Param("parentCategoryId") Long parentCategoryId);
    // 카테고리 존재 여부 조회
    int existsById(Long categoryId);
    
    Category findById(Long categoryId);
    
}

