package guru.tour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import guru.tour.entity.PlaceEntity;
import guru.tour.exception.PlaceNotFoundException;
import guru.tour.service.PlaceEntityManager;

import guru.tour.entity.FoodEntity;
import guru.tour.service.FoodEntityManager;

@Controller
@RequestMapping(value = "/")
public class PlaceController {
	@Autowired
	PlaceEntityManager placeEntityManager;
	
	@Autowired
	FoodEntityManager foodEntityManager;
	
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
		PlaceEntity placeEntity = placeEntityManager.getPlaceByID(1);
		System.out.println(placeEntity.getName());
		ModelAndView model = new ModelAndView("place");
		model.addObject("Place", placeEntity);
		List<FoodEntity> foodList = foodEntityManager.getAllFoods();
		model.addObject("list", foodList);
		return model;
	}

//	@ExceptionHandler(PlaceNotFoundException.class)
//	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex) {
//		logger.error("Requested URL=" + request.getRequestURL());
//		logger.error("Exception Raised=" + ex);
//
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("exception", ex);
//		modelAndView.addObject("url", request.getRequestURL());
//
//		modelAndView.setViewName("error");
//		return modelAndView;
//	}

}
