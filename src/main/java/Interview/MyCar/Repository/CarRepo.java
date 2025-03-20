package Interview.MyCar.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Interview.MyCar.Model.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

	@Query(value = "SELECT * FROM Car WHERE reg_no = :regNo", nativeQuery = true)
	Car getCarByRegNo(@Param("regNo") int regNo);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Car SET status = 'Not available' WHERE reg_no = :regNo", nativeQuery = true)
	int updatingCar(@Param("regNo") int regNo);

	@Query(value = "SELECT * FROM Car WHERE name = :name AND status = 'available' LIMIT 1", nativeQuery = true)
	List<Car> findAvailablecars(@Param("name") String name);

	@Query(value = "SELECT * FROM Car WHERE status = 'in use' AND reg_no = :regNo LIMIT 1", nativeQuery = true)
	List<Car> findLeasedCars(@Param("name") String name, @Param("regNo") int regNo);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Car SET status = 'in use' WHERE name = :name and reg_no=:regNo LIMIT 1", nativeQuery = true)
	int updateLeasedCar(@Param("name") String name, @Param("regNo") int regNo);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Car SET status = 'available' WHERE name = :name AND reg_no = :regNo LIMIT 1", nativeQuery = true)
	int updateCar1(@Param("name") String name, @Param("regNo") int regNo);

	@Transactional
	@Modifying
	@Query(value = "UPDATE EndUser SET car_leased_with = :carName WHERE user_name = :userName LIMIT 1", nativeQuery = true)
	int updateUser(@Param("carName") String carName, @Param("userName") String userName);

	@Transactional
	@Modifying
	@Query(value = "UPDATE EndUser SET car_leased_with = NULL WHERE user_name = :userName LIMIT 1", nativeQuery = true)
	int updateUser1(@Param("userName") String userName);

	@Transactional
	@Modifying
	@Query("DELETE FROM Car c WHERE c.regNo = :regNo")
	int updatingCar(Integer regNo);
}
