package Interview.MyCar.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Interview.MyCar.Exception.MyException;
import Interview.MyCar.Model.EndUser;
import Interview.MyCar.Repository.EndUserRepo;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private EndUserRepo endUserRepo;

    public List<EndUser> addUser(List<EndUser> users) {
        logger.info("Received request to add {} users", users.size());

        List<EndUser> existingUsers = endUserRepo.findAll();
        logger.info("Fetched {} existing users from the database", existingUsers.size());

        for (EndUser newUser : users) {
            for (EndUser existingUser : existingUsers) {
                if (newUser.getPhno() == existingUser.getPhno()) {
                    logger.warn("Duplicate registration attempt: User {} already registered with phone {}", 
                                existingUser.getUserName(), existingUser.getPhno());
                    throw new MyException("EndUser " + newUser.getUserName() + 
                                          " is already registered with phone number " + newUser.getPhno());
                }
            }
        }

        List<EndUser> savedUsers = endUserRepo.saveAll(users);
        logger.info("Successfully added {} new users", savedUsers.size());

        return savedUsers;
    }
}
