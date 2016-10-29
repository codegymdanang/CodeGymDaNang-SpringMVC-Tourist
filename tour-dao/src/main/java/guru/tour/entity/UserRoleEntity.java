package guru.tour.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;


/**
 * The persistent class for the user_role database table.
 * 
 */
@Entity
@Table(name="user_role")
@NamedQuery(name="UserRoleEntity.findAll", query="SELECT u FROM UserRoleEntity u")
public class UserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();

	//bi-directional many-to-one association to RoleEntity
	@ManyToOne
	private RoleEntity role;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	private UserEntity user;

	public UserRoleEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RoleEntity getRole() {
		return this.role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public UserRoleEntity(RoleEntity role, UserEntity user) {
		super();
		this.role = role;
		this.user = user;
	}

}