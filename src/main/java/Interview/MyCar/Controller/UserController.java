package Interview.MyCar.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Interview.MyCar.Model.EndUser;
import Interview.MyCar.Service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public List<EndUser> addUser(@RequestBody List<EndUser> users) {
        logger.info("POST /addUser API called with {} users", users.size());
        return userService.addUser(users);
    }
}
