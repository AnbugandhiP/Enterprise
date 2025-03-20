package Interview.MyCar.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Interview.MyCar.Model.CarOwner;

@Repository
public interface OwnerRepo extends JpaRepository<CarOwner, Long> {

	
}
