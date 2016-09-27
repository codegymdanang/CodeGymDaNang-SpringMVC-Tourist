package guru.tour.entity;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail implements UserDetails{
	 private static final long serialVersionUID = 1L;
	    private UserEntity user;

	    Set<GrantedAuthority> authorities=null;

	    public UserEntity getUser() {
	        return user;
	    }

	    public void setUser(UserEntity user) {
	        this.user = user;
	    }

	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    public void setAuthorities(Set<GrantedAuthority> authorities)
	    {
	        this.authorities=authorities;
	    }

	    public String getPassword() {
	        return user.getPassword();
	    }

	    public String getUsername() {
	        return user.getUsername();
	    }

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}


}
