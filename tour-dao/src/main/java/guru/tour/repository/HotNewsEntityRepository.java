package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.HotNewsEntity;

public interface HotNewsEntityRepository extends JpaRepository<HotNewsEntity, Integer> {

}
