package org.java.springfinal.service;

import lombok.RequiredArgsConstructor;
import org.java.springfinal.model.Car;
import org.java.springfinal.model.User;
import org.java.springfinal.repository.CarRepository;
import org.java.springfinal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;

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


    public void buy_Car(Long userId , Long carId){
        Optional<Car> carOptional = carRepository.findById(carId);
        Optional<User> userOptional = userRepository.findById(userId);

        if(carOptional.isPresent() && userOptional.isPresent()){
            User user = userOptional.get();
            Car car = carOptional.get();

            car.setUser(user);
            car.setAmount(car.getAmount() - 1);
            carRepository.save(car);

        }else{
            throw new RuntimeException("Car or User not found");
        }
    }

}
