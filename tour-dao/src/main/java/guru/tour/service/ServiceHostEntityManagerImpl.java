package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import guru.tour.entity.ServiceHostEntity;
import guru.tour.repository.ServiceHostEntityRepository;

@Service
public class ServiceHostEntityManagerImpl implements ServiceHostEntityManager{

	@Autowired
	ServiceHostEntityRepository serviceHostEntityRepository;
	
	public List<ServiceHostEntity> findByName(String name) {		
		return serviceHostEntityRepository.findByName(name);
	}
	
	public List<ServiceHostEntity> getAllHost() {		
		return serviceHostEntityRepository.findAll();
	}

}
