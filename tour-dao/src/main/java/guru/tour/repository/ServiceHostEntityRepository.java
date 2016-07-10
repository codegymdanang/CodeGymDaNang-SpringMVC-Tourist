package guru.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.ServiceHostEntity;

public interface ServiceHostEntityRepository extends JpaRepository<ServiceHostEntity, Integer>{
	public List<ServiceHostEntity> findByName(String name);
}
