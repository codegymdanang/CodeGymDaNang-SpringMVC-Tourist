package guru.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.UserEntity;


public interface ServiceFriendsRepository extends JpaRepository<UserEntity, Integer>{
	public List<UserEntity> findByUsername(String name);
	public List<UserEntity> findByPhone(String phone);
}
