package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.PlaceEntity;

public interface PlaceEntityRepository extends JpaRepository<PlaceEntity, Integer> {

}
