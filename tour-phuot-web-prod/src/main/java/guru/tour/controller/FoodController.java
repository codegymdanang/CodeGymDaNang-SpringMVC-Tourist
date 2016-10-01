package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import guru.tour.entity.FoodEntity;
import guru.tour.model.FoodModel;
import guru.tour.service.FoodEntityManager;

@Controller
public class FoodController {
	@Autowired
	FoodEntityManager foodEntityManager;
	
	@RequestMapping(value = "/foodByLocationId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FoodModel>> listAllFoods() {
		List<FoodModel> list = foodEntityManager.getFoodByLocationId("2");
		if (list.isEmpty()) {
			return new ResponseEntity<List<FoodModel>>(
					HttpStatus.NO_CONTENT);// You many decide to return
											// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<FoodModel>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fooddata/{id}", method = RequestMethod.GET)
	public ResponseEntity<FoodEntity> getFood(@PathVariable("id") String id){
		System.out.println("Fetching Food with id " + id);
		FoodEntity hotnew = foodEntityManager.findById(id);
		if (hotnew == null) {
			System.out.println("Food with id " + id + " not found");
			return new ResponseEntity<FoodEntity>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FoodEntity>(hotnew, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fooddata/createFood", method = RequestMethod.POST)
	public ResponseEntity<Void> createFood(@RequestBody FoodEntity food,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Food " + food.getName());

		if (foodEntityManager.isFoodEntity(food)) {
			System.out.println("A FoodEntity with name " + food.getName()
					+ " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		foodEntityManager.saveFoodsEntity(food);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/fooddata/{id}")
				.buildAndExpand(food.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/updateFood/{id}", method = RequestMethod.PUT)
	public ResponseEntity<FoodEntity> updateHotnews(
			@PathVariable("id") String id, @RequestBody FoodEntity food) {
		System.out.println("Updating Food " + id);

		FoodEntity currentFood = foodEntityManager.findById(id);

		if (currentFood == null) {
			System.out.println("Food with id " + id + " not found");
			return new ResponseEntity<FoodEntity>(HttpStatus.NOT_FOUND);
		}

		currentFood.setName(food.getName());
		currentFood.setDescription(food.getDescription());
		currentFood.setLocation(food.getLocation());
		currentFood.setImages(food.getImages());
		currentFood.setPhone(food.getPhone());
		currentFood.setPrice(food.getPrice());

		foodEntityManager.updateFood(currentFood);
		return new ResponseEntity<FoodEntity>(currentFood, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fooddata/deleteFood/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<FoodEntity> deleteFood(@PathVariable("id") String id) {
		System.out.println("Fetching & Deleting Food with id " + id);

		FoodEntity user = foodEntityManager.findById(id);
		if (user == null) {
			System.out.println("Unable to delete. Food with id " + id
					+ " not found");
			return new ResponseEntity<FoodEntity>(HttpStatus.NOT_FOUND);
		}

		foodEntityManager.deleteFoodById(id);
		return new ResponseEntity<FoodEntity>(HttpStatus.NO_CONTENT);
	}
}
