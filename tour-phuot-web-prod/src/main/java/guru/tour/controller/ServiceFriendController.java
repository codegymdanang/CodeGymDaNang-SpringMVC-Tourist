
package guru.tour.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import guru.tour.entity.UserEntity;
import guru.tour.entity.UserPostEntity;
import guru.tour.service.UserEntityManager;
import guru.tour.service.User_PostsManager;
import guru.tour.user.Account;


@Controller
@RequestMapping(value = "/")
public class ServiceFriendController  {
	Logger log=LoggerFactory.getLogger(ServiceFriendController.class);
	@Autowired
	UserEntityManager user;
	
	@Autowired
	User_PostsManager user_posts;
	
	
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
			 users= user.findUserContainingName(request.getParameter("name"));
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
//		if(button.equals("timdiadiem")){
//			users=user.getAllViaDiaDiem(request.getParameter("search"));
//			 model = new ModelAndView("users");
//		}else{
//			users=user.getUserByName(request.getParameter("name"));
//			 model = new ModelAndView("users");
//		}
		
		model.addObject("users", users);
		return model;
	}
	
	@RequestMapping(value = "/updateprofile", method = RequestMethod.GET)
	public ModelAndView updateprofile(Principal principal) {		
		UserEntity users  = user.getUserByName(principal.getName());
		ModelAndView model = new ModelAndView("updateprofile");
		model.addObject("userModel",users);
		return model;
	}
	
	
	@RequestMapping(value = "/userprofile", method = RequestMethod.POST)
	public ModelAndView updateprofile_response(HttpServletRequest request,@RequestParam("file") CommonsMultipartFile[] file,@ModelAttribute("userModel")@Valid UserEntity userModel,
			BindingResult bindingResult,Principal principal) throws IllegalStateException, IOException {
		ModelAndView model = new ModelAndView("userprofile");
		
		if (bindingResult.hasErrors()) {
			// handle error
			log.error("===Got error");
			model.addObject("userModel", userModel);
			model.setViewName("updateprofile");
		} else {
		 String saveDirectory = request.getServletContext().getRealPath("/")+"/resource/images/";
		 String image ="";
		 if (file != null && file.length > 0) {
	            for (CommonsMultipartFile aFile : file){
	                  image = aFile.getOriginalFilename();
	                System.out.println("Saving file: " + aFile.getOriginalFilename());
	                 
	                if (!aFile.getOriginalFilename().equals("")) {
	                    aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
	                }
	            }
	        }
		 
		 if(image==""){
			 image=request.getParameter("image").toString();
		 }
		
		UserEntity u = new UserEntity(request.getParameter("username").toString(),image, request.getParameter("phone").toString(), request.getParameter("location").toString(),1);
		user.updateByUsername(u);
		model.addObject("user", u);
		}
		return model;
		
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public ModelAndView changepassword(Principal principal) {		
		UserEntity users  = user.getUserByName(principal.getName());
		ModelAndView model = new ModelAndView("changepassword");
		model.addObject("user",users);
		return model;
	}
	
	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	public ModelAndView process_changepassword(HttpServletRequest request,Principal principal) {	
		String password = request.getParameter("password1");
		ModelAndView model = new ModelAndView("updateprofile");
		UserEntity users  = user.getUserByName(principal.getName());
		users.setPassword(password);
		user.updatePasswordByUsername(users);
		model.addObject("user", users);
		return model;
	}
	

	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public ModelAndView comment(Principal principal) {		
		ModelAndView model = new ModelAndView("comment");
		log.info(principal.getName());
	    model.addObject("name", principal.getName());
		return model;
	}
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView success(Principal principal,HttpServletRequest request) {		
		
		ModelAndView model = new ModelAndView("success");
		String comment=request.getParameter("comment");
		user.updateComment(principal.getName(), comment);
		model.addObject("name", principal.getName());
		return model;
	}
	
	@RequestMapping(value = "/userprofile", method = RequestMethod.GET)
	public ModelAndView userprofile(Principal principal) {		
		UserEntity users  = user.getUserByName(principal.getName());
		ModelAndView model = new ModelAndView("userprofile");
		model.addObject("user",users);
		return model;
	}
	
	@RequestMapping(value = "/demoComment2", method = RequestMethod.GET)
	public ModelAndView demoComment2(@RequestParam("id_post") int id_post) {	
		ModelAndView model = new ModelAndView("comment2");
		
		Account user = (Account)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Page<UserPostEntity> pageRequest=user_posts.findById_Post(String.valueOf(id_post), 0, 2);
		int currentIndex=pageRequest.getNumber();
		int totalPage=pageRequest.getTotalPages()-1;
		model.addObject("totalPage", totalPage);
		model.addObject("currentIndex", currentIndex);
		model.addObject("id_post", id_post);
		model.addObject("userModel", new UserPostEntity());
		model.addObject("username", user.getUser().getUsername());
		return model;
	}
	@RequestMapping(value = "/comment3", method = RequestMethod.GET)
	public ModelAndView comment3(Principal principal) {		
		ModelAndView model = new ModelAndView("comment3");
		return model;
	}
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public ModelAndView post() {	
		Account user = (Account)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("post");
		model.addObject("username", user.getUser().getUsername());
		return model;
	}
}