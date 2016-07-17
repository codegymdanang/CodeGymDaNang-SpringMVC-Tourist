package guru.tour.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "host")
public class ServiceHostEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "images")
	private String images;
	
	@Column(name = "phone")
	private int phone;
	

	public ServiceHostEntity() {
		super();
	}
	
	public ServiceHostEntity(int id, String name, int phone) {
		this.id =  id;
		this.name =  name;
		this.phone = phone;
	}
	public ServiceHostEntity(int id, String name, String images, int phone) {
		this.id =  id;
		this.name =  name;
		this.phone = phone;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	
}
