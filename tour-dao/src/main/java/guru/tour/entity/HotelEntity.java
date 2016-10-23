package guru.tour.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@Table(name="hotel")
@NamedQuery(name="HotelEntity.findAll", query="SELECT h FROM HotelEntity h")
public class HotelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hotel_id")
	private String hotelId = UUID.randomUUID().toString();

	private String description;

	@Column(name="hotel_name")
	private String hotelName;

	private String images;

	private int phone;

	private double price;

	//bi-directional many-to-one association to LocationEntity
	@ManyToOne
	@JoinColumn(name="location_id")
	private LocationEntity location;

	//bi-directional many-to-one association to TypeEntity
	@ManyToOne
	private TypeEntity type;

	public HotelEntity() {
	}

	public String getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHotelName() {
		return this.hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocationEntity getLocation() {
		return this.location;
	}

	public void setLocation(LocationEntity location) {
		this.location = location;
	}

	public TypeEntity getType() {
		return this.type;
	}

	public void setType(TypeEntity type) {
		this.type = type;
	}

}