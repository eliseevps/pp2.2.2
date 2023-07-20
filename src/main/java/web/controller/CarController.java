package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping(value = "/cars", params = "count")
    public String printSomeCars(@RequestParam("count") int count, ModelMap model) {
        List<Car> cars = carService.getSomeCars(count);
        model.addAttribute("someCars", cars);
        return "someCars";
    }
}
