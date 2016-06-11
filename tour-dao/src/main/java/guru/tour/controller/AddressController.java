package guru.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.tour.entity.AddressEntity;
import guru.tour.service.AddressEntityManager;

@Controller
@RequestMapping("/")
public class AddressController {
	@Autowired
	AddressEntityManager manager;
	
	@RequestMapping(value = "/getAdd")
	public void getAdd(){
		List<AddressEntity> addressEntities = manager.getAllAddress();
		for(AddressEntity addressEntity : addressEntities){
			System.out.println(addressEntity.getId() + addressEntity.getAddress());
		}
	}
}
