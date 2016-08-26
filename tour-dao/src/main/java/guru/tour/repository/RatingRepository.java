package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.RatingEntity;
import guru.tour.entity.UserEntity;

public interface RatingRepository extends JpaRepository<RatingEntity, Integer>{

}
