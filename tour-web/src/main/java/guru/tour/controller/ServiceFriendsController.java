package guru.tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class ServiceFriendsController {
	@RequestMapping(value = "/servicefriend")
	public String service_friend() {
		return "servicefriend";
	}
	@RequestMapping(value = "/findfriend")
	public String find_friend() {
		return "servicefriend";
	}
}
