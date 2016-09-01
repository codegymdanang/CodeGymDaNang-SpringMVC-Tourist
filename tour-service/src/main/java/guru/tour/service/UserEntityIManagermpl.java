package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import guru.tour.entity.UserEntity;
import guru.tour.repository.ServiceFriendsRepository;

@Service
public class UserEntityIManagermpl implements UserEntityManager{
	@Autowired
	private PasswordEncoder passEncode;

	@Autowired
	ServiceFriendsRepository friendsRepository;
	public List<UserEntity> getUserByName(String name) {
		// TODO Auto-generated method stub
		return friendsRepository.findByUsernameContaining(name);
	}
	public List<UserEntity> getUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return friendsRepository.findByPhone(phone);
	}
	public UserEntity saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		String a=passEncode.encode(user.getPassword());
		user.setPassword(a);
		return friendsRepository.save(user);
	}


	public List<UserEntity> getAll() {

		// TODO Auto-generated method stub
		return friendsRepository.findAll();
	}
	public boolean isUserExist(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return findByName(userEntity.getUsername())==true;
	}
	private boolean findByName(String username) {
		// TODO Auto-generated method stub
		for(UserEntity user : getAll()){
            if(user.getUsername().equalsIgnoreCase(username)){
                return true;
            }
        }
        return false;
	}
	public List<UserEntity> getAllViaDiaDiem(String diadiem) {
		// TODO Auto-generated method stub
	 return friendsRepository.findByRoles_IdAndDiadiem(3,diadiem);
	}
	public void updateByUsername(String username, String password, String image, String phone, String diadiem) {
		friendsRepository.updateUsername(username, password, image, phone, diadiem);
	}
	
}
