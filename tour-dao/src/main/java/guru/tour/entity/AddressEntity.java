package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="AddressEntity.findAll", query="SELECT a FROM AddressEntity a")
public class AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String address;

	//bi-directional many-to-one association to PlaceEntity
	@ManyToOne
	private PlaceEntity place;

	//bi-directional many-to-one association to EventEntity
	@OneToMany(mappedBy="address")
	private List<EventEntity> events;

	public AddressEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PlaceEntity getPlace() {
		return this.place;
	}

	public void setPlace(PlaceEntity place) {
		this.place = place;
	}

	public List<EventEntity> getEvents() {
		return this.events;
	}

	public void setEvents(List<EventEntity> events) {
		this.events = events;
	}

	public EventEntity addEvent(EventEntity event) {
		getEvents().add(event);
		event.setAddress(this);

		return event;
	}

	public EventEntity removeEvent(EventEntity event) {
		getEvents().remove(event);
		event.setAddress(null);

		return event;
	}

}