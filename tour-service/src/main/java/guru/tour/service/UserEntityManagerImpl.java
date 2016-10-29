package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import guru.tour.entity.UserEntity;
import guru.tour.repository.ServiceFriendsRepository;

@Service
public class UserEntityManagerImpl implements UserEntityManager{
	@Autowired
	private PasswordEncoder passEncode;

	@Autowired
	ServiceFriendsRepository friendsRepository;
	public UserEntity getUserByName(String name) {
		// TODO Auto-generated method stub
		return friendsRepository.findByUsername(name);
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
	/*public List<UserEntity> getAllViaDiaDiem(String diadiem) {
		// TODO Auto-generated method stub
	 return friendsRepository.findByRoles_IdAndDiadiem(3,diadiem);
	}*/
	public void updateByUsername(UserEntity user) {
		friendsRepository.updateUsername(user.getUsername(), user.getImage(), user.getPhone(), user.getDiadiem());
	}
	public UserEntity getUserById(String id) {
		// TODO Auto-generated method stub
		return friendsRepository.findById(id);
	}
	public void updatePasswordByUsername(UserEntity user) {
		friendsRepository.updatePasswordByUsername(user.getUsername(), user.getPassword());
	}
	public void updateComment(String username, String comment){
		friendsRepository.updateComment(username, comment);
	}
	@Override
	public List<UserEntity> findUserContainingName(String name) {
		// TODO Auto-generated method stub
		return friendsRepository.findByUsernameContaining(name);
	}


}
