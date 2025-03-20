package Interview.MyCar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Interview.MyCar.Model.LeaseOwnerUser;
import Interview.MyCar.Service.LeaseOwnerUserService;

import java.util.List;

@RestController
@RequestMapping("/leaseOwnerUser")
public class LeaseOwnerUserController {

    @Autowired
    private LeaseOwnerUserService leaseOwnerUserService;

    @PostMapping("/add")
    public LeaseOwnerUser addLeaseOwnerUser(@RequestBody LeaseOwnerUser user) {
        return leaseOwnerUserService.addLeaseOwnerUser(user);
    }

    @GetMapping("/all")
    public List<LeaseOwnerUser> getAllLeaseOwnerUsers() {
        return leaseOwnerUserService.getAllLeaseOwnerUsers();
    }

    @GetMapping("/{id}")
    public LeaseOwnerUser getLeaseOwnerUserById(@PathVariable Long id) {
        return leaseOwnerUserService.getLeaseOwnerUserById(id);
    }

    @PutMapping("/update/{id}")
    public LeaseOwnerUser updateLeaseOwnerUser(@PathVariable Long id, @RequestBody LeaseOwnerUser updatedUser) {
        return leaseOwnerUserService.updateLeaseOwnerUser(id, updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLeaseOwnerUser(@PathVariable Long id) {
        return leaseOwnerUserService.deleteLeaseOwnerUser(id);
    }
}
