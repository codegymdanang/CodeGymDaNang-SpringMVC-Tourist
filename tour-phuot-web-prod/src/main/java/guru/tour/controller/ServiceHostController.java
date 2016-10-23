
package guru.tour.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import guru.tour.entity.HostEntity;
import guru.tour.entity.ProfileEntity;
import guru.tour.exception.HostNotFoundException;
import guru.tour.service.HostDetailManager;
import guru.tour.service.ServiceHostEntityManager;

@Controller
@RequestMapping(value = "/")
public class ServiceHostController {
	private static final Logger logger = LoggerFactory.getLogger(ServiceHostController.class);
	@Autowired
	ServiceHostEntityManager hostmanager;

	@Autowired
	HostDetailManager manager;

	List<HostEntity> images;

	@RequestMapping(value = "/servicehost", method = RequestMethod.GET)
	public String service_host(ModelMap save) {
		List<HostEntity> imagesSG = hostmanager.findByName("SAI GON");
		save.addAttribute("imagesSG", imagesSG);

		List<HostEntity> imagesHN = hostmanager.findByName("HA NOI");
		save.addAttribute("imagesHN", imagesHN);

		List<HostEntity> imagesQN = hostmanager.findByName("QUANG NAM");
		save.addAttribute("imagesQN", imagesQN);

		List<HostEntity> imagesDN = hostmanager.findByName("DA NANG");
		save.addAttribute("imagesDN", imagesDN);

		images = hostmanager.getAllHost();
		save.addAttribute("lists", images);

		return "servicehost";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(ModelMap m) {
		List<ProfileEntity> list = manager.getAllHost();
		m.addAttribute("list", images);
		m.addAttribute("list", list);
		return "profile";
	}

	@RequestMapping(value = "/detail_profile")
	public String detail_profile() {
		return "detail_profile";
	}

	@RequestMapping(value="/servicehost/{id}", method = RequestMethod.GET)
	public String getServiceHostEntity(@PathVariable("id") int id, Model model) throws Exception {
		if(id==1){
			throw new HostNotFoundException(id);
		}else if(id==2){
			throw new SQLException("SQLException, id="+id);
		}else if(id==3){
			throw new IOException("IOException, id="+id);
		}else if(id==10){
			HostEntity host = new HostEntity();
			host.setName("DaNang");
//			host.setId(id);
			model.addAttribute("host", host);
			return "home";
		}else {
			throw new Exception("Generic Exception, id="+id);
		}
	}
	
	@ExceptionHandler(HostNotFoundException.class)
	public ModelAndView handleHostNotFoundException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}	
}
