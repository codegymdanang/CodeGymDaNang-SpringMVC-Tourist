
package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import guru.tour.entity.HotelEntity;
import guru.tour.entity.LocationEntity;
import guru.tour.exception.HotelNotFoundException;
import guru.tour.service.HotelEntityManager;
import guru.tour.service.LocationEntityManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping(value="/")
public class ServiceHotelController {
	
	@Autowired
	HotelEntityManager hotel;
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceHotelController.class);
	
	@Autowired
	LocationEntityManager location;
	@RequestMapping(value="/hotel",method = RequestMethod.GET)
	public String searchHotel(ModelMap mm){
//		List<HotelEntity> list = hotel.getAllHotel();
//		mm.addAttribute("list", list);
		return "hotel";
	}
	
	@RequestMapping(value="/detailhotel",method = RequestMethod.GET)
	public String detailhotel(ModelMap mm){
		List<LocationEntity> list = location.getLocation();
		mm.addAttribute("list", list);
		return "detailhotel";
	}

	/*@RequestMapping(value="/hotel/{id}", method=RequestMethod.GET)
	public String getEmployee(@PathVariable("id") String hotelid, Model model) throws Exception{
		//deliberately throwing different types of exception
		if(hotelid=='1'){
			throw new HotelNotFoundException(id)
		}else if(id==2){
			throw new SQLException("SQLException, id="+id);
		}else if(id==3){
			throw new IOException("IOException, id="+id);
		}else if(id==10){
			HotelEntity emp = new HotelEntity();
			emp.setHotelName("Pankaj");
			emp.setHotelId();
			model.addAttribute("employee", emp);
			return "hotel";
		}else {
			throw new Exception("Generic Exception, id="+id);
		}
		
	}*/
	
	@ExceptionHandler(HotelNotFoundException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}	
}
