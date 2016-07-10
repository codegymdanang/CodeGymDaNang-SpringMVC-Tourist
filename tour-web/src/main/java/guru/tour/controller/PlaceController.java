package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import guru.tour.entity.HotelEntity;
import guru.tour.service.HotelEntityManager;

@Controller
@RequestMapping(value = "/")
public class PlaceController {
	@Autowired
	HotelEntityManager hotel;
	
	@RequestMapping(value = "/place",method=RequestMethod.GET)
	public ModelAndView getHotel() {
		List<HotelEntity> hotelList = hotel.getAllHotel();
		ModelAndView model = new ModelAndView();
		model.addObject("list",hotelList);
		return model;
	}
}
