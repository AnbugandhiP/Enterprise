package Interview.MyCar.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lease")
public class Lease {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaseId;
	private String userName;
	private int carId;
	private String carName;
	private int regNo;
	private LocalDate startDate;

	public Lease(int leaseId, String userName, int carId, String carName, int regNo, LocalDate startDate,
			LocalDate endDate, String status, String ownerName) {
		super();
		this.leaseId = leaseId;
		this.userName = userName;
		this.carId = carId;
		this.carName = carName;
		this.regNo = regNo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.ownerName = ownerName;
	}

	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	private LocalDate endDate;
	private String status;
	private String ownerName;

	public Lease() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getLeaseId() {
		return leaseId;
	}

	public void setLeaseId(int leaseId) {
		this.leaseId = leaseId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate localDate) {
		this.startDate = localDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Lease [leaseId=" + leaseId + ", userName=" + userName + ", carId=" + carId + ", carName=" + carName
				+ ", regNo=" + regNo + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status
				+ ", ownerName=" + ownerName + "]";
	}

}
