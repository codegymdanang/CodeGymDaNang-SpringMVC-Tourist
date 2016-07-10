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
		// TODO Auto-generated method stub
		return hotelEntityRepository.findAll();
	}
	
}
