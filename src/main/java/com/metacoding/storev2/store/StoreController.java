package com.metacoding.storev2.store;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/")
    public String list(HttpServletRequest request) {
        List<Store> storeList = storeService.상품목록();
        request.setAttribute("models", storeList);
        return "store/list";
    }

    @GetMapping("store/save-form")
    public String saveForm() {
        return "store/save-form";
    }

    @PostMapping("/save")
    public String save(StoreRequest.saveDTO saveDTO) {
        storeService.상품등록(saveDTO);
        return "redirect:/";
    }

    @GetMapping("store/{id}")
    public String detail(@PathVariable("id") int id, HttpServletRequest request) {
        Store store = storeService.상세보기(id);
        request.setAttribute("model", store);
        return "store/detail";
    }

    @PostMapping("store/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        storeService.상품삭제(id);
        return "redirect:/";
    }
}


