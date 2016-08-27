package guru.tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value = "/")
public class SearchController {
	@RequestMapping(value = "/search")
	public String search() {
		return "search";
	}

}
