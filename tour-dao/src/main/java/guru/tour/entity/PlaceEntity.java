package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the place database table.
 * 
 */
@Entity
@Table(name="place")
@NamedQuery(name="PlaceEntity.findAll", query="SELECT p FROM PlaceEntity p")
public class PlaceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();

	private String description;

	private String images;

	private String name;

	//bi-directional many-to-one association to AddressEntity
	@OneToMany(mappedBy="place")
	private List<AddressEntity> addresses;

	//bi-directional many-to-one association to LocationEntity
	@ManyToOne
	@JoinColumn(name="local_id")
	private LocationEntity location;

	//bi-directional many-to-one association to UserScheduleEntity
	@OneToMany(mappedBy="place")
	private List<UserScheduleEntity> userschedules;

	public PlaceEntity() {
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

	public List<AddressEntity> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<AddressEntity> addresses) {
		this.addresses = addresses;
	}

	public AddressEntity addAddress(AddressEntity address) {
		getAddresses().add(address);
		address.setPlace(this);

		return address;
	}

	public AddressEntity removeAddress(AddressEntity address) {
		getAddresses().remove(address);
		address.setPlace(null);

		return address;
	}

	public LocationEntity getLocation() {
		return this.location;
	}

	public void setLocation(LocationEntity location) {
		this.location = location;
	}

	public List<UserScheduleEntity> getUserschedules() {
		return this.userschedules;
	}

	public void setUserschedules(List<UserScheduleEntity> userschedules) {
		this.userschedules = userschedules;
	}

	public UserScheduleEntity addUserschedule(UserScheduleEntity userschedule) {
		getUserschedules().add(userschedule);
		userschedule.setPlace(this);

		return userschedule;
	}

	public UserScheduleEntity removeUserschedule(UserScheduleEntity userschedule) {
		getUserschedules().remove(userschedule);
		userschedule.setPlace(null);

		return userschedule;
	}

}