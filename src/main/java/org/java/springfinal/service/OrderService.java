package org.java.springfinal.service;

import lombok.RequiredArgsConstructor;
import org.java.springfinal.model.Car;
import org.java.springfinal.model.Order;
import org.java.springfinal.repository.CarRepository;
import org.java.springfinal.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CarRepository carRepository;

    public List<Car> getMyOrder(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        List<Car> cars = new ArrayList<>();
        for (Order order : orders) {
            Optional<Car> car = carRepository.findById(order.getCar().getId());
            car.ifPresent(cars::add);
        }
        return cars;
    }
}
