
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import guru.tour.entity.EventEntity;
import guru.tour.service.EventEntityManager;

@RestController
public class EventRestFullController {
	
	@Autowired
	EventEntityManager eventmanager;
	
	 @RequestMapping(value = "/restevent", method = RequestMethod.GET)
	public ResponseEntity<List<EventEntity>> listAllEvent() {
		List<EventEntity> users = eventmanager.getAllName();
		if (users.isEmpty()) {
			return new ResponseEntity<List<EventEntity>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EventEntity>>(users, HttpStatus.OK);
	}

	// create
	@RequestMapping(value = "/restevent", method = RequestMethod.POST)
	public ResponseEntity<Void> createEvent(@RequestBody EventEntity event, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Event " + event.getName());

		// if (eventmanager.isEventExist(event)) {
		// System.out.println("A Event with name " + event.getName() + " already
		// exist");
		// return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		// }

		eventmanager.saveEvent(event);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/restevent/{name}").buildAndExpand(event.getName()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// delete by name
	@RequestMapping(value = "/restevent/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<EventEntity> deleteEvent(@PathVariable("name") String name) {
		System.out.println("Fetching & Deleting Event with name " + name);

		EventEntity event = eventmanager.findByName(name);
		if (event == null) {
			System.out.println("Unable to delete. Event with name " + name + " not found");
			return new ResponseEntity<EventEntity>(HttpStatus.NOT_FOUND);
		}

		eventmanager.deleteEventByName(name);
		return new ResponseEntity<EventEntity>(HttpStatus.NO_CONTENT);
	}

	// detele all
	@RequestMapping(value = "/restevent", method = RequestMethod.DELETE)
	public ResponseEntity<EventEntity> deleteAllEvent() {
		System.out.println("Deleting All Event");

		eventmanager.deleteAllEvent();
		;
		return new ResponseEntity<EventEntity>(HttpStatus.NO_CONTENT);
	}
	
	//demo ajax in restfull
	@RequestMapping(value="/eventajax",method = RequestMethod.GET)
	public ModelAndView jspDemo() {		
		ModelAndView model = new ModelAndView("eventajax");
		return model;
	}
	
}
