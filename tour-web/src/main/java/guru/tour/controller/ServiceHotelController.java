package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import guru.tour.entity.HotelEntity;
import guru.tour.entity.LocationEntity;
import guru.tour.service.HotelEntityManager;
import guru.tour.service.LocationEntityManager;


@Controller
@RequestMapping(value="/")
public class ServiceHotelController {
	
	@Autowired
	HotelEntityManager hotel;
	
	@Autowired
	LocationEntityManager location;
	@RequestMapping(value="/hotel",method = RequestMethod.GET)
	public String searchHotel(ModelMap mm){
		List<HotelEntity> list = hotel.getAllHotel();
		mm.addAttribute("list", list);
		return "hotel";
	}
	
	@RequestMapping(value="/detailhotel",method = RequestMethod.GET)
	public String detailhotel(ModelMap mm){
		List<LocationEntity> list = location.getLocation();
		mm.addAttribute("list", list);
		return "detailhotel";
	}
}
