package guru.tour.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;


/**
 * The persistent class for the vehical database table.
 * 
 */
@Entity
@Table(name="vehical")
@NamedQuery(name="VehicalEntity.findAll", query="SELECT v FROM VehicalEntity v")
public class VehicalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();

	private String images;

	private String name;

	private int phone;

	private double price;

	//bi-directional many-to-one association to LocationEntity
	@ManyToOne
	@JoinColumn(name="local_id")
	private LocationEntity location;

	//bi-directional many-to-one association to TypeEntity
	@ManyToOne
	private TypeEntity type;

	public VehicalEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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