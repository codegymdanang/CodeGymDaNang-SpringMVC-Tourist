package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.UserSchedule;

public interface UserScheduleRepository extends JpaRepository<UserSchedule, String>  {

}
