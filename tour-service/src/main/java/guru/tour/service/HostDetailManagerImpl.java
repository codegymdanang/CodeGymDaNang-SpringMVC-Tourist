package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.ProfileEntity;
import guru.tour.repository.ProfileRepository;

@Service
public class HostDetailManagerImpl implements HostDetailManager{
	
	@Autowired
	ProfileRepository shdJPA;
	
	public List<ProfileEntity> getAllHost() {
		return shdJPA.findAll();
	}
	
}
