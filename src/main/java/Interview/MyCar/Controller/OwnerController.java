package Interview.MyCar.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Interview.MyCar.Model.CarOwner;
import Interview.MyCar.Service.OwnerService;

@RestController
@RequestMapping("/carOwner")
public class OwnerController {

    private static final Logger logger = LoggerFactory.getLogger(OwnerController.class);

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/addOwner")
    public List<CarOwner> addOwner(@RequestBody List<CarOwner> ownerList) {
        logger.info("POST /addOwner API called with {} owners", ownerList.size());
        return ownerService.addOwner(ownerList);
    }
}
