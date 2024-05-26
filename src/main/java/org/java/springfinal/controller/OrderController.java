package org.java.springfinal.controller;


import lombok.RequiredArgsConstructor;
import org.java.springfinal.model.Car;
import org.java.springfinal.model.User;
import org.java.springfinal.service.OrderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/orders")
    public List<Car> getCarList(@AuthenticationPrincipal User user) {
        return orderService.getMyOrder(user.getId());
    }

}
