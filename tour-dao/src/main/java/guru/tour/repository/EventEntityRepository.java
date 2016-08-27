package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.EventEntity;

public interface EventEntityRepository extends JpaRepository<EventEntity, Integer>{
	public EventEntity findByName(String name);
}
