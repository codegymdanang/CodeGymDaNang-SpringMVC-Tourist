package test;

import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import guru.tour.repository.UserAttemptsRepository;
import guru.tour.service.UserAttemptsManager;
import guru.tour.service.UserAttemptsManagerImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserAttemptsManagerImplTest {

	@Mock
	private UserAttemptsManager userAttemptsManager;
	
	@Mock
	private UserAttemptsRepository userAttemptsRepository;
	
	@InjectMocks
	private UserAttemptsManagerImpl userAttemptsManagerImpl;
	
	static long valueReturn = 1;
	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		attemptsList = new ArrayList<User_AttemptsEntity>();
//		attemptsList.add(new User_AttemptsEntity("bin", 1));
//	}
	
	@Test()
	public void shouldReturnAccountAttemptFailWhenUserAttemptsManagerCallIsExits() {
		when(userAttemptsRepository.countAttempts(anyString())).thenReturn(valueReturn);
		userAttemptsManagerImpl.isExists(anyString());
	}

}
