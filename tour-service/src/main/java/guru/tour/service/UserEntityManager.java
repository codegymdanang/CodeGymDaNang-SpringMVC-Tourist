package guru.tour.service;

import java.util.List;


import guru.tour.entity.UserEntity;

public interface UserEntityManager {
	UserEntity getUserByName(String name);
	List<UserEntity> getUserByPhone(String phone);
	UserEntity saveUser(UserEntity user);
	List<UserEntity> getAll();
	//List<UserEntity> getAllViaDiaDiem(String diadiem);
	boolean isUserExist(UserEntity userEntity);
	void updateByUsername(UserEntity user);
	UserEntity getUserById(String id);
	void updatePasswordByUsername(UserEntity user);
	void updateComment(String username, String comment);
	List<UserEntity> findUserContainingName(String name);
}
