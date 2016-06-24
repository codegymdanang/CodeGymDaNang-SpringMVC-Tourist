package test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.tour.entity.AddressEntity;
import guru.tour.service.AddressEntityManager;

@ContextConfiguration("Test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class Test {
	@Autowired
	AddressEntityManager add;
	
	@org.junit.Test
	public void show(){
		List<AddressEntity> list = add.getAllAddress();
		for (AddressEntity addressEntity : list) {
			System.out.println(addressEntity.getAddress());
		}
	}
}
