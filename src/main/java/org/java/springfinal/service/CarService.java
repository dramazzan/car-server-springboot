package org.java.springfinal.service;

import lombok.RequiredArgsConstructor;
import org.java.springfinal.model.Car;
import org.java.springfinal.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getCarList() {
        return carRepository.findAll();
    }

    public Car getCar(Long id){
        return carRepository.getCarById(id);
    }


    public String addCar(Car car) {
        carRepository.save(car);
        return car.getBrand() + " added successfully";
    }

    public String deleteCar(Long id) {
        Car car = carRepository.getCarById(id);
        carRepository.deleteById(id);
        return car.getBrand() + " deleted successfully";
    }

    public String updateCar(Long id , Car updatedCar){
        Car car = carRepository.getCarById(id);
        String carBrand = car.getBrand();
        car.setBrand(updatedCar.getBrand());
        car.setModel(updatedCar.getModel());
        car.setYear(updatedCar.getYear());
        car.setPrice(updatedCar.getPrice());
        carRepository.save(car);
        return carBrand + " updated successfully";
    }


    public String buyCar(Long id) {
        Car car = carRepository.getCarById(id);
        if(car.getAmount() <= 0){
            return car.getBrand() + " is out of stock";
        }
        car.setAmount(car.getAmount() - 1);
        carRepository.save(car);
        return car.getBrand() + " bought successfully";
    }
}
