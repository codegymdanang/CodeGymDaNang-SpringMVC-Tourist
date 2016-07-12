package guru.tour.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "host")
public class HostDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private int phone;

	public HostDetailEntity() {

	}

	public HostDetailEntity(Integer id, String name, int phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ServiceHostDetailEntity [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
}
