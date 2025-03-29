package com.metacoding.storev2.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Transactional
    public void 상품등록(StoreRequest.saveDTO saveDTO) {
        storeRepository.save(saveDTO.getName(), saveDTO.getStock(), saveDTO.getPrice());
    }

    public List<Store> 상품목록() {
        List<Store> storeList = storeRepository.findAll();
        return storeList;
    }

}

