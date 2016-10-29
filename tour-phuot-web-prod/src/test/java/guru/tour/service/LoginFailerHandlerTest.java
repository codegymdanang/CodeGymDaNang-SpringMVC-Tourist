package guru.tour.service;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import guru.tour.security.LoginFailureHandler;

@RunWith(MockitoJUnitRunner.class)
public class LoginFailerHandlerTest {

	@Mock
	UserAttemptsManager attemptsManager;

	@Mock
	UserEntityManager userManager;
	
	@InjectMocks
	LoginFailureHandler loginFailureHandler = new LoginFailureHandler();
	
	@Test
	public void ShouldReturnNullWhenGetUserByName(){
		when(userManager.getUserByName(anyString())).thenReturn(null);
		
		
	}
}
