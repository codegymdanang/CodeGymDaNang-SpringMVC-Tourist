package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "description")
	private String description;
	@Column(name = "images")
	private String images;
	@Column(name = "name")
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
	private List<UserScheduleEntity> userSchedules;

	public PlaceEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public List<UserScheduleEntity> getUserSchedules() {
		return this.userSchedules;
	}

	public void setUserSchedules(List<UserScheduleEntity> userSchedules) {
		this.userSchedules = userSchedules;
	}

	public UserScheduleEntity addUserSchedule(UserScheduleEntity userSchedule) {
		getUserSchedules().add(userSchedule);
		userSchedule.setPlace(this);

		return userSchedule;
	}

	public UserScheduleEntity removeUserSchedule(UserScheduleEntity userSchedule) {
		getUserSchedules().remove(userSchedule);
		userSchedule.setPlace(null);

		return userSchedule;
	}

}