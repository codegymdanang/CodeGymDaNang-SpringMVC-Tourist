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
	ServiceHostEntityManager hostmanager;
	
	@Autowired
	HostDetailManager manager;
	
	List<ServiceHostEntity> images;
	
	@RequestMapping(value = "/servicehost", method = RequestMethod.GET)
	public String service_host(ModelMap save){
//		List<ServiceHostEntity> employees = hostmanager.findByName("SAI GON");
//		for (ServiceHostEntity host : employees) {
//			System.out.println("Name "+ host.getName() + ",Phone " + host.getPhone());
//		}
//		ModelAndView model = new ModelAndView("servicehost");
//		save.addAttribute("lists", employees);
		
//		List<ServiceHostEntity> imagesHaNoi = hostmanager.findByName("HA NOI");
//		for (ServiceHostEntity host : imagesHaNoi) {
//			System.out.println("Name "+ host.getName() + ",Phone " + host.getPhone());
//		}
//		save.addAttribute("lists", imagesHaNoi);
//		
//		List<ServiceHostEntity> imagesQuangNam = hostmanager.findByName("QUANG NAM");
//		for (ServiceHostEntity host : imagesQuangNam) {
//			System.out.println("Name "+ host.getName() + ",Phone " + host.getPhone());
//		}
//		save.addAttribute("lists", imagesQuangNam);
//		
//		List<ServiceHostEntity> imagesDaNang = hostmanager.findByName("DA NANG");
//		for (ServiceHostEntity host : imagesDaNang) {
//			System.out.println("Name "+ host.getName() + ",Phone " + host.getPhone());
//		}
//		save.addAttribute("lists", imagesDaNang);
//		return "servicehost";
		images = hostmanager.getAllHost();
//		save.addAttribute("lists", images);
		return "servicehost";
	}
	
	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public String profile(ModelMap m){
		List<HostDetailEntity> list = manager.getAllHost();
		m.addAttribute("list", images);
		m.addAttribute("list",list);
		return "profile";
	}
	
	
	
	@RequestMapping(value = "/detail_profile")
	public String detail_profile(){
		return "detail_profile";
	}
}
