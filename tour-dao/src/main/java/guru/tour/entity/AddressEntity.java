package guru.tour.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class AddressEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "address")
	private String address;
	@Column(name = "place_id")
	private int placeId;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "place_id", insertable = false, updatable = false)
	/* @JsonManagedReference */
	private PlaceEntity placeEntity;

	@OneToMany(mappedBy = "event_add")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private List<EventEntity> address_event = new ArrayList<EventEntity>();

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public PlaceEntity getPlaceEntity() {
		return placeEntity;
	}

	public void setPlaceEntity(PlaceEntity placeEntity) {
		this.placeEntity = placeEntity;
	}

	public AddressEntity() {
		super();
	}

	public AddressEntity(int id, String address, int place_id) {
		super();
		this.id = id;
		this.address = address;
		this.placeId = place_id;
	}

	public List<EventEntity> getAddress_event() {
		return address_event;
	}

	public void setAddress_event(List<EventEntity> address_event) {
		this.address_event = address_event;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPlace_id() {
		return placeId;
	}

	public void setPlace_id(int place_id) {
		this.placeId = place_id;
	}
	

}
