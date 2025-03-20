package Interview.MyCar.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Interview.MyCar.Model.Lease;

@Repository
public interface LeaseRepo extends JpaRepository<Lease, Long> {

	public static final String findByCar= "select * from Lease where car_id=:carId order by lease_id desc";
	@Query(value =findByCar, nativeQuery=true)
	List<Lease> findByCar( @Param ("carId")int carId);
	
	public static final String findByRegNo= "select * from Lease where reg_no=:regNo";
	@Query(value=findByRegNo, nativeQuery=true)
	List<Lease> findByRegNo( @Param ("regNo" )int regNo);

}
