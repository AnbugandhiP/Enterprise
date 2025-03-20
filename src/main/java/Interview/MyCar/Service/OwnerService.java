package Interview.MyCar.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Interview.MyCar.Exception.MyException;
import Interview.MyCar.Model.CarOwner;
import Interview.MyCar.Repository.OwnerRepo;

@Service
public class OwnerService {

    private static final Logger logger = LoggerFactory.getLogger(OwnerService.class);

    @Autowired
    private OwnerRepo ownerRepo;

    public List<CarOwner> addOwner(List<CarOwner> ownerList) {
        logger.info("Received request to add {} owners", ownerList.size());

        List<CarOwner> getAllCarOwner = ownerRepo.findAll();
        logger.info("Fetched {} existing owners from the database", getAllCarOwner.size());

        for (CarOwner existingOwner : getAllCarOwner) {
            for (CarOwner newOwner : ownerList) {
                if (existingOwner.getPhno() == newOwner.getPhno()) {
                    logger.warn("Duplicate registration attempt: {} already registered with phone {}", 
                                existingOwner.getOwnerName(), existingOwner.getPhno());
                    throw new MyException(existingOwner.getOwnerName() + 
                                          " is already registered with PhoneNumber " + existingOwner.getPhno());
                }
            }
        }

        List<CarOwner> savedOwners = ownerRepo.saveAll(ownerList);
        logger.info("Successfully added {} new owners", savedOwners.size());

        return savedOwners;
    }
}
