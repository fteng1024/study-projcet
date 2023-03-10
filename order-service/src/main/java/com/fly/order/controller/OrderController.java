package com.fly.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/2/23
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/search")
    public String searchData() {
        System.out.println("今天星期几？");
        return "周四";
    }
}
