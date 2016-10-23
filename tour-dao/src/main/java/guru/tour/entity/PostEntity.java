package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the posts database table.
 * 
 */
@Entity
@Table(name="posts")
@NamedQuery(name="PostEntity.findAll", query="SELECT p FROM PostEntity p")
public class PostEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id  = UUID.randomUUID().toString();

	private String name;

	//bi-directional many-to-one association to UserPostEntity
//	@OneToMany(mappedBy="post")
	private List<UserPostEntity> userPosts;

	public PostEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserPostEntity> getUserPosts() {
		return this.userPosts;
	}

	public void setUserPosts(List<UserPostEntity> userPosts) {
		this.userPosts = userPosts;
	}

	public UserPostEntity addUserPost(UserPostEntity userPost) {
		getUserPosts().add(userPost);
		userPost.setPost(this);

		return userPost;
	}

	public UserPostEntity removeUserPost(UserPostEntity userPost) {
		getUserPosts().remove(userPost);
		userPost.setPost(null);

		return userPost;
	}

}