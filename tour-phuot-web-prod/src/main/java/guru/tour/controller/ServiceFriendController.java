package guru.tour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
	
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
		ModelAndView model = new ModelAndView("findfriend");
		model.addObject("lists", users);

		return model;
	}
	
	@RequestMapping(value="/jspdemo",method = RequestMethod.GET)
	public ModelAndView jspDemo() {		
		ModelAndView model = new ModelAndView("jspdemo");
		return model;
	}
	
	@RequestMapping(value="/ajaxdemo",method = RequestMethod.GET)
	public ModelAndView ajaxdemo() {		
		ModelAndView model = new ModelAndView("ajaxdemo");
		return model;
	}
	
	@RequestMapping(value="/getAllUsers",method = RequestMethod.POST)
	public ModelAndView getUser(HttpServletRequest request) {	
		String button=request.getParameter("tim");
		System.out.println("ten: "+button);
		List<UserEntity> users=null;
		ModelAndView model=null;
		if(button.equals("timdiadiem")){
			users=user.getAllViaDiaDiem(request.getParameter("search"));
			 model = new ModelAndView("users");
		}else{
			users=user.getUserByName(request.getParameter("name"));
			 model = new ModelAndView("users");
		}
		
		model.addObject("users", users);
		return model;
	}
	
	@RequestMapping(value = "/updateprofile", method = RequestMethod.GET)
	public ModelAndView updateprofile() {		
		ModelAndView model = new ModelAndView("updateprofile");
		model.addObject("user", new UserEntity("hai", "123", "haha.png", "01212129827","da nang"));
		return model;
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public ModelAndView updateprofile_request(HttpServletRequest request) {		
		
		ModelAndView model = new ModelAndView("homePage");
		System.out.println(request.getParameter("username").toString());
		System.out.println(request.getParameter("password").toString());
		System.out.println(request.getParameter("phone").toString());
		System.out.println(request.getParameter("location").toString());
		UserEntity u = new UserEntity(request.getParameter("username").toString(), request.getParameter("password").toString(),"123123.jpg", request.getParameter("phone").toString(), request.getParameter("location").toString());
		user.saveUser(u);
		model.addObject("user", u);
		return model;
	}
	
	
}