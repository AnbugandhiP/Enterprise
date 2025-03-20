package Interview.MyCar.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Enduser")
public class EndUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private long phno;
	private String carLeasedWith;

	public EndUser(Long id, String userName, long phno, String carLeasedWith) {
		super();
		this.id = id;
		this.userName = userName;
		this.phno = phno;
		this.carLeasedWith = carLeasedWith;
	}

	@PrePersist
	public void prePersist() {
		if (this.carLeasedWith == null) {
			this.carLeasedWith = "no";
		}
	}

	public String getCarLeasedWith() {
		return carLeasedWith;
	}

	public void setCarLeasedWith(String carLeasedWith) {
		this.carLeasedWith = carLeasedWith;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	@Override
	public String toString() {
		return "EndUser [id=" + id + ", userName=" + userName + ", phno=" + phno + ", carLeasedWith=" + carLeasedWith
				+ "]";
	}

	public EndUser() {
		super();
		// TODO Auto-generated constructor stub
	}

}
