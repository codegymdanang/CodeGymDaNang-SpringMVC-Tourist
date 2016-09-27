package guru.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.HotNewEntity;

public interface HotNewsEntityRepository extends JpaRepository<HotNewEntity, String> {
	
}
