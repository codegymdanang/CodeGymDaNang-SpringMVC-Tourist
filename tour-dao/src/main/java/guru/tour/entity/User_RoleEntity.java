package guru.tour.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class User_RoleEntity implements Serializable{
	private RoleEntity role;
	

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@Id
    @ManyToOne
    @JoinColumn(name = "role_id")
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
}
