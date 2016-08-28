package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.AddressEntity;

public interface AddressEntityRepository extends JpaRepository<AddressEntity, Integer> {
}
