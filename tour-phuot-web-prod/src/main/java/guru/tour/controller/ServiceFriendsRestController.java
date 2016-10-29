
package guru.tour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import guru.tour.entity.UserEntity;
import guru.tour.entity.UserPostEntity;
import guru.tour.service.UserEntityManager;
import guru.tour.service.User_PostsManager;


@RestController
@RequestMapping(value = "/")
public class ServiceFriendsRestController {
	@Autowired
	UserEntityManager user;
	
	@Autowired
	User_PostsManager user_posts;
	
	
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
	
	@RequestMapping(value = "/addall", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody UserEntity userEntity,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + userEntity.getUsername());
 
        if (user.isUserExist(userEntity)) {
            System.out.println("A User with name " + userEntity.getUsername() + " already exist");
            return new ResponseEntity<String>("Username existss",HttpStatus.CONFLICT);
        }
 
        user.saveUser(userEntity);
        return new ResponseEntity<String>("Create successful",HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addComment(@RequestBody UserPostEntity user_post,UriComponentsBuilder ucBuilder) {
    	
		UserPostEntity user_postEntity=user_posts.saveUser_Posts(user_post);
    	
    	
    	
    	return new ResponseEntity<UserPostEntity>(user_postEntity, HttpStatus.OK)  ;
    }
    @RequestMapping(value = "/getAllComment/{id}/{page}", method = RequestMethod.GET)
    public ResponseEntity<Page<UserPostEntity>> getComment(@PathVariable("id") String id,@PathVariable("page") int page) {
		Page<UserPostEntity> pageRequest=user_posts.findById_Post(id, page, 2);

		List<UserPostEntity> userPosts=pageRequest.getContent();
    	return new ResponseEntity<Page<UserPostEntity>>(pageRequest, HttpStatus.OK)  ;
    }
	
}
