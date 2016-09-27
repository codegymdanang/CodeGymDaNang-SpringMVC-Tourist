package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@Table(name="location")
@NamedQuery(name="LocationEntity.findAll", query="SELECT l FROM LocationEntity l")
public class LocationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="location_id")
	private String locationId = UUID.randomUUID().toString();

	@Column(name="location_name")
	private String locationName;

	//bi-directional many-to-one association to EventEntity
	@OneToMany(mappedBy="location")
	private List<EventEntity> events;

	//bi-directional many-to-one association to FoodEntity
	@OneToMany(mappedBy="location")
	private List<FoodEntity> foods;

	//bi-directional many-to-one association to HotelEntity
	@OneToMany(mappedBy="location")
	private List<HotelEntity> hotels;

	//bi-directional many-to-one association to PlaceEntity
	@OneToMany(mappedBy="location")
	private List<PlaceEntity> places;

	//bi-directional many-to-one association to VehicalEntity
	@OneToMany(mappedBy="location")
	private List<VehicalEntity> vehicals;

	//bi-directional many-to-one association to WarningEntity
	@OneToMany(mappedBy="location")
	private List<WarningEntity> warnings;

	public LocationEntity() {
	}

	public String getLocationId() {
		return this.locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public List<EventEntity> getEvents() {
		return this.events;
	}

	public void setEvents(List<EventEntity> events) {
		this.events = events;
	}

	public EventEntity addEvent(EventEntity event) {
		getEvents().add(event);
		event.setLocation(this);

		return event;
	}

	public EventEntity removeEvent(EventEntity event) {
		getEvents().remove(event);
		event.setLocation(null);

		return event;
	}

	public List<FoodEntity> getFoods() {
		return this.foods;
	}

	public void setFoods(List<FoodEntity> foods) {
		this.foods = foods;
	}

	public FoodEntity addFood(FoodEntity food) {
		getFoods().add(food);
		food.setLocation(this);

		return food;
	}

	public FoodEntity removeFood(FoodEntity food) {
		getFoods().remove(food);
		food.setLocation(null);

		return food;
	}

	public List<HotelEntity> getHotels() {
		return this.hotels;
	}

	public void setHotels(List<HotelEntity> hotels) {
		this.hotels = hotels;
	}

	public HotelEntity addHotel(HotelEntity hotel) {
		getHotels().add(hotel);
		hotel.setLocation(this);

		return hotel;
	}

	public HotelEntity removeHotel(HotelEntity hotel) {
		getHotels().remove(hotel);
		hotel.setLocation(null);

		return hotel;
	}

	public List<PlaceEntity> getPlaces() {
		return this.places;
	}

	public void setPlaces(List<PlaceEntity> places) {
		this.places = places;
	}

	public PlaceEntity addPlace(PlaceEntity place) {
		getPlaces().add(place);
		place.setLocation(this);

		return place;
	}

	public PlaceEntity removePlace(PlaceEntity place) {
		getPlaces().remove(place);
		place.setLocation(null);

		return place;
	}

	public List<VehicalEntity> getVehicals() {
		return this.vehicals;
	}

	public void setVehicals(List<VehicalEntity> vehicals) {
		this.vehicals = vehicals;
	}

	public VehicalEntity addVehical(VehicalEntity vehical) {
		getVehicals().add(vehical);
		vehical.setLocation(this);

		return vehical;
	}

	public VehicalEntity removeVehical(VehicalEntity vehical) {
		getVehicals().remove(vehical);
		vehical.setLocation(null);

		return vehical;
	}

	public List<WarningEntity> getWarnings() {
		return this.warnings;
	}

	public void setWarnings(List<WarningEntity> warnings) {
		this.warnings = warnings;
	}

	public WarningEntity addWarning(WarningEntity warning) {
		getWarnings().add(warning);
		warning.setLocation(this);

		return warning;
	}

	public WarningEntity removeWarning(WarningEntity warning) {
		getWarnings().remove(warning);
		warning.setLocation(null);

		return warning;
	}

}