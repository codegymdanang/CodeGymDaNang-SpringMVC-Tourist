package guru.tour.controller;

import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import guru.tour.entity.HotNewEntity;
import guru.tour.service.HotNewsEntityManager;

@RunWith(MockitoJUnitRunner.class)
public class HomepageRestControllerTest {

	@Mock
	private HotNewsEntityManager hotNewsEntityManager;

	@InjectMocks
	private HomepageRestController homepageRestController = new HomepageRestController();

	@Test()
	public void shouldReturnNoContentWhenListEmpty() {
		Mockito.when(hotNewsEntityManager.getAllHotNews()).thenReturn(new ArrayList<HotNewEntity>());

		ResponseEntity<List<HotNewEntity>> response = homepageRestController.listAllHotnews();
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

	}

	@Test()
	public void shouldReturnContentWhenListNotEmpty() {

		Mockito.when(hotNewsEntityManager.getAllHotNews()).thenReturn(prepareHostNewsList());

		ResponseEntity<List<HotNewEntity>> response = homepageRestController.listAllHotnews();
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).hasSize(1);

	}

	private List<HotNewEntity> prepareHostNewsList() {
		List<HotNewEntity> hotNewEntities = new ArrayList<>();
		HotNewEntity hostNewEntity = new HotNewEntity();
		hotNewEntities.add(hostNewEntity);
		return hotNewEntities;
	}
}
