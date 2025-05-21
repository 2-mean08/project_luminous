package com.luminous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luminous.domain.Item;
import com.luminous.domain.Options.AccessoryOption;
import com.luminous.domain.Options.BatteryOption;
import com.luminous.domain.Options.CaseOption;
import com.luminous.domain.Options.WatchOption;
import com.luminous.service.CategoryService;
import com.luminous.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final CategoryService categoryService;

    @Autowired
    public ItemController(ItemService itemService, CategoryService categoryService) {
        this.itemService = itemService;
        this.categoryService = categoryService;
    }

    // 1단계: 카테고리 선택 폼
    @GetMapping("/category-select")
    public String showCategorySelection(Model model) {
        model.addAttribute("categories", categoryService.getRootCategories());
        return "items/category-select";
    }

    // 2단계: 상품 등록 폼
    @GetMapping("/register")
    public String showRegistrationForm(@RequestParam("categoryId") Long categoryId, Model model) {
        
        // 카테고리 유효성 검증
        if (!categoryService.isValidCategory(categoryId)) {
            return "redirect:/items/category-select?error=invalid";
        }

        // 2. 옵션 객체 생성 및 타입 판별
        Object option = itemService.createOptionByCategory(categoryId);
        String optionType = option.getClass().getSimpleName(); // 리플렉션 대신 서비스에서 타입 반환

        model.addAttribute("item", new Item());
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("option", option);
        model.addAttribute("optionType", optionType); // 옵션 타입 직접 전달

     // 3. 장치 모델 목록 (케이스/워치 구분)
        if (categoryService.isCaseOrWatch(categoryId)) {
            model.addAttribute("deviceModels", categoryService.getDeviceModels(categoryId));
        }

        return "items/register";
    }

    // 상품 등록 처리
    @PostMapping("/register")
    public String registerProduct(
            @ModelAttribute Item item,
            @RequestParam Long categoryId,
            @ModelAttribute("option") Object option,
            @RequestParam String optionType // 옵션 타입 파라미터 추가
            ) {

        // 카테고리 ID 설정
        item.setCategoryId(categoryId);
        
        // 실제 구현시 switch 대신 전략 패턴 사용 권장
        switch (categoryId.intValue()) {
            case 1:
                itemService.registerItem(item, (AccessoryOption) option);
                break;
            case 2:
                itemService.registerItem(item, (BatteryOption) option);
                break;
            case 3:
                itemService.registerItem(item, (CaseOption) option);
                break;
            case 4:
                itemService.registerItem(item, (WatchOption) option);
                break;
            default:
                throw new IllegalArgumentException("Invalid category");
        }
        
        return "redirect:/items/confirm";
    }

   
}
