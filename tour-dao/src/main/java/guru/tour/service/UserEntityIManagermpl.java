package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.UserEntity;
import guru.tour.repository.ServiceFriendsRepository;

@Service
public class UserEntityIManagermpl implements UserEntityManager{

	@Autowired
	ServiceFriendsRepository friendsRepository;
	public List<UserEntity> getUserByName(String name) {
		// TODO Auto-generated method stub
		return friendsRepository.findByUsername(name);
	}
	public List<UserEntity> getUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return friendsRepository.findByPhone(phone);
	}
	public UserEntity saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		return friendsRepository.save(user);
	}


	public List<UserEntity> getAll() {

		// TODO Auto-generated method stub
		return friendsRepository.findAll();
	}
	
}
