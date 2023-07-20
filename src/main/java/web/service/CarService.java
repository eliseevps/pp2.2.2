package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Stream;

@Service
public class CarService {
    public List<Car> getAllCars() {
        return Stream.of(new Car("BMW", "X7", 2020),
                        new Car("Toyota", "Camry", 2023),
                        new Car("Opel", "Astra H", 2007),
                        new Car("UAZ", "Buhanka", 2015),
                        new Car("Honda", "Civic", 2017))
                .toList();
    }

    public List<Car> getSomeCars(int count) {
        if (count < 1) {
            return Stream.empty().map(o -> (Car) o).toList();
        } else if (count > 5) {
            return getAllCars().stream().toList();
        } else {
            return getAllCars().stream().limit(count).toList();
        }
    }
}
