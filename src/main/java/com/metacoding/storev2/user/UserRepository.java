package com.metacoding.storev2.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {

    private EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public void save(String username, String password, String fullname) {
        Query query = em.createNativeQuery("insert into user_tb(username, password, fullname, created_at) values (?, ?, ?, now())");
        query.setParameter(1, username);
        query.setParameter(2, password);
        query.setParameter(3, fullname);
        query.executeUpdate();


    }

    public User findByUsername(String username) {
        Query query = em.createNativeQuery("select * from user_tb where username = ?", User.class);
        query.setParameter(1, username);
        return (User) query.getSingleResult();
    }

}

