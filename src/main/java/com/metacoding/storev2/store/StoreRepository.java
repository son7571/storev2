package com.metacoding.storev2.store;


import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;


@Repository
public class StoreRepository {

    private EntityManager em;

    public StoreRepository(EntityManager em) {
        this.em = em;
    }


}
