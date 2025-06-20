package Interceptors.controllers;

import Interceptors.entity.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController
{
    @GetMapping
    public List<Car> getAllCars()
    {
        List<Car> cars = List.of(new Car("Ciaz" ,"2018"),
                                new Car("i10" , "2008"));

        return cars;
    }
}
