package guru.tour.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class FoodEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private double price;
	@Column(name = "images")
	private String images;
	@Column(name = "phone")
	private String phone;
	@Column(name = "description")
	private String description;
	@Column(name = "local_id")
	private int local_id;
	@ManyToOne
	@JoinColumn(name = "local_id", insertable=false, updatable=false)
	private LocationEntity locationEntity;
	
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocationEntity getLocationEntity() {
		return locationEntity;
	}
	public void setLocationEntity(LocationEntity locationEntity) {
		this.locationEntity = locationEntity;
	}
}
