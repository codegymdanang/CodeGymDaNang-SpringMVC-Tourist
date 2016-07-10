package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import guru.tour.entity.HostDetailEntity;
import guru.tour.entity.ServiceHostEntity;
import guru.tour.service.HostDetailManager;
import guru.tour.service.ServiceHostEntityManager;

@Controller
@RequestMapping(value = "/")
public class ServiceHostController {
	
	@Autowired
	HostDetailManager manager;
	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public String profile(ModelMap m){
		List<HostDetailEntity> list = manager.getAllHost();
		m.addAttribute("list",list);
		return "profile";
	}
	
	@Autowired
	ServiceHostEntityManager hostmanager;
	
	@RequestMapping(value = "/servicehost", method = RequestMethod.GET)
	public String service_host(ModelMap save){
		List<ServiceHostEntity> employees = hostmanager.findByName("Quoc");
		for (ServiceHostEntity host : employees) {
			System.out.println("Name "+ host.getName() + ",Phone " + host.getPhone());
		}
//		ModelAndView model = new ModelAndView("servicehost");
		save.addAttribute("lists", employees);
		return "servicehost";
	}
	@RequestMapping(value = "/detail_profile")
	public String detail_profile(){
		return "detail_profile";
	}
}
