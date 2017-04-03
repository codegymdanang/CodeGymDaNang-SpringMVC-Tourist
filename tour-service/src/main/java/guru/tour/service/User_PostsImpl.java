package guru.tour.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import guru.tour.entity.UserPostEntity;
import guru.tour.repository.User_PostsRepository;

@Service
public class User_PostsImpl implements User_PostsManager{

	@Autowired
	User_PostsRepository user_posts;
	public UserPostEntity saveUser_Posts(UserPostEntity user) {
		// TODO Auto-generated method 
		return user_posts.save(new UserPostEntity(user.getId_user(), user.getId_post(), user.getComment(), new Date()));
	}
	/*public List<UserPostEntity> findById_Post(d id) {
		// TODO Auto-generated method stub
		return user_posts.findByIdPost(id);
	}*/
	
	@Override
	public Page<UserPostEntity> findById_Post(String id, int page, int size) {
		// TODO Auto-generated method stub
		return user_posts.findByIdPost(id, new PageRequest(page, size,Sort.Direction.ASC,"datetime"));
	}
	
}
