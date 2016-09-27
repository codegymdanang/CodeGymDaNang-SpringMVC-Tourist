package guru.tour.model;

import java.util.List;

import guru.tour.entity.HotelEntity;

public class LocationModel {

	private int locationId;
	private String locationName;
	public LocationModel(int locationId, String locationName) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
	}
	public LocationModel() {
		super();
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
}
