package Interview.MyCar.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Interview.MyCar.Model.Car;
import Interview.MyCar.Service.CarService;

@RestController
@RequestMapping("/Car")
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @PostMapping("/addCar")
    public List<Car> addCar(@RequestBody List<Car> carList) {
        logger.info("Request received to add cars: {}", carList);
        List<Car> savedCars = carService.addCars(carList);
        logger.info("Successfully added cars.");
        return savedCars;
    }

    @DeleteMapping("/removeCar/{regNo}")
    public String removeCar(@PathVariable Integer regNo) {
        logger.info("Request received to remove car with regNo: {}", regNo);
        String response = carService.removeCar(regNo);
        logger.info("Car removed successfully.");
        return response;
    }
}
