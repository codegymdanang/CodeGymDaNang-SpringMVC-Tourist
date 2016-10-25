package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, String> {

}
