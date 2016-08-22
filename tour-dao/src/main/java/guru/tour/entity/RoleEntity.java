package guru.tour.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "role")
	private String role;

	public RoleEntity(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public RoleEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<UserEntity> users;
//
//	public List<UserEntity> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(List<UserEntity> employees) {
//		this.employees = employees;
//	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
}
