package com.metacoding.storev2.order;

import lombok.AllArgsConstructor;
import lombok.Data;

public class OrderRequest {

    @AllArgsConstructor
    @Data
    public static class ListDTO {
        private Integer storeId;
        private String name;
        private Integer qty;
        private Integer totalPrice;
    }
}
