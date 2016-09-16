package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="location_id")
	private int locationId;

	@Column(name="location_name")
	private String locationName;

	//bi-directional many-to-one association to EventEntity

	@OneToMany(mappedBy="location")
 	private List<HotelEntity> hotels ;



	public LocationEntity() {
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}



	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy = "location")
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









}