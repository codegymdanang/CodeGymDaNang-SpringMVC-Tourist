package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity,Integer> {
	
	public UserEntity findByUsername(String username);
}
