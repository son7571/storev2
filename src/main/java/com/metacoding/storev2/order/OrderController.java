package com.metacoding.storev2.order;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("order/list")
    public String list(HttpServletRequest request) {
        List<OrderRequest.ListDTO> orderList = orderService.구매목록();
        request.setAttribute("models", orderList);
        return "order/list";
    }

}
