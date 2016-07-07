package guru.tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class PlaceController {
	@RequestMapping(value = "/place")
	public String place() {
		return "place";
	}
}
