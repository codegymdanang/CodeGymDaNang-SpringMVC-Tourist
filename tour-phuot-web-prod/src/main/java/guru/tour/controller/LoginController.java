
package guru.tour.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.tour.entity.UserEntity;
import guru.tour.service.UserEntityManager;
import guru.tour.service.UserRoleImp;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	@Autowired
	UserEntityManager user;
	
	@Autowired
	UserRoleImp userRole;
	
	
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
	
	@RequestMapping(value = "/saveuser")
	public String saveuser(HttpServletRequest request) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String image=request.getParameter("image");
		String role=request.getParameter("role1");
		
		UserEntity userEntity=new UserEntity(true, true, true, true, image, password, phone, username);
		user.saveUser(userEntity);
		
		UserEntity userEntity2=user.getUserByName(username);
		userRole.saveUserRole(role, userEntity2.getId());
		return "success";
	}
}
