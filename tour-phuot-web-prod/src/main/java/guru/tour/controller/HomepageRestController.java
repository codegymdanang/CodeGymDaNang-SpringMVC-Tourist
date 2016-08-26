package guru.tour.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import guru.tour.entity.HotNewsEntity;
import guru.tour.entity.LocationEntity;
import guru.tour.service.HotNewsEntityManager;
import guru.tour.service.LocationEntityManager;

@RestController
public class HomepageRestController {

	@Autowired
	HotNewsEntityManager hotNewsEntityManager;
	

	

	// -------------------Retrieve All
	// HotNews--------------------------------------------------------

	@RequestMapping(value = "/homedata/", method = RequestMethod.GET)
	public ResponseEntity<List<HotNewsEntity>> listAllHotnews() {
		List<HotNewsEntity> list = hotNewsEntityManager.getAllHotNews();
		if (list.isEmpty()) {
			return new ResponseEntity<List<HotNewsEntity>>(
					HttpStatus.NO_CONTENT);// You many decide to return
											// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<HotNewsEntity>>(list, HttpStatus.OK);
	}

	// -------------------Retrieve Single Hotnews Entity by
	// id--------------------------------------------------------

	@RequestMapping(value = "/homedata/{id}", method = RequestMethod.GET)
	public ResponseEntity<HotNewsEntity> getHotnew(@PathVariable("id") int id) {
		System.out.println("Fetching Hotnew with id " + id);
		HotNewsEntity hotnew = hotNewsEntityManager.findById(id);
		if (hotnew == null) {
			System.out.println("Hotnew with id " + id + " not found");
			return new ResponseEntity<HotNewsEntity>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HotNewsEntity>(hotnew, HttpStatus.OK);
	}

	// -------------------Create a
	// Hotnew--------------------------------------------------------

	@RequestMapping(value = "/homedata/createHotnew", method = RequestMethod.POST)
	public ResponseEntity<Void> createHotnew(@RequestBody HotNewsEntity hotnew,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Hotnew " + hotnew.getName());

		if (hotNewsEntityManager.isHotNewsEntity(hotnew)) {
			System.out.println("A HotnewEntity with name " + hotnew.getName()
					+ " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		hotNewsEntityManager.saveHotNewsEntity(hotnew);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/homedata/{id}")
				.buildAndExpand(hotnew.getHotnewsId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User
	// --------------------------------------------------------

	@RequestMapping(value = "/homedata/updateHotnew/{id}", method = RequestMethod.PUT)
	public ResponseEntity<HotNewsEntity> updateHotnews(
			@PathVariable("id") int id, @RequestBody HotNewsEntity hotnew) {
		System.out.println("Updating Hotnew " + id);

		HotNewsEntity currentHotnew = hotNewsEntityManager.findById(id);

		if (currentHotnew == null) {
			System.out.println("Hotnew with id " + id + " not found");
			return new ResponseEntity<HotNewsEntity>(HttpStatus.NOT_FOUND);
		}

		currentHotnew.setName(hotnew.getName());
		currentHotnew.setDescription(hotnew.getDescription());
		currentHotnew.setImage(hotnew.getImage());

		hotNewsEntityManager.updateHotnew(currentHotnew);
		return new ResponseEntity<HotNewsEntity>(currentHotnew, HttpStatus.OK);
	}

	// ------------------- Delete a User
	// --------------------------------------------------------

	@RequestMapping(value = "/homedata/deleteHotnew/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HotNewsEntity> deleteHotnew(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Hotnew with id " + id);

		HotNewsEntity user = hotNewsEntityManager.findById(id);
		if (user == null) {
			System.out.println("Unable to delete. Hotnew with id " + id
					+ " not found");
			return new ResponseEntity<HotNewsEntity>(HttpStatus.NOT_FOUND);
		}

		hotNewsEntityManager.deleteHotnewById(id);
		return new ResponseEntity<HotNewsEntity>(HttpStatus.NO_CONTENT);
	}


}
