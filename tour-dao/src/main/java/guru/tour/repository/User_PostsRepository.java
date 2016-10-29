package guru.tour.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.PostEntity;
import guru.tour.entity.UserPostEntity;


public interface User_PostsRepository extends JpaRepository<UserPostEntity, String>{
//	public List<UserPostEntity> findByPost(PostEntity id);
	public Page<UserPostEntity> findByIdPost(String id_post, Pageable pageable);
}
