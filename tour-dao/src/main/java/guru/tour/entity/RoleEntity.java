package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="RoleEntity.findAll", query="SELECT r FROM RoleEntity r")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String role;
	
	public RoleEntity(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	//bi-directional many-to-many association to UserEntity
	@ManyToMany(mappedBy="roles")
//	@JoinTable(
//		name="user_role"
//		, joinColumns={
//			@JoinColumn(name="role_id")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="user_id")
//			}
//		)
	private List<UserEntity> users = new ArrayList<UserEntity>();

	public RoleEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<UserEntity> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

}