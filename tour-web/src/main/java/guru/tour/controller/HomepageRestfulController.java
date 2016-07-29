package guru.tour.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guru.tour.entity.HotNewsEntity;
import guru.tour.exception.HomeException;
import guru.tour.service.HotNewsEntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

public class HomepageRestfulController {

	@RestController
	@RequestMapping(value = "/")
	public class HomepageController {

		@Autowired
		HotNewsEntityManager hotnews;

		// -------------------Retrieve All
		// HotnewsEntity--------------------------------------------------------

		@RequestMapping(value = "/homedata", method = RequestMethod.GET)
		public ResponseEntity<List<HotNewsEntity>> listAllUsers() {
			List<HotNewsEntity> listhotnews = hotnews.getAllHotNews();
			if (listhotnews.isEmpty()) {
				return new ResponseEntity<List<HotNewsEntity>>(
						HttpStatus.NO_CONTENT);// You many decide to return
												// HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<HotNewsEntity>>(listhotnews,
					HttpStatus.OK);
		}

		// -------------------Retrieve Single
		// HotnewsEntity--------------------------------------------------------

		@RequestMapping(value = "/homedata/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<HotNewsEntity> getUser(@PathVariable("id") int id) {
			System.out.println("Fetching User with id " + id);
			HotNewsEntity hotnew = hotnews.findById(id);
			if (hotnew == null) {
				System.out.println("User with id " + id + " not found");
				return new ResponseEntity<HotNewsEntity>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<HotNewsEntity>(hotnew, HttpStatus.OK);
		}

		// -------------------Create a
		// HotnewsEntity--------------------------------------------------------

		@RequestMapping(value = "/homedata/create", method = RequestMethod.POST)
		public ResponseEntity<Void> createUser(
				@RequestBody HotNewsEntity hotnew,
				UriComponentsBuilder ucBuilder) {
			System.out.println("Creating User " + hotnew.getName());

			if (hotnews.isUserExist(hotnew)) {
				System.out.println("A User with name " + hotnew.getName()
						+ " already exist");
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}

			hotnews.saveHotNewsEntity(hotnew);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/homedata/{id}")
					.buildAndExpand(hotnew.getHotnewsId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}

		@RequestMapping(value = "/home", method = RequestMethod.GET)
		public String homepage() throws Exception {
			List<HotNewsEntity> list = new ArrayList<HotNewsEntity>();
			list = hotnews.getAllHotNews();
			if (list.isEmpty() == true) {
				throw new HomeException(1);
			}

			return "homePage";
		}

		@RequestMapping(value = "/home/{id}", method = RequestMethod.GET)
		public String getEmployee(@PathVariable("id") int id, Model model)
				throws Exception {
			// deliberately throwing different types of exception
			if (id == 1) {
				throw new HomeException(id);
			} else if (id == 2) {
				throw new SQLException("SQLException, id=" + id);
			} else if (id == 3) {
				throw new IOException("IOException, id=" + id);
			} else if (id == 10) {
				List<HotNewsEntity> list = new ArrayList<HotNewsEntity>();
				list = hotnews.getAllHotNews();
				if (list.isEmpty() == true) {
					throw new HomeException(1);
				}
				return "homePage";
			} else {
				throw new Exception("Generic Exception, id=" + id);
			}

		}
	}
}
