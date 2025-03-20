package Interview.MyCar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int regNo;
	private String ownerName;
	private String status;

	public int getRegNo() {
		return regNo;
	}

	public Car(int id, String name, int regNo, String ownerName, String status) {
		super();
		this.id = id;
		this.name = name;
		this.regNo = regNo;
		this.ownerName = ownerName;
		this.status = status;
	}

	public Car(int id, String name,  String ownerName,int regNo) {
		super();
		this.id = id;
		this.name = name;
		this.regNo = regNo;
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", regNo=" + regNo + ", ownerName=" + ownerName + ", status="
				+ status + "]";
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PrePersist
	public void prePersist() {
		if (this.status == null) {
			this.status = "available";
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
