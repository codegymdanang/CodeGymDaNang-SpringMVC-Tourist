package guru.tour.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "comment")
	private String comment;
	
	@Column(name = "diadiem")
	private String diadiem;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userEntity",cascade=CascadeType.ALL)
	/*@JsonBackReference*/

	@LazyCollection(LazyCollectionOption.FALSE) 
	@JsonIgnore
	private List<RatingEntity> list=new ArrayList<RatingEntity>();
	
	//bi-directional many-to-one association to UserSchedule
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.LAZY)				
	private List<UserSchedule> userSchedules;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
		
		
	public List<RatingEntity> getList() {
		return list;
	}

	public void setList(List<RatingEntity> list) {
		this.list = list;
	}
	
	
		public List<UserSchedule> getUserSchedules() {
			return userSchedules;
		}

		public void setUserSchedules(List<UserSchedule> userSchedules) {
			this.userSchedules = userSchedules;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDiadiem() {
		return diadiem;
	}

	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}

	public UserEntity(int id, String username, String password, String image, String phone, String diadiem,
			List<RatingEntity> list, List<RoleEntity> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.image = image;
		this.phone = phone;
		this.diadiem = diadiem;
		this.list = list;
		this.roles = roles;
	}

	public UserEntity(String username, String password, String image, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.image = image;
		this.phone = phone;
	}
	
	public UserEntity(String username, String password, String image, String phone,String diadiem) {
		super();
		this.username = username;
		this.password = password;
		this.image = image;
		this.phone = phone;
		this.diadiem =diadiem;
	}
	
	
	public UserEntity(String username, String image, String phone, String diadiem,int a) {
		super();
		this.username = username;
		this.image = image;
		this.phone = phone;
		this.diadiem = diadiem;
	}

	public UserEntity() {
		// TODO Auto-generated constructor stub
	}
	
	@ManyToMany(mappedBy = "users",  fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<RoleEntity> roles;


	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user",cascade=CascadeType.ALL)
//	/*@JsonBackReference*/
//	@JsonIgnore
//	private List<User_RoleEntity> lists=new ArrayList<User_RoleEntity>();
//	
	
}
