package guru.tour.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class HotelEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	@Column(name = "hotel_id")
	private int id;
	@Column(name = "hotel_name")
	private String name;
	@Column(name = "price")
	private double price;
	@Column(name = "images")
	private String images;
	@Column(name = "phone")
	private int phone;
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private LocationEntity locationid;
	
	public HotelEntity() {
		super();
	}

	public HotelEntity(int id, String name, double price, String images, int phone, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.images = images;
		this.phone = phone;
		this.description = description;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return images;
	}

	public void setImage(String images) {
		this.images = images;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public LocationEntity getLc() {
		return locationid;
	}

	public void setLc(LocationEntity lc) {
		this.locationid = lc;
	}

		
	
}
