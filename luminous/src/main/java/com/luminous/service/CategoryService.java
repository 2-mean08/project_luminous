package com.luminous.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luminous.domain.Category;
import com.luminous.mapper.CategoryMapper;

@Service
public class CategoryService {
	private final CategoryMapper categoryMapper;

	public CategoryService(CategoryMapper categoryMapper) {
		super();
		this.categoryMapper = categoryMapper;
	}

	public List<Category> getRootCategories() {
		// parentCategory가 null인 카테고리만 조회
		return categoryMapper.selectByParentCategory(null);
	}

	public Long generateCategoryId(Long parentCategoryId) {
		if (parentCategoryId == null) { // 최상위 카테고리
			throw new IllegalArgumentException("루트 카테고리는 1~9만 허용");
		}

		Long maxSubId = categoryMapper.findMaxSubIdByParentCategory(parentCategoryId);
		long baseId = parentCategoryId * 100; // 100, 200, 300...

		if (maxSubId == null) { // 첫 서브 카테고리
			return baseId;
		} else {
			return maxSubId + 1;
		}
	}

	public void createCategory(Category category) {
		if (category.getParentCategoryId() == null) { // 루트 카테고리
			if (category.getParentCategoryId() > 99) {
				throw new IllegalArgumentException("루트 카테고리 ID는 1~99만 가능");
			}
		} else { // 서브 카테고리
			long generatedId = generateCategoryId(category.getParentCategoryId());
			category.setCategoryId(generatedId);
		}
		categoryMapper.insertCategory(category);
	}

	// 카테고리 유효성 검증 메서드
	public boolean isValidCategory(Long categoryId) {
	    if (categoryId == null) return false;
	    return categoryMapper.existsById(categoryId) > 0;
	}

    // 카테고리 타입 판별 로직 개선
    public boolean isCaseOrWatch(Long categoryId) {
        Category category = categoryMapper.findById(categoryId);
        if (category == null) return false;
        
        // 대분류가 케이스(3) 또는 워치(4)인지 확인
        return category.getParentCategoryId() == null 
            ? category.getCategoryId() == 3 || category.getCategoryId() == 4
            : category.getParentCategoryId() == 3 || category.getParentCategoryId() == 4;
    }
    // 케이스인지 판단
    public boolean isCase(Long categoryId) {
        Category category = categoryMapper.findById(categoryId);
        if (category == null) return false;
        Long parentId = category.getParentCategoryId();
        return parentId != null && parentId == 3; // 대분류 3(케이스)의 하위 카테고리
    }

    // 워치인지 판단
    public boolean isWatch(Long categoryId) {
        Category category = categoryMapper.findById(categoryId);
        if (category == null) return false;
        Long parentId = category.getParentCategoryId();
        return parentId != null && parentId == 4; // 대분류 4(워치)의 하위 카테고리
    }

    // 카테고리 타입에 따라 다른 목록 반환
    public List<String> getDeviceModels(Long categoryId) {
        if (isCase(categoryId)) {
            return getCasePhoneModels();
        } else if (isWatch(categoryId)) {
            return getWatchModels();
        }
        return Collections.emptyList();
    }

    // 케이스용 휴대폰 모델 목록
    private List<String> getCasePhoneModels() {
        return List.of("Galaxy S24", "iPhone 16", "Google Pixel 9");
    }

    // 워치용 호환 스마트워치 목록
    private List<String> getWatchModels() {
        return List.of("Galaxy Watch 7", "Apple Watch Ultra", "Xiaomi Watch 3");
    }
}
