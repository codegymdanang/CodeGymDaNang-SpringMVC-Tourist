package guru.tour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import guru.tour.entity.UserEntity;
import guru.tour.service.UserEntityManager;

@Controller
@RequestMapping(value = "/")
public class ServiceFriendController {
	@Autowired
	UserEntityManager user;
	@RequestMapping(value = "/servicefriend", method = RequestMethod.GET)
	public ModelAndView serviceFriends() {		
		ModelAndView model = new ModelAndView("servicefriend");
		return model;
		// return "listEmployeeView";
	}
	@RequestMapping(value = "/findfriends")
	public ModelAndView findFriends(HttpServletRequest request) {
		String search=request.getParameter("search");
		System.out.println("Search: "+search);
		List<UserEntity> users=null;
		if(search.equalsIgnoreCase("Name")){
			 users= user.getUserByName(request.getParameter("name"));
		}else{
			 users= user.getUserByPhone(request.getParameter("name"));
		}
		
		for (UserEntity user : users) {
			System.out.println("First Name " + user.getUsername() + " Phone: " + user.getPhone());
		}
		// model.addObject("allEmployees",employees);
		ModelAndView model = new ModelAndView("findfriend");
		model.addObject("lists", users);

		return model;
		// return "listEmployeeView";
	}
	
	@RequestMapping(value="/jspdemo",method = RequestMethod.GET)
	public ModelAndView jspDemo() {		
		ModelAndView model = new ModelAndView("jspdemo");
		return model;
		// return "listEmployeeView";
	}
	
	@RequestMapping(value="/ajaxdemo",method = RequestMethod.GET)
	public ModelAndView ajaxdemo() {		
		ModelAndView model = new ModelAndView("ajaxdemo");
		return model;
		// return "listEmployeeView";
	}
}