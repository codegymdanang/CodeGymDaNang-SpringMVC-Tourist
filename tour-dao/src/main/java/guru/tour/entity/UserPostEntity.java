package guru.tour.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;


/**
 * The persistent class for the user_posts database table.
 * 
 */
@Entity
@Table(name="user_posts")
@NamedQuery(name="UserPostEntity.findAll", query="SELECT u FROM UserPostEntity u")
public class UserPostEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "id_user")
	private String id_user;
	
	@Column(name = "id_post")
	private String idPost;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "datetime")
	private Date datetime;
	

	public UserPostEntity(String id_user, String idPost, String comment, Date datetime) {
		super();
		this.id_user = id_user;
		this.idPost = idPost;
		this.comment = comment;
		this.datetime = datetime;
	}

	public UserPostEntity(String id, String id_user, String id_post, String comment) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.idPost = id_post;
		this.comment = comment;
	}

	
	
	public UserPostEntity() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getId_post() {
		return idPost;
	}

	public void setId_post(String id_post) {
		this.idPost = id_post;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIdPost() {
		return idPost;
	}

	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}

	public Date getDatetime() {
		return datetime;
	}
	
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}