package guru.tour.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.Assertions;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import guru.tour.entity.FoodEntity;
import guru.tour.model.FoodModel;
import guru.tour.service.FoodEntityManager;

@RunWith(MockitoJUnitRunner.class)
public class FoodControllerTest {
	
	@Mock
	private FoodEntityManager foodEntityManager;

	@InjectMocks
	private FoodController foodController = new FoodController();
	
	@Before
	public void initMocks() {
		foodEntities = new ArrayList<>();
		FoodEntity foodEntity1 = new FoodEntity();
		foodEntity1.setId("1");
		foodEntity1.setName("F1");

		FoodEntity foodEntity2 = new FoodEntity();
		foodEntity2.setId("2");
		foodEntity2.setName("F2");
		foodEntities.add(foodEntity1);
		foodEntities.add(foodEntity2);
	}
	
	@Test
	public void shouldReturnNoContentWhenFoodEntityNull() {
		
		when(foodEntityManager.getFoodByLocationId("3")).thenReturn(null);
		
		ResponseEntity<List<FoodModel>> response = foodController.listAllFoods();
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}
	
	@Test
	public void shouldReturnNotFoundWhenFoodEntityNull() {
		
		when(foodEntityManager.findById(anyString())).thenReturn(null);
		
		ResponseEntity<FoodEntity> response = foodController.updateHotnews("1", prepareFoodEntity());
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void shouldReturnNotFoundWhenFoodNullDelete(){
		when(foodEntityManager.findById(anyString())).thenReturn(null);
		ResponseEntity<FoodEntity> response = foodController.deleteFood("1");
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	private List<FoodEntity> foodEntities;
	@Test
	public void shouldReturnFoodWhenHasFoodEntityInDatabase() {
		FoodEntity foodEntityInDB = new FoodEntity();
		foodEntityInDB.setName("Old Name");
		
//		when(foodEntityManager.findById(1)).thenReturn(new FoodEntity());
//		when(foodEntityManager.findById(2)).thenReturn(new FoodEntity());
//		
		when(foodEntityManager.findById(anyString())).thenAnswer(new Answer<FoodEntity>() {

			@Override
			public FoodEntity answer(InvocationOnMock invocation) throws Throwable {
				String id = (String)invocation.getArguments()[0];
				for(FoodEntity foodEntity : foodEntities) {
					if(String.valueOf(foodEntity.getId()) == id) {
						return foodEntity;
					}
				}
				return null;
			}
		});
		ArgumentCaptor<FoodEntity> foodEntityArgumentCaptor = ArgumentCaptor.forClass(FoodEntity.class);
		ResponseEntity<FoodEntity> response = foodController.updateHotnews("1", prepareFoodEntity());
		verify(foodEntityManager, times(1)).updateFood(foodEntityArgumentCaptor.capture());
		
		FoodEntity saveFoodEntity = foodEntityArgumentCaptor.getValue();
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody().getName()).isEqualTo("U Name");
		Assertions.assertThat(saveFoodEntity.getName()).isEqualTo("U Name");
	}
	private FoodEntity prepareFoodEntity() {
		FoodEntity foodEntity = new FoodEntity();
		foodEntity.setDescription("U Des");
		foodEntity.setName("U Name");
		return foodEntity;
	}
}
