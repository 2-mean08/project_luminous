package com.luminous.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luminous.domain.Category;
import com.luminous.domain.Item;
import com.luminous.domain.Options.AccessoryOption;
import com.luminous.domain.Options.BatteryOption;
import com.luminous.domain.Options.CaseOption;
import com.luminous.domain.Options.WatchOption;
import com.luminous.mapper.AccessoryOptionMapper;
import com.luminous.mapper.BatteryOptionMapper;
import com.luminous.mapper.CaseOptionMapper;
import com.luminous.mapper.CategoryMapper;
import com.luminous.mapper.ItemMapper;
import com.luminous.mapper.WatchOptionMapper;

@Service
public class ItemService {
	private final ItemMapper itemMapper;
	private final CategoryMapper categoryMapper; // 추가
	private final AccessoryOptionMapper accessoryMapper;
	private final BatteryOptionMapper batteryMapper;
	private final CaseOptionMapper caseMapper;
	private final WatchOptionMapper watchMapper;

	@Autowired
	public ItemService(ItemMapper itemMapper, CategoryMapper categoryMapper, // 추가
			AccessoryOptionMapper accessoryMapper, BatteryOptionMapper batteryMapper, CaseOptionMapper caseMapper,
			WatchOptionMapper watchMapper) {
		this.itemMapper = itemMapper;
		this.categoryMapper = categoryMapper; // 추가
		this.accessoryMapper = accessoryMapper;
		this.batteryMapper = batteryMapper;
		this.caseMapper = caseMapper;
		this.watchMapper = watchMapper;
	}

	public void registerItem(Item item, Object option) {
		// 1. 상품 기본 정보 저장
		itemMapper.insertItem(item);

		// 2. 카테고리 정보 조회 (정규화 준수)
		Category category = categoryMapper.findById(item.getCategoryId());
		if (category == null) {
			throw new IllegalArgumentException("Invalid categoryId: " + item.getCategoryId());
		}
		Long parentCategoryId = category.getParentCategoryId();

		// 3. 상위 카테고리 기준으로 옵션 저장
		switch (parentCategoryId.intValue()) {
		case 1:
			accessoryMapper.insertAccessoryOption((AccessoryOption) option);
			break;
		case 2:
			batteryMapper.insertBatteryOption((BatteryOption) option);
			break;
		case 3:
			caseMapper.insertCaseOption((CaseOption) option);
			break;
		case 4:
			watchMapper.insertWatchOption((WatchOption) option);
			break;
		default:
			throw new IllegalArgumentException("Invalid parentCategoryId: " + parentCategoryId);
		}
	}

	// --- 헬퍼 메서드들 ---
	public Object createOptionByCategory(Long parentCategoryId) {
		return switch (parentCategoryId.intValue()) {
		case 1 -> new AccessoryOption();
		case 2 -> new BatteryOption();
		case 3 -> new CaseOption();
		case 4 -> new WatchOption();
		default -> throw new IllegalArgumentException("Invalid parentCategoryId: " + parentCategoryId);
		};
	}
}
