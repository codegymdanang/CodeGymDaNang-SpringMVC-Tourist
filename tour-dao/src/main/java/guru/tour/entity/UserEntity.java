package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;

import guru.tour.validator.Phone;

import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="diadiem")
	private String diadiem;
	
	@Column(name="enabled")
	private byte enabled;
	
	@Column(name="image")
	private String image;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phone")
	@Phone
	private String phone;
	
	@Column(name="username")
	private String username;

	//bi-directional many-to-one association to RatingEntity
	@OneToMany(mappedBy="user")
	private List<RatingEntity> ratings;

	//bi-directional many-to-many association to RoleEntity
	@ManyToMany
	@JoinTable(
		name="user_role"
		, joinColumns={
			@JoinColumn(name="user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id")
			}
		)
	private List<RoleEntity> roles;

	public UserEntity() {
	}
	
	public UserEntity(String username, String password, String image, String phone) {
		this.username = username;
		this.password = password;
		this.image = image;
		this.phone = phone;
	}
	
	public UserEntity(String username, String image, String phone, String diadiem,int a) {
		super();
		this.username = username;
		this.image = image;
		this.phone = phone;
		this.diadiem = diadiem;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDiadiem() {
		return this.diadiem;
	}

	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<RatingEntity> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<RatingEntity> ratings) {
		this.ratings = ratings;
	}

	public RatingEntity addRating(RatingEntity rating) {
		getRatings().add(rating);
		rating.setUser(this);

		return rating;
	}

	public RatingEntity removeRating(RatingEntity rating) {
		getRatings().remove(rating);
		rating.setUser(null);

		return rating;
	}

	public List<RoleEntity> getRoles() {
		return this.roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

}