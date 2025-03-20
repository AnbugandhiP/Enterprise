package Interview.MyCar.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Interview.MyCar.Service.LeaseService;

@RestController
@RequestMapping("/lease")
public class LeaseController {

    private static final Logger logger = LoggerFactory.getLogger(LeaseController.class);

    @Autowired
    private LeaseService leaseService;

    @PostMapping("/takeLease/{userName}/{carName}")
    public String takeLease(@PathVariable String userName, @PathVariable String carName) {
        logger.info("POST /takeLease called with user: {} and car: {}", userName, carName);
        return leaseService.takeLease(userName, carName);
    }

    @PostMapping("/removeLease/{userName}/{carName}/{reg_no}")
    public String removeLease(@PathVariable String userName, @PathVariable String carName, @PathVariable int reg_no) {
        logger.info("POST /removeLease called with user: {}, car: {}, reg_no: {}", userName, carName, reg_no);
        return leaseService.removeLease(userName, carName, reg_no);
    }
}
