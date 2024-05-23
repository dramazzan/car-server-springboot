package org.java.springfinal.repository;

import org.java.springfinal.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car , Long> {
    Car getCarById(Long id);
}
