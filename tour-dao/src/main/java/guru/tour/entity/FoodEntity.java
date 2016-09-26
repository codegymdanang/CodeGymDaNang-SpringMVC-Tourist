package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the food database table.
 * 
 */
@Entity
@Table(name="food")
@NamedQuery(name="FoodEntity.findAll", query="SELECT f FROM FoodEntity f")
public class FoodEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String description;

	private String images;

	private String name;

	private String phone;

	private double price;

	//bi-directional many-to-one association to LocationEntity
	@ManyToOne
	@JoinColumn(name="local_id")
	private LocationEntity location;

	public FoodEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
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

}