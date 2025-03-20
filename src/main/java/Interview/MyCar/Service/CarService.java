package Interview.MyCar.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Interview.MyCar.Exception.MyException;
import Interview.MyCar.Model.Car;
import Interview.MyCar.Repository.CarRepo;

@Service
public class CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarService.class);

    @Autowired
    private CarRepo carRepo;

    public List<Car> addCars(List<Car> carList) {
        List<Car> existingCars = carRepo.findAll();
        for (Car newCar : carList) {
            for (Car existingCar : existingCars) {
                if (newCar.getRegNo() == existingCar.getRegNo()) {
                    logger.warn("Car with regNo {} already exists!", newCar.getRegNo());
                    throw new MyException(newCar.getName() + " is already registered with RegNumber " + newCar.getRegNo());
                }
            }
        }
        return carRepo.saveAll(carList);
    }

    public String removeCar(Integer regNo) {
        int affectedRows = carRepo.updatingCar(regNo);
        if (affectedRows == 0) {
            logger.warn("Car with regNo {} not found!", regNo);
            throw new MyException("Car with regNo " + regNo + " not found!");
        }
        return "Car removed successfully";
    }
}
