package org.java.springfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private int amount;
    private int price;
}
