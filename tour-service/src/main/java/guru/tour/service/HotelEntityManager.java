package guru.tour.service;

import java.util.List;

import guru.tour.entity.HotelEntity;
import guru.tour.model.HotelModel;

public interface HotelEntityManager {
	
	public List<HotelEntity> getAllHotel();

	public HotelEntity findById(String id);

	public boolean isHotelEntity(HotelEntity hotel);

	public void saveHotelEntity(HotelEntity hotel);

	public void deletehotelById(String id);

	public void updatehotel(HotelEntity currenthotel);
	
	public List<HotelModel> getAllHotelModel();

	public List<HotelModel> getHotelByLocationId(String id);
}
