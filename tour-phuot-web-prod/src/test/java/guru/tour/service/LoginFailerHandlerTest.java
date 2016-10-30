package guru.tour.service;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;

import guru.tour.entity.UserAttemptEntity;
import guru.tour.security.LoginFailureHandler;

@RunWith(MockitoJUnitRunner.class)
public class LoginFailerHandlerTest {

	@Mock
	UserAttemptsManager attemptsManager;

	@Mock
	UserEntityManager userManager;
	
	@Mock
	HttpServletRequest request ;

	@Mock
	HttpServletResponse response ;
		
	@Mock
	AuthenticationException exception ;
	
	@Mock 
	UserAttemptEntity userAttempts;
	
	@InjectMocks
	LoginFailureHandler loginFailureHandler = new LoginFailureHandler();
	
	
	@Test()
	public void ExceptionShouldBeBadCredentialsWhenGetUserByNameEqualsNull() throws IOException, ServletException{
		when(userManager.getUserByName(anyString())).thenReturn(null);
		loginFailureHandler.onAuthenticationFailure(request, response, exception);
		Assertions.assertThat(exception.equals(new BadCredentialsException("Username or Password wrong")));
	}
	
	@Test()
	public void ExceptionShouldBeBadCredentialsExceptionWhenUserIsExistInUserAttempts() throws IOException, ServletException{
		when(attemptsManager.isExists("UserName")).thenReturn(false);
		attemptsManager.insertAttempts("UserName");
		verify(attemptsManager,times(1)).insertAttempts("UserName");
		loginFailureHandler.onAuthenticationFailure(request, response, exception);
		Assertions.assertThat(exception.equals(new BadCredentialsException("Username or Password wrong")));
	}
	
	@Test()
	public void ExceptionShouldBeLockedExceptionWhenGetUserAttemptsGreaterThanOrEqualThree() throws IOException, ServletException{
		when(userAttempts.getAttempts()).thenReturn(3);
		attemptsManager.lockUser("UserName");
		verify(attemptsManager,times(1)).lockUser("UserName");
		loginFailureHandler.onAuthenticationFailure(request, response, exception);
		Assertions.assertThat(exception.equals(new LockedException("Account is Locked from  ....")));
	}
	
	@Test()
	public void ExceptionShouldBeBadCredentialsExceptionGetUserAttemptsLowerThanThree() throws IOException, ServletException{
		when(userAttempts.getAttempts()).thenReturn(2);
		attemptsManager.updateAttempts("UserName");
		verify(attemptsManager,times(1)).updateAttempts("UserName");
		loginFailureHandler.onAuthenticationFailure(request, response, exception);
		Assertions.assertThat(exception.equals(new BadCredentialsException("Username or Password wrong")));
	}
}
















