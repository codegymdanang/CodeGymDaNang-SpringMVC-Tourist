package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.RoleEntity;
import guru.tour.entity.UserEntity;
import guru.tour.entity.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, String>{

}
