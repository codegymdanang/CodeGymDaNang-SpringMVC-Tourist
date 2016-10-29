package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


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
	private String id = UUID.randomUUID().toString();

	private String role;

	//bi-directional many-to-one association to UserRoleEntity
	@ManyToMany(mappedBy="roles", fetch = FetchType.LAZY)
	private List<UserEntity> users;

	public RoleEntity() {
	}

	/**
     * @param string
     * @param string2
     */
    public RoleEntity(String id, String name) {
        this.id = id;
        this.role = name;
    }

    public RoleEntity(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

}