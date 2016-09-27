package guru.tour.model;

import java.util.List;

import guru.tour.entity.HotelEntity;

public class LocationModel {

	private String locationId;
	private String locationName;
	public LocationModel(String locationId, String locationName) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
	}
	public LocationModel() {
		super();
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
}
