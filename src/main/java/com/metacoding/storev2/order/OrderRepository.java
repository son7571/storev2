package com.metacoding.storev2.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private EntityManager em;

    public OrderRepository(EntityManager em) {
        this.em = em;
    }

    public List<OrderRequest.ListDTO> findAll() {
        Query query = em.createNativeQuery("select store_id, name, qty, total_price " +
                "from  store_tb s inner join order_tb o on s.id = o.store_id");
        List<Object[]> obsList = query.getResultList();
        List<OrderRequest.ListDTO> orderList = new ArrayList<>();

        for (Object[] obs : obsList) {
            OrderRequest.ListDTO list =
                    new OrderRequest.ListDTO(
                            (int) obs[0],
                            (String) obs[1],
                            (int) obs[2],
                            (int) obs[3]
                    );
            orderList.add(list);
        }
        return orderList;
    }
}
