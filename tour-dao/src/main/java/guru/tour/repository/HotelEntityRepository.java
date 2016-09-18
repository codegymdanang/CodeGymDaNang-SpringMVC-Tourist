package guru.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import guru.tour.entity.HotelEntity;
import guru.tour.entity.LocationEntity;

public interface HotelEntityRepository extends JpaRepository<HotelEntity, Integer> {
	public HotelEntity findByHotelId(int hotelId);
	public List<HotelEntity> findByLocation(LocationEntity localId);
}
