
package guru.tour.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import guru.tour.entity.UserEntity;
import guru.tour.service.UserEntityManager;


@Controller
@RequestMapping(value = "/")
public class ServiceFriendController  {
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
	public ModelAndView updateprofile(Principal principal) {		
		List<UserEntity> list  = user.getUserByName(principal.getName());
		UserEntity users= list.get(0);
		ModelAndView model = new ModelAndView("updateprofile");
		model.addObject("user",users);
		return model;
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public ModelAndView updateprofile_request(HttpServletRequest request,@RequestParam("file") CommonsMultipartFile[] file) throws IllegalStateException, IOException {	
		 String saveDirectory = request.getServletContext().getRealPath("/")+"/resource/images/";
		 String a ="";
		 if (file != null && file.length > 0) {
	            for (CommonsMultipartFile aFile : file){
	                  a = aFile.getOriginalFilename();
	                System.out.println("Saving file: " + aFile.getOriginalFilename());
	                 
	                if (!aFile.getOriginalFilename().equals("")) {
	                    aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
	                }
	            }
	        }
		
		ModelAndView model = new ModelAndView("homePage");
		UserEntity u = new UserEntity(request.getParameter("username").toString(),a, request.getParameter("phone").toString(), request.getParameter("location").toString(),1);
		user.updateByUsername(u);
		model.addObject("user", u);
		return model;
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public ModelAndView changepassword(Principal principal) {		
		List<UserEntity> list  = user.getUserByName(principal.getName());
		UserEntity users= list.get(0);
		System.err.println(principal.getName());
		ModelAndView model = new ModelAndView("changepassword");
		model.addObject("user",users);
		return model;
	}
	
	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	public ModelAndView process_changepassword(HttpServletRequest request,Principal principal) {	
		String password = request.getParameter("password1");
		ModelAndView model = new ModelAndView("updateprofile");
		List<UserEntity> list  = user.getUserByName(principal.getName());
		UserEntity users= list.get(0);
		users.setPassword(password);
		user.updatePasswordByUsername(users);
		model.addObject("user", users);
		return model;
	}
	

	
	
}