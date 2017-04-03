package guru.tour.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import guru.tour.entity.RoleEntity;
import guru.tour.entity.UserEntity;
@SuppressWarnings({ "serial" })
public class Account implements UserDetails{
	
	UserEntity user;
	
	public Account(UserEntity user) {
		super();
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	    for (RoleEntity r :user.getRoles()) {
	        authorities.add(new SimpleGrantedAuthority(r.getRole()));
	    }
	    return authorities;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}


	@Override
	public String toString() {
		return "Account [user=" + user + ", getAuthorities()= " + getAuthorities()
				+ ", getPassword()=" + getPassword() + ", getUsername()=" + getUsername() + ", isAccountNonExpired()="
				+ isAccountNonExpired() + ", isAccountNonLocked()=" + isAccountNonLocked()
				+ ", isCredentialsNonExpired()=" + isCredentialsNonExpired() + ", isEnabled()=" + isEnabled() + "]";
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

    
    
    
}
