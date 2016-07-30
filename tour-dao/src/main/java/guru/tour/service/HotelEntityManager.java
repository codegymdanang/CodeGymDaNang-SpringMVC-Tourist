package guru.tour.service;

import java.util.List;

import guru.tour.entity.HotelEntity;

public interface HotelEntityManager {
	public List<HotelEntity> getAllHotel();

	public HotelEntity findById(int id);

	public boolean isHotelEntity(HotelEntity hotel);

	public void saveHotelEntity(HotelEntity hotel);

	public void deletehotelById(int id);

	public void updatehotel(HotelEntity currenthotel);
}
