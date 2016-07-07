package guru.tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class ServiceHostController {
	@RequestMapping(value = "/servicehost")
	public String service_host(){
		return "servicehost";
	}
	@RequestMapping(value = "/profile")
	public String profile(){
		return "profile";
	}
	@RequestMapping(value = "/detail_profile")
	public String detail_profile(){
		return "detail_profile";
	}
}
