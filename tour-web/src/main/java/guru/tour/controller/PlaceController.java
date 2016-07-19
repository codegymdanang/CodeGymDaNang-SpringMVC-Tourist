package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import guru.tour.entity.FoodEntity;
import guru.tour.service.FoodEntityManager;

@Controller
@RequestMapping(value = "/")
public class PlaceController {
	@Autowired
	FoodEntityManager food;
	
	@RequestMapping(value = "/food",method=RequestMethod.GET)
	public ModelAndView getFood() {
		List<FoodEntity> foodList = food.getAllHotel();
		ModelAndView model = new ModelAndView();
		model.addObject("list",foodList);
		return model;
	}
}
