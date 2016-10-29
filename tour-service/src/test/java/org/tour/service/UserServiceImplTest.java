package org.tour.service;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import guru.tour.entity.RoleEntity;
import guru.tour.entity.UserEntity;
import guru.tour.service.UserEntityManager;
import guru.tour.user.UserServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@Mock
	UserEntityManager userManager;
	
	@InjectMocks
	UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	static List<RoleEntity> roleList;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		roleList = new ArrayList<RoleEntity>();
		roleList.add(new RoleEntity("1", "ROLE_ADMIN"));
	}

	
	@Test(expected=UsernameNotFoundException.class)
	public void shouldReturnExceptionWhenUserManagerCallGetUserByUserName(){
		when(userManager.getUserByName(anyString())).thenReturn(null);
		userServiceImpl.loadUserByUsername("binbinbin");
	}
	
	@Test
	public void shouldReturnAccountModelWhenUserManagerCallGetUserByUserName(){
		when(userManager.getUserByName(anyString())).thenReturn(prepareUserEntity());
		UserEntity expected = prepareUserEntity();
		Assertions.assertThat(expected.equals(userManager.getUserByName(anyString())));
		verify(userManager,times(1)).getUserByName(anyString());
		userServiceImpl.loadUserByUsername("duy");
	}
	
	private UserEntity prepareUserEntity(){
		return new UserEntity(true, "13123", "duy", roleList);
	}
}
