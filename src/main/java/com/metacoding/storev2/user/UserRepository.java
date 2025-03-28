package com.metacoding.storev2.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public void save(String username, String password, String fullname) {
        Query query = em.createNativeQuery("insert into user_tb(username, password, fullname, created_at) values (?, ?, ?, now())");
        query.setParameter(1, username);
        query.setParameter(2, password);
        query.setParameter(3, fullname);
        query.executeUpdate();


    }


}
