package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.HotelEntity;

public interface HotelEntityRepository extends JpaRepository<HotelEntity, Integer> {
}
