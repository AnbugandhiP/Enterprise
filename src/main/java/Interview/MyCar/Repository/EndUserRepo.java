package Interview.MyCar.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import Interview.MyCar.Model.EndUser;

public interface EndUserRepo extends JpaRepository<EndUser, Long> {

    List<EndUser> findByUserName(String userName);

}
