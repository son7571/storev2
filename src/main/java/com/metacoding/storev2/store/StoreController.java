package com.metacoding.storev2.store;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/")
    public String list() {
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
}


