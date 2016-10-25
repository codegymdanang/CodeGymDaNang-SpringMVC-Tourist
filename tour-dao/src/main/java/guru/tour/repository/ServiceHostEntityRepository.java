package guru.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.HostEntity;

public interface ServiceHostEntityRepository extends JpaRepository<HostEntity, String>{
	public List<HostEntity> findByName(String name);
}
