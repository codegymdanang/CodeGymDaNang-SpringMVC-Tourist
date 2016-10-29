package org.tour.service;


import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import guru.tour.entity.UserAttemptEntity;
import guru.tour.repository.ServiceFriendsRepository;
import guru.tour.repository.UserAttemptsRepository;
import guru.tour.service.UserAttemptsManager;
import guru.tour.service.UserAttemptsManagerImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserAttemptsManagerImplTest {
	
	@Mock
	ServiceFriendsRepository friendsRepository;
	
	@Mock
	UserAttemptsRepository userAttemptsRepository;
	
	@InjectMocks
	UserAttemptsManager attemptsManager = new UserAttemptsManagerImpl();
	
	@Test
	public void shouldSaveTheUserAttempts(){
		ArgumentCaptor<UserAttemptEntity> usArgumentCaptor = ArgumentCaptor.forClass(UserAttemptEntity.class);	
		attemptsManager.insertAttempts(prepareEntity().getUsername());
	
		verify(userAttemptsRepository, times(1)).save(usArgumentCaptor.capture());
		
		UserAttemptEntity result = usArgumentCaptor.getValue();
		
		Assertions.assertThat(result.equals(prepareEntity()));
		
	}
	
	@Test 
	public void shouldUpdateTheUserAttempts(){
		ArgumentCaptor<String> usArgumentCaptor = ArgumentCaptor.forClass(String.class);	
		attemptsManager.updateAttempts("bin");
	
		verify(userAttemptsRepository, times(1)).updateAttempts(usArgumentCaptor.capture());
		
		String result = usArgumentCaptor.getValue();
		
		Assertions.assertThat(result.equals(prepareEntity().getUsername()));
	}
	
	@Test
	public void ShouldReturnUserAttempts(){
		when(userAttemptsRepository.findByUsername(anyString())).thenReturn(new UserAttemptEntity("bin", 2, new Date()));
		
		UserAttemptEntity user = attemptsManager.geAttemptsEntity("bin");
		
		Assertions.assertThat(user.equals(prepareEntity()));
	}
	
	private UserAttemptEntity prepareEntity(){
		return new UserAttemptEntity("bin", 2, new Date());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
