package guru.tour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.RoleEntity;
import guru.tour.entity.UserEntity;
import guru.tour.entity.UserRoleEntity;
import guru.tour.repository.UserRoleRepository;

@Service
public class UserRoleImp implements UserRoleManager {

	@Autowired
	UserRoleRepository userRole;
	
	@Override
	public void saveUserRole(String roleId, String userId) {
		// TODO Auto-generated method stub
		userRole.save(new UserRoleEntity(new RoleEntity(roleId), new UserEntity(userId)));
	}

}
