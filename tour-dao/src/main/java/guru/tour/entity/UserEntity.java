package guru.tour.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private String id = UUID.randomUUID().toString();
	
	@Column
	private String comment;
	
	@Column
	private String diadiem;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="accountNonExpired")
	private boolean accountNonExpired;
	
	@Column(name="accountNonLocked")
	private boolean accountNonLocked;
	
	@Column(name="credentialsNonExpired")
	private boolean credentialsNonExpired;
	
	@Column(name="image")
	private String image;

	@Column
	private String password;
	
	@Column(name="phone")
	private String phone;
	
	@Column
	private String username;
	
	@OneToMany(mappedBy="user")
	private List<CommentEntity> comments;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="user_role"
		, joinColumns={
			@JoinColumn(name="user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id")
			}
		)
	private List<RoleEntity> roles =new ArrayList<RoleEntity>();
	public List<RoleEntity> getRoles() {
		return roles;
	}

	//bi-directional many-to-one association to UserPostEntity
	@OneToMany(mappedBy="user")
	private List<UserPostEntity> userPosts;

	//bi-directional many-to-one association to User_RoleEntity
	@OneToMany(mappedBy="user")
	private List<User_RoleEntity> userRoles;

	//bi-directional many-to-one association to UserScheduleEntity
	@OneToMany(mappedBy="user")
	private List<UserSchedule> userschedules;

	public UserEntity() {
	}
	
	public UserEntity(String username, String password, String image, String phone) {
		this.username = username;
		this.password = password;
		this.image = image;
		this.phone = phone;
	}
	
	public UserEntity(boolean enabled, String password, String username, List<RoleEntity> roles) {
		super();
		this.enabled = enabled;
		this.password = password;
		this.username = username;
		this.roles = roles;
	}

	public UserEntity(String username, String image, String phone, String diadiem,int a) {
		super();
		this.username = username;
		this.image = image;
		this.phone = phone;
		this.diadiem = diadiem;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
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

	public List<CommentEntity> getComments() {
		return this.comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public CommentEntity addComment(CommentEntity comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public CommentEntity removeComment(CommentEntity comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
	}

	public List<UserPostEntity> getUserPosts() {
		return this.userPosts;
	}
	
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	public void setUserPosts(List<UserPostEntity> userPosts) {
		this.userPosts = userPosts;
	}

	public UserPostEntity addUserPost(UserPostEntity userPost) {
		getUserPosts().add(userPost);
		userPost.setUser(this);

		return userPost;
	}

	public UserPostEntity removeUserPost(UserPostEntity userPost) {
		getUserPosts().remove(userPost);
		userPost.setUser(null);

		return userPost;
	}

	public List<User_RoleEntity> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<User_RoleEntity> userRoles) {
		this.userRoles = userRoles;
	}

	public User_RoleEntity addUserRole(User_RoleEntity userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public User_RoleEntity removeUserRole(User_RoleEntity userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

	public List<UserSchedule> getUserschedules() {
		return this.userschedules;
	}

	public void setUserschedules(List<UserSchedule> userschedules) {
		this.userschedules = userschedules;
	}

	public UserSchedule addUserschedule(UserSchedule userschedule) {
		getUserschedules().add(userschedule);
		userschedule.setUser(this);

		return userschedule;
	}

	public UserSchedule removeUserschedule(UserSchedule userschedule) {
		getUserschedules().remove(userschedule);
		userschedule.setUser(null);

		return userschedule;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	
}