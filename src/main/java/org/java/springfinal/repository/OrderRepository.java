package org.java.springfinal.repository;

import org.java.springfinal.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order,Long> {
    List<Order> findByUserId(Long userId);
    Order findByCarId(Long carId);
    Order getOrderById(Long id);

    Order getOrderByUserId(Long id);
}
