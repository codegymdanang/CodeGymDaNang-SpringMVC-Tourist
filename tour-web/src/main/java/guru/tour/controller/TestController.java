package guru.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.tour.service.AddressEntityManager;
import test.Test;

@Controller
@RequestMapping(value="/test")
public class TestController {
	@Autowired(required=true)
	AddressEntityManager address;
	Test test;
	
	public void test(){
		test.show();
	}
}
