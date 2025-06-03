package com.luminous.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.luminous.domain.Category;
import com.luminous.domain.Image;
import com.luminous.domain.ImageType;
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

import jakarta.annotation.PostConstruct;


@Service
public class ItemService {
	@Value("${file.upload-dir}")
    private String uploadDir;
    private Path uploadPath;
        
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
	@PostConstruct
    public void init() throws IOException {
        this.uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(uploadPath);
    }
	
	public void saveImage(MultipartFile file, ImageType imageType, Long itemId) throws IOException {
        if (file.isEmpty()) return;

        // 파일 저장 (uploadPath 사용)
        String fileName = generateUniqueFileName(file.getOriginalFilename());
        Path targetPath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        // DB 저장 로직
        Image image = new Image();
        image.setImageUrl("/uploads/" + fileName); // 웹 접근 경로
        image.setImageName(fileName);
        image.setFileType(file.getContentType());
        image.setFileSize(file.getSize());
        image.setImageType(imageType);
        image.setItemId(itemId);
        itemMapper.insertImage(image);
    }

    private String generateUniqueFileName(String originalName) {
        return System.currentTimeMillis() + "_" + originalName;
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
	// ItemService에 추가
	@Transactional
	public void registerItemWithImages(Item item, Object option, 
	                                 MultipartFile mainImage, 
	                                 List<MultipartFile> detailImages) throws IOException {
	    // 1. 상품 저장
	    itemMapper.insertItem(item);
	    Long itemId = item.getItemId(); // auto-increment 가정

	    // 2. 옵션 저장
	    saveOptionByCategory(item.getCategoryId(), option);

	    // 3. 메인 이미지 저장
	    if (mainImage != null && !mainImage.isEmpty()) {
	        saveImage(mainImage, ImageType.MAIN, itemId);
	    }

	    // 4. 상세 이미지 저장
	    if (detailImages != null) {
	        for (MultipartFile detailImage : detailImages) {
	            if (!detailImage.isEmpty()) {
	                saveImage(detailImage, ImageType.DETAIL, itemId);
	            }
	        }
	    }
	}

	private void saveOptionByCategory(Long categoryId, Object option) {
	    Category category = categoryMapper.findById(categoryId);
	    Long parentCategoryId = category.getParentCategoryId();

	    switch (parentCategoryId.intValue()) {
	        case 1 -> accessoryMapper.insertAccessoryOption((AccessoryOption) option);
	        case 2 -> batteryMapper.insertBatteryOption((BatteryOption) option);
	        case 3 -> caseMapper.insertCaseOption((CaseOption) option);
	        case 4 -> watchMapper.insertWatchOption((WatchOption) option);
	        default -> throw new IllegalArgumentException("Invalid parentCategoryId: " + parentCategoryId);
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
