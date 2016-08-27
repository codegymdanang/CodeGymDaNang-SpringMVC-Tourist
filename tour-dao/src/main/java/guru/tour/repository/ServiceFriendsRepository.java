package guru.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import guru.tour.entity.UserEntity;

@Transactional(readOnly=true)
public interface ServiceFriendsRepository extends JpaRepository<UserEntity, Integer>{
	public List<UserEntity> findByUsername(String name);
	public List<UserEntity> findByPhone(String phone);
	List<UserEntity> findByRoles_IdAndDiadiem(Integer roleId,String diadiem);
	public List<UserEntity> findByUsernameContaining(String name);
	
	@Modifying
	@Transactional
	@Query("UPDATE UserEntity u SET u.password = :password , u.phone = :phone, u.image = :image ,u.diadiem = :diadiem WHERE u.username = :username ")
	public void updateUsername(@Param("username")String username, @Param("password")String password,@Param("image")String image,@Param("phone")String phone,@Param("diadiem")String diadiem);
}
