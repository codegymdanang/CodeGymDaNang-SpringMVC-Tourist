package guru.tour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import guru.tour.entity.UserEntity;
import guru.tour.service.UserEntityManager;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

@RestController
@RequestMapping(value = "/")
public class ServiceFriendsController {
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
	@RequestMapping(value = "/findPhone/{phone}", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntity>> findPhone(@PathVariable("phone") String phone) {
		List<UserEntity> users=null;
			 users= user.getUserByPhone(phone);
		
		
		for (UserEntity user : users) {
			System.out.println("First Name " + user.getUsername() + " Phone: " + user.getPhone());
		}
		// model.addObject("allEmployees",employees);
/*		ModelAndView model = new ModelAndView("findfriend");
		model.addObject("lists", users);*/

		return new ResponseEntity<List<UserEntity>>(users, HttpStatus.OK);
		// return "listEmployeeView";
	}
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntity>> getall() {
		List<UserEntity> users=null;
			 users= user.getAll();

		return new ResponseEntity<List<UserEntity>>(users, HttpStatus.OK);
	}
}
