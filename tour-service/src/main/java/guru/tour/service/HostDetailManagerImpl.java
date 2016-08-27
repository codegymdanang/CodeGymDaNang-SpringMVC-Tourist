package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.HostDetailEntity;
import guru.tour.repository.HostDetailEntityRepository;

@Service
public class HostDetailManagerImpl implements HostDetailManager{
	
	@Autowired
	HostDetailEntityRepository shdJPA;
	
	public List<HostDetailEntity> getAllHost() {
		return shdJPA.findAll();
	}
	
}
