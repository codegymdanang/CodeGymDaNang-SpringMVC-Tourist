package guru.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import guru.tour.entity.HotelEntity;
import guru.tour.entity.LocationEntity;

public interface HotelEntityRepository extends JpaRepository<HotelEntity, String> {
	public HotelEntity findByHotelId(String hotelId);
	public List<HotelEntity> findByLocation(LocationEntity localId);
}
