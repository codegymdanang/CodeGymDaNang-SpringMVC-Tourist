package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_role database table.
 * 
 */
@Entity
@Table(name="user_role")
@NamedQuery(name="User_RoleEntity.findAll", query="SELECT u FROM User_RoleEntity u")
public class User_RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	//bi-directional many-to-one association to RoleEntity
	@ManyToOne
	private RoleEntity role;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	private UserEntity user;

	public User_RoleEntity() {
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

}