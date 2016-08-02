package guru.tour.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.tour.entity.EventEntity;

@Controller
@RequestMapping(value = "/")
public class FoodController {
	@RequestMapping(value = "/food",method = RequestMethod.GET)	
	public String food() {
		return "food";
	}
}
