package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import guru.tour.entity.PlaceEntity;
import guru.tour.repository.PlaceEntityRepository;

public class PlaceEntityManagerImpl implements PlaceEntityManager{

	@Autowired
	PlaceEntityRepository pl;
	
	public List<PlaceEntity> getAll() {
		return pl.findAll();
	}

}
