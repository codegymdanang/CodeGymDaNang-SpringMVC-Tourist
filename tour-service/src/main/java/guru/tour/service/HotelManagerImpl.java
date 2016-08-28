package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import guru.tour.entity.HotelEntity;
import guru.tour.repository.HotelEntityRepository;

@Service
public class HotelManagerImpl implements HotelEntityManager {
	@Autowired
	HotelEntityRepository hotelEntityRepository;
	
	public List<HotelEntity> getAllHotel() {
		return hotelEntityRepository.findAll();
	}

	public HotelEntity findById(int id) {
		return hotelEntityRepository.findById(id);
	}

	public boolean isHotelEntity(HotelEntity hotel) {
		if(getAllHotel().contains(hotel))
		return true;
		return false;
	}

	public void saveHotelEntity(HotelEntity hotel) {
		 hotelEntityRepository.save(hotel);
	}

	public void deletehotelById(int id) {
		hotelEntityRepository.delete(id);
	}

	public void updatehotel(HotelEntity hotel) {
		hotelEntityRepository.saveAndFlush(hotel);
	}
	
	
}
