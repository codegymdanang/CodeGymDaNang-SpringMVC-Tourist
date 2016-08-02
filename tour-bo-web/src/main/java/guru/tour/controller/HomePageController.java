package guru.tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class HomePageController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String HomePage(){
		
		return "homePage";
	}
}
