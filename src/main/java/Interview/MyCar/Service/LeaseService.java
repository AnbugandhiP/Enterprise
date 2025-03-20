package Interview.MyCar.Service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Interview.MyCar.Exception.MyException;
import Interview.MyCar.Model.Car;
import Interview.MyCar.Model.EndUser;
import Interview.MyCar.Model.Lease;
import Interview.MyCar.Repository.CarRepo;
import Interview.MyCar.Repository.EndUserRepo;
import Interview.MyCar.Repository.LeaseRepo;

@Service
public class LeaseService {

    private static final Logger logger = LoggerFactory.getLogger(LeaseService.class);

    @Autowired
    private CarRepo carRepo;
    @Autowired
    private EndUserRepo endUserRepo;
    @Autowired
    private LeaseRepo leaseRepo;

    public String takeLease(String userName, String carName) {
        logger.info("Processing lease request for user: {} and car: {}", userName, carName);

        List<Car> getCarList = carRepo.findAvailablecars(carName);
        if (getCarList.isEmpty()) {
            logger.warn("Lease attempt failed: {} is not available", carName);
            throw new MyException(carName + " is not available to lease");
        }

        List<EndUser> listUser = endUserRepo.findByUserName(userName);
        if (listUser.size() >= 2) {
            logger.warn("Lease attempt failed: {} already has two leased cars", userName);
            throw new MyException(userName + " already taken lease of two cars");
        }

        Car car = getCarList.get(0);
        Lease lease = new Lease();
        lease.setCarId(car.getId());
        lease.setCarName(car.getName());
        lease.setStatus("in use");
        lease.setOwnerName(car.getOwnerName());
        lease.setUserName(userName);
        lease.setStartDate(LocalDate.now());
        lease.setRegNo(car.getRegNo());

        leaseRepo.save(lease);
        logger.info("Lease record created for user: {} with car: {}", userName, carName);

        carRepo.updateLeasedCar(carName, car.getRegNo());
        carRepo.updateUser(carName, userName);

        logger.info("Lease successfully taken: {} for user {}", carName, userName);
        return "Lease taken successfully!";
    }

    public String removeLease(String userName, String carName, int reg_no) {
        logger.info("Processing lease removal for user: {} and car: {} with reg_no {}", userName, carName, reg_no);

        List<Car> getLeasedCarList = carRepo.findLeasedCars(carName, reg_no);
        if (getLeasedCarList.isEmpty()) {
            logger.warn("Remove lease failed: {} with reg_no {} is not leased", carName, reg_no);
            throw new MyException(carName + " with " + reg_no + " is not leased yet");
        }

        Car car = getLeasedCarList.get(0);
        List<Lease> leaseList = leaseRepo.findByCar(car.getId());

        if (!leaseList.isEmpty()) {
            Lease lease = leaseList.get(0);
            lease.setStatus("available");
            lease.setEndDate(LocalDate.now());
            leaseRepo.save(lease);
            logger.info("Lease status updated to available for car: {}", carName);
        }

        carRepo.updateCar1(carName, reg_no);
        carRepo.updateUser1(userName);

        logger.info("Lease successfully removed: {} for user {}", carName, userName);
        return "Lease stopped";
    }
}
