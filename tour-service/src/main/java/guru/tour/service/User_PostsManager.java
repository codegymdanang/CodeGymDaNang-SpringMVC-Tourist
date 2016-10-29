package guru.tour.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import guru.tour.entity.UserEntity;
import guru.tour.entity.UserPostEntity;

public interface User_PostsManager {
	UserPostEntity saveUser_Posts(UserPostEntity user);
//	List<UserPostEntity> findById_Post(int id);
	Page<UserPostEntity> findById_Post(String id, int page, int size);
}
