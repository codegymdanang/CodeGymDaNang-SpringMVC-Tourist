package guru.tour.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "location")
public class LocationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "location_id")
	private int id;
	@Column(name = "location_name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "locationEntity")
	@JsonIgnore
	private List<FoodEntity> food = new ArrayList<FoodEntity>();
	
	
	//bi-directional many-to-one association to Place
		@OneToMany(mappedBy="location")
		private List<PlaceEntity> places;
		
	 

	public List<PlaceEntity> getPlaces() {
			return places;
		}

		public void setPlaces(List<PlaceEntity> places) {
			this.places = places;
		}

	@OneToMany(mappedBy = "event_location")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private List<EventEntity> location_event = new ArrayList<EventEntity>();

	
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

	public List<FoodEntity> getFood() {
		return food;
	}

	public void setFood(List<FoodEntity> food) {
		this.food = food;
	}

	public List<EventEntity> getLocation_event() {
		return location_event;
	}

	public void setLocation_event(List<EventEntity> location_event) {
		this.location_event = location_event;
	}


	

}
