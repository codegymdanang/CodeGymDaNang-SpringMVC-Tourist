package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.PlaceEntity;
import guru.tour.repository.PlaceEntityRepository;
@Service
public class PlaceEntityManagerImpl implements PlaceEntityManager{

	@Autowired
	PlaceEntityRepository pl;
	
	public List<PlaceEntity> getAll() {
		return pl.findAll();
	}

	public PlaceEntity getPlaceByID(int i) {
		// TODO Auto-generated method stub
		return pl.findById(i);
	}

}
