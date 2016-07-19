package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guru.tour.entity.RatingEntity;
import guru.tour.service.RatingManager;

@Controller
@RequestMapping(value = "/")
public class RatingController {
	@Autowired
	RatingManager ratingManager;
	
	@RequestMapping("/findAllRating")
	public ModelAndView serviceRating() {		
		ModelAndView model = new ModelAndView("service_rating");
		List<RatingEntity> lists=ratingManager.getAll();
		model.addObject("lists", lists);
		return model;
	}
}
