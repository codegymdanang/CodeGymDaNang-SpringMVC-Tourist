
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

import guru.tour.entity.PlaceEntity;
import guru.tour.service.PlaceEntityManager;

@RestController
//@RequestMapping(value = "/")
public class PlaceRestController {
	@Autowired
	PlaceEntityManager placeEntityManager;
//	@Autowired
//	FoodEntityManager foodEntityManager;
	
//	private static final Logger logger = LoggerFactory.getLogger(PlaceController.class);

	/*@RequestMapping(value = "/place/{id}", method = RequestMethod.GET)
	public ModelAndView getPlaceByID(@PathVariable("id") int id) throws Exception {
<<<<<<< HEAD
//		PlaceEntity placeEntity = placeEntityManager.getPlaceByID(id);
//		if (!(id == placeEntity.getId())) {
//			throw new PlaceNotFoundException(id);
//		} else if (id == placeEntity.getId()) {
//			ModelAndView model = new ModelAndView("place");
//			model.addObject("Place", placeEntity);
//			List<FoodEntity> foodList = foodEntityManager.findAll();
//			model.addObject("list", foodList);
//			return model;
//		} else {
//			throw new Exception("Generic Exception, id=" + id);
//		}
		PlaceEntity placeEntity = placeEntityManager.getPlaceByID(id);
=======
		PlaceEntity placeEntity = placeEntityManager.getPlaceByID(id);
		if (!(id == placeEntity.getId())) {
			throw new PlaceNotFoundException(id);
		} else if (id == placeEntity.getId()) {
			ModelAndView model = new ModelAndView("place");
			model.addObject("Place", placeEntity);
			List<FoodEntity> foodList = foodEntityManager.findAll();
			model.addObject("list", foodList);
			return model;
		} else {
			throw new Exception("Generic Exception, id=" + id);
		}
	}*/
	@RequestMapping(value = "/place", method = RequestMethod.GET)
	public ModelAndView getPlaceByID() throws Exception {
		PlaceEntity placeEntity = placeEntityManager.getPlaceByID("2");
		System.out.println(placeEntity.getName());
		System.out.println(placeEntity.getDescription());
		System.out.println(placeEntity.getLocation().getLocationName());
		ModelAndView model = new ModelAndView("place");
		model.addObject("place", placeEntity);
		return model;
	}
	@RequestMapping(value = "/allPlace", method = RequestMethod.GET)
    public ResponseEntity<List<PlaceEntity>> listAllUsers() {
        List<PlaceEntity> list = placeEntityManager.getAll();
        if(list.isEmpty()){
            return new ResponseEntity<List<PlaceEntity>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<PlaceEntity>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addPlace", method = RequestMethod.POST)
    public ResponseEntity<Void> addPlace(@RequestBody PlaceEntity p,    UriComponentsBuilder ucBuilder) {
		System.out.println("Add place: "+p.getName());
        if (placeEntityManager.isPlaceExist(p)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        placeEntityManager.addPlace(p);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/place/{id}").buildAndExpand(p.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	@RequestMapping(value="/updatePlace/{id}", method = RequestMethod.POST)
	public ResponseEntity<PlaceEntity> updatePlace(@PathVariable("id") String id, @RequestBody PlaceEntity p){
		PlaceEntity currentPlace = placeEntityManager.getPlaceByID(id);
		if(currentPlace == null){
			return new ResponseEntity<PlaceEntity>(HttpStatus.NOT_FOUND);
		}
		currentPlace.setName(p.getName());
		currentPlace.setId(p.getId());
		currentPlace.setImages(p.getImages());
		currentPlace.setDescription(p.getDescription());
		placeEntityManager.updatePlace(currentPlace);
		return new ResponseEntity<PlaceEntity>(currentPlace, HttpStatus.OK);
	}
	@RequestMapping(value="/place/{id}", method = RequestMethod.POST)
	public ResponseEntity<PlaceEntity> deletePlace(@PathVariable("id") String id, @RequestBody PlaceEntity p){
		PlaceEntity currentPlace = placeEntityManager.getPlaceByID(id);
		if(currentPlace == null){
			return new ResponseEntity<PlaceEntity>(HttpStatus.NOT_FOUND);
		}
		placeEntityManager.deletePlace(id);
		return new ResponseEntity<PlaceEntity>(HttpStatus.OK);
	}
}
