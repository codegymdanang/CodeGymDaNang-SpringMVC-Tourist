package guru.tour.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import guru.tour.entity.UserEntity;
import guru.tour.service.UserAttemptsManager;
import guru.tour.service.UserEntityManager;

public class UserServiceImpl implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserAttemptsManager attemptsManager;
	@Autowired
	UserEntityManager userManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userManager.getUserByName(username);
		if (userEntity == null)
			throw new UsernameNotFoundException("No such user: " + username);
		else {
			Account acc = new Account(userEntity);
			logger.info("========== User Info: ", acc.toString());
			if (!attemptsManager.isExists(username)&&attemptsManager.isTimeUp(attemptsManager.geAttemptsEntity(username).getLastModified()))
				attemptsManager.resetAttempts(username);
			return acc;
		}
	}
	
}
	


