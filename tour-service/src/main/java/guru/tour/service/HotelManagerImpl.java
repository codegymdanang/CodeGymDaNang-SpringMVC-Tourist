package guru.tour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import guru.tour.entity.HotelEntity;
import guru.tour.model.HotelModel;
import guru.tour.model.LocationModel;
import guru.tour.model.TypeModel;
import guru.tour.repository.HotelEntityRepository;
import guru.tour.repository.LocationRepository;

@Service
public class HotelManagerImpl implements HotelEntityManager {
	@Autowired
	HotelEntityRepository hotelEntityRepository;
	
	@Autowired
	LocationRepository locationRepository;
	public List<HotelEntity> getAllHotel() {
		return hotelEntityRepository.findAll();
	}

	public HotelEntity findById(String id) {
		return hotelEntityRepository.findByHotelId(id);
	}

	public boolean isHotelEntity(HotelEntity hotel) {
		if(getAllHotel().contains(hotel))
		return true;
		return false;
	}

	public void saveHotelEntity(HotelEntity hotel) {
		 hotelEntityRepository.save(hotel);
	}

	public void deletehotelById(String id) {
		hotelEntityRepository.delete(id);
	}

	public void updatehotel(HotelEntity hotel) {
		hotelEntityRepository.saveAndFlush(hotel);
	}
	
	@Override
	public List<HotelModel> getAllHotelModel() {
		List<HotelEntity> listHotel = getAllHotel();
		List<HotelModel> listModel = new ArrayList<HotelModel>();
		
		for (HotelEntity list : listHotel) {
			LocationModel location= new LocationModel(list.getLocation().getLocationId(),list.getLocation().getLocationName());
			TypeModel type= new TypeModel(list.getType().getId(),list.getType().getName());
			listModel.add(new HotelModel(list.getHotelId(),list.getDescription(),list.getHotelName(),list.getImages(),list.getPhone(),list.getPrice(),location,type));
		}
		return listModel;
	}

	@Override
	public List<HotelModel> getHotelByLocationId(String id) {
		// TODO Auto-generated method stub
		List<HotelEntity> listHotel = hotelEntityRepository.findByLocation(locationRepository.findOne(id));
		List<HotelModel> listModel = new ArrayList<HotelModel>();
		
		for (HotelEntity list : listHotel) {
			LocationModel location= new LocationModel(list.getLocation().getLocationId(),list.getLocation().getLocationName());
			TypeModel type= new TypeModel(list.getType().getId(),list.getType().getName());
			listModel.add(new HotelModel(list.getHotelId(),list.getDescription(),list.getHotelName(),list.getImages(),list.getPhone(),list.getPrice(),location,type));
		}
		return listModel;
	}
	
	
}
