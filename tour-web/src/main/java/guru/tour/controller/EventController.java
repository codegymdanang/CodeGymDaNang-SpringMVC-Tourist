package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.tour.entity.EventEntity;
import guru.tour.service.EventEntityManager;

@Controller
@RequestMapping(value = "/")
public class EventController {
	
	@Autowired
	EventEntityManager eventmanager;
	
	@RequestMapping(value="/event",method = RequestMethod.GET)
	public String event(ModelMap m) {
		List<EventEntity> list = eventmanager.getAllEvent();
		m.addAttribute("list", list);
		return "event";
	}
}
