package com.luminous.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.luminous.domain.Item;
import com.luminous.domain.Options.AccessoryOption;
import com.luminous.domain.Options.BatteryOption;
import com.luminous.domain.Options.CaseOption;
import com.luminous.domain.Options.WatchOption;
import com.luminous.service.CategoryService;
import com.luminous.service.ItemService;
//알기 쉬운 주석
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
            model.addAttribute("error", "유효하지 않은 카테고리입니다.");
            model.addAttribute("categories", categoryService.getRootCategories());
            return "items/category-select";
        }

        // 2. 옵션 객체 생성 및 타입 판별
        Object option = itemService.createOptionByCategory(categoryId);
        String optionType = option.getClass().getSimpleName();

        model.addAttribute("item", new Item());
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("option", option);
        model.addAttribute("optionType", optionType);

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
            @RequestParam String optionType,
            @RequestParam("mainImage") MultipartFile mainImage,
            @RequestParam(value = "detailImages", required = false) List<MultipartFile> detailImages,
            Model model) throws IOException {

        item.setCategoryId(categoryId);

        try {
            // 이미지 업로드 및 상품, 옵션 저장 (서비스에서 한 번에 처리)
            itemService.registerItemWithImages(item, option, mainImage, detailImages);
        } catch (IOException e) {
            model.addAttribute("error", "이미지 업로드 실패");
            // 등록 폼으로 다시 이동 (optionType 등 기존 값 유지)
            model.addAttribute("item", item);
            model.addAttribute("categoryId", categoryId);
            model.addAttribute("option", option);
            model.addAttribute("optionType", optionType);
            if (categoryService.isCaseOrWatch(categoryId)) {
                model.addAttribute("deviceModels", categoryService.getDeviceModels(categoryId));
            }
            return "items/register";
        }

        return "redirect:/items/confirm";
    }
    @GetMapping("/confirm")
    public String showConfirmPage() {
        return "items/confirm";
    }

}
