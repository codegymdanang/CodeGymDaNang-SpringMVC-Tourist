package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import guru.tour.entity.LocationEntity;
import guru.tour.entity.PlaceEntity;
import guru.tour.service.LocationEntityManager;

@RestController
public class LocationRestController {
	@Autowired
	private LocationEntityManager locationEntityManager;
	@RequestMapping(value = "/allLocation", method = RequestMethod.GET)
    public ResponseEntity<List<LocationEntity>> listAllUsers() {
        List<LocationEntity> list = locationEntityManager.getLocation();
        return new ResponseEntity<List<LocationEntity>>(list, HttpStatus.OK);
	}
}
