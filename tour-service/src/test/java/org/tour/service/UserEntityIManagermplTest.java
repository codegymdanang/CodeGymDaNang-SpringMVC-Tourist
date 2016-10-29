package org.tour.service;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.security.crypto.password.PasswordEncoder;

import guru.tour.entity.UserEntity;
import guru.tour.repository.ServiceFriendsRepository;
import guru.tour.service.UserEntityManagerImpl;
import guru.tour.service.UserEntityManager;

@RunWith(MockitoJUnitRunner.class)
public class UserEntityIManagermplTest {

	//@Mock
	private PasswordEncoder passEncode;

	//@Mock
	private ServiceFriendsRepository friendsRepository;
	
	@InjectMocks
	private UserEntityManager userEntityIManager = new UserEntityManagerImpl();
	@Before
	public void initMocks() {
		passEncode = mock(PasswordEncoder.class);
		friendsRepository = mock(ServiceFriendsRepository.class);
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldEncodePassword() {
		
		when(passEncode.encode(any(CharSequence.class))).thenAnswer(new Answer<String>() {

			public String answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				String oldPassword = (String)invocation.getArguments()[0];
				if("plain".equals(oldPassword)) {
					return "encrypted";
				}
			
				return "abc";
			}
		});
		when(friendsRepository.save(any(UserEntity.class))).thenAnswer(new Answer<UserEntity>() {

			public UserEntity answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				return (UserEntity)invocation.getArguments()[0];
			}
		});
		UserEntity user = new UserEntity();
		user.setPassword("plain");
		
		UserEntity result = userEntityIManager.saveUser(user);
		Assertions.assertThat(result.getPassword()).isEqualTo("encrypted");
	}
	
	@Test
	public void shouldEncodePasswordVoidMethod() {
		
		when(passEncode.encode(any(CharSequence.class))).thenReturn("encrypted");
		
		UserEntity user = new UserEntity();
		user.setPassword("plain");
		ArgumentCaptor<UserEntity> usArgumentCaptor = ArgumentCaptor.forClass(UserEntity.class);	
		userEntityIManager.saveUser(user);
	
		verify(friendsRepository, times(1)).save(usArgumentCaptor.capture());
		
		UserEntity result = usArgumentCaptor.getValue();
		
		Assertions.assertThat(result.getPassword()).isEqualTo("encrypted");
		
	
	}
	
	@Test
	public void shouldReturnTrueIfUserExist() {
		
		when(friendsRepository.findAll()).thenReturn(prepareUserList());
//		when(friendsRepository.findAll()).thenAnswer(new Answer<List<UserEntity>>() {
//
//			public List<UserEntity> answer(InvocationOnMock invocation) throws Throwable {
//				// TODO Auto-generated method stub
//				return prepareUserList() ;
//			}
//		});
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("user2");
		boolean result = userEntityIManager.isUserExist(userEntity);
		Assertions.assertThat(result).isTrue();
	}

	private List<UserEntity> prepareUserList() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		UserEntity userEntity1 = new UserEntity();
		userEntity1.setUsername("user1");
		UserEntity userEntity2 = new UserEntity();
		userEntity2.setUsername("user2");
		
		users.add(userEntity1);
		users.add(userEntity2);
		return users;
	}
}
