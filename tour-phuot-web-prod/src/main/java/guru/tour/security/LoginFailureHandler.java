package guru.tour.security;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import guru.tour.entity.User_AttemptsEntity;
import guru.tour.service.UserAttemptsManager;
import guru.tour.service.UserEntityManager;


public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	UserAttemptsManager attemptsManager;

	@Autowired
	UserEntityManager userManager;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String name = request.getParameter("username");
		User_AttemptsEntity user = attemptsManager.geAttemptsEntity(name);
		if (userManager.getUserByName(name) == null)
			exception = new BadCredentialsException("Username or Password wrong");
		else if (!attemptsManager.isExists(name))
			attemptsManager.insertAttempts(name);
		else if (user.getAttempts() >= 3) {
			if (attemptsManager.isTimeUp(user.getLastModified())){
				attemptsManager.resetAttempts(name);
				exception = new LockedException("Account is Unlocked ,Please Login Again ");
			}
			else {
				attemptsManager.lockUser(name);
				exception = new LockedException("Account is Locked from " +  new SimpleDateFormat("HH:mm dd-MM-yyyy").format(user.getLastModified()));
			}
		} else {
			attemptsManager.updateAttempts(name);
			exception = new BadCredentialsException("Username or Password wrong");
		}
		
		
		exception.printStackTrace();
		super.onAuthenticationFailure(request, response, exception);
	}
	
}
