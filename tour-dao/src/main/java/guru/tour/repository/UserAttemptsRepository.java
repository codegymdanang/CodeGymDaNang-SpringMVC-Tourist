package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import guru.tour.entity.UserAttemptEntity;

public interface UserAttemptsRepository extends JpaRepository<UserAttemptEntity,Integer>{
	
	public UserAttemptEntity findByUsername(String name);
	
	@Modifying
	@Transactional
	@Query("UPDATE UserAttemptEntity u SET u.attempts = u.attempts + 1 WHERE u.username = :username ")
	public void updateAttempts(@Param("username") String name);
	
	@Modifying
	@Transactional
	@Query("DELETE from UserAttemptEntity u where u.username = :username ")
	public void resetAttempts(@Param("username") String name);
	
	@Query("SELECT count(u) FROM UserAttemptEntity u WHERE u.username = :username ")
	public long countAttempts(@Param("username") String name);
	
}
