package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import guru.tour.entity.HotelEntity;
import guru.tour.entity.PlaceEntity;
import guru.tour.service.HotelEntityManager;
import guru.tour.service.PlaceEntityManager;

import guru.tour.entity.FoodEntity;
import guru.tour.service.FoodEntityManager;


@Controller
@RequestMapping(value = "/")
public class PlaceController {
//	@Autowired
//	HotelEntityManager hotel;
	@Autowired
	PlaceEntityManager placeEntityManager;
	@Autowired
	FoodEntityManager food;

	@RequestMapping(value = "/place",method = RequestMethod.GET)
	public ModelAndView getPlaceByID(){
		PlaceEntity placeEntity = placeEntityManager.getPlaceByID(1);
		System.out.println(placeEntity.getName());
		ModelAndView model = new ModelAndView("place");
		model.addObject("Place", placeEntity);
		return model;
	}

	@RequestMapping(value = "/food",method=RequestMethod.GET)
	public ModelAndView getFood() {
		List<FoodEntity> foodList = food.getAllHotel();
		ModelAndView model = new ModelAndView();
		return model;
	}
//	@RequestMapping(value = "/place",method=RequestMethod.GET)
//	public ModelAndView getHotel() {
//		List<HotelEntity> hotelList = hotel.getAllHotel();
//		ModelAndView model = new ModelAndView();
//		model.addObject("list",hotelList);
//		return model;
//	}
}
