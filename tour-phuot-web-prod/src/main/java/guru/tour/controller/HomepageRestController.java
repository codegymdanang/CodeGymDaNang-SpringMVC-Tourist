package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import guru.tour.entity.HotNewEntity;
import guru.tour.entity.PlaceEntity;
import guru.tour.entity.UserScheduleEntity;
import guru.tour.model.UserScheduleModel;
import guru.tour.service.HotNewsEntityManager;
import guru.tour.service.PlaceEntityManager;
import guru.tour.service.UserScheduleEntityManager;

@RestController
public class HomepageRestController {

	@Autowired
	HotNewsEntityManager hotNewsEntityManager;

	@Autowired
	UserScheduleEntityManager userScheduleEnityManager;

	// -------------------Retrieve All
	// HotNews--------------------------------------------------------

	@RequestMapping(value = "/homedata/", method = RequestMethod.GET)
	public ResponseEntity<List<HotNewEntity>> listAllHotnews() {
		List<HotNewEntity> list = hotNewsEntityManager.getAllHotNews();
		if (list.isEmpty()) {
			return new ResponseEntity<List<HotNewEntity>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HotNewEntity>>(list, HttpStatus.OK);
	}

	// -------------------Retrieve Single Hotnews Entity by
	// id--------------------------------------------------------

	@RequestMapping(value = "/homedata/{id}", method = RequestMethod.GET)
	public ResponseEntity<HotNewEntity> getHotnew(@PathVariable("id") String id) {
		System.out.println("Fetching Hotnew with id " + id);
		HotNewEntity hotnew = hotNewsEntityManager.findByHotnewsId(id);
		if (hotnew == null) {
			System.out.println("Hotnew with id " + id + " not found");
			return new ResponseEntity<HotNewEntity>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HotNewEntity>(hotnew, HttpStatus.OK);
	}

	// -------------------Create a
	// Hotnew--------------------------------------------------------

	@RequestMapping(value = "/homedata/createHotnew", method = RequestMethod.POST)
	public ResponseEntity<Void> createHotnew(@RequestBody HotNewEntity hotnew, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Hotnew " + hotnew.getName());

		if (hotNewsEntityManager.isHotNewsEntity(hotnew)) {
			System.out.println("A HotnewEntity with name " + hotnew.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		hotNewsEntityManager.saveHotNewsEntity(hotnew);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/homedata/{id}").buildAndExpand(hotnew.getHotnewsId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User
	// --------------------------------------------------------

	@RequestMapping(value = "/homedata/updateHotnew/{id}", method = RequestMethod.PUT)
	public ResponseEntity<HotNewEntity> updateHotnews(@PathVariable("id") String id, @RequestBody HotNewEntity hotnew) {
		System.out.println("Updating Hotnew " + id);

		HotNewEntity currentHotnew = hotNewsEntityManager.findByHotnewsId(id);

		if (currentHotnew == null) {
			System.out.println("Hotnew with id " + id + " not found");
			return new ResponseEntity<HotNewEntity>(HttpStatus.NOT_FOUND);
		}

		currentHotnew.setName(hotnew.getName());
		currentHotnew.setDescription(hotnew.getDescription());
		currentHotnew.setImage(hotnew.getImage());

		hotNewsEntityManager.updateHotnew(currentHotnew);
		return new ResponseEntity<HotNewEntity>(currentHotnew, HttpStatus.OK);
	}

	// ------------------- Delete a User
	// --------------------------------------------------------

	@RequestMapping(value = "/homedata/deleteHotnew/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HotNewEntity> deleteHotnew(@PathVariable("id") String id) {
		System.out.println("Fetching & Deleting Hotnew with id " + id);

		HotNewEntity user = hotNewsEntityManager.findByHotnewsId(id);
		if (user == null) {
			System.out.println("Unable to delete. Hotnew with id " + id + " not found");
			return new ResponseEntity<HotNewEntity>(HttpStatus.NOT_FOUND);
		}

		hotNewsEntityManager.deleteHotnewById(id);
		return new ResponseEntity<HotNewEntity>(HttpStatus.NO_CONTENT);
	}

	@Autowired
	PlaceEntityManager placeEntityManager;

	@RequestMapping(value = "/homedata/like", method = RequestMethod.POST)
	public ResponseEntity<Void> like(@RequestBody UserScheduleModel userScheduleModel, UriComponentsBuilder ucBuilder) {
		UserScheduleModel temp = userScheduleModel;
		System.out.println("-----------" + userScheduleModel.getPlace_id());
		PlaceEntity placeEntity = placeEntityManager.getPlaceByID(userScheduleModel.getPlace_id());

		if (placeEntity != null) {
			System.out.println("Kiem tra thay place ton tai");
			UserScheduleEntity userSchedule = new UserScheduleEntity(placeEntity, userScheduleModel.getStatus());
			userScheduleEnityManager.saveUserScheduleEntity(userSchedule);
			System.out.println("okkkkkkkkk");
		}

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
