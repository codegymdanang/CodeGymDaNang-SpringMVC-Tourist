package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.UserScheduleEntity;

public interface UserScheduleRepository extends JpaRepository<UserScheduleEntity, String>  {

}
