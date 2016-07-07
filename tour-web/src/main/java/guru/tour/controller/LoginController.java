package guru.tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/find")
	public String find() {
		return "find";
	}
	@RequestMapping(value = "/register")
	public String register() {
		return "register";
	}
}
