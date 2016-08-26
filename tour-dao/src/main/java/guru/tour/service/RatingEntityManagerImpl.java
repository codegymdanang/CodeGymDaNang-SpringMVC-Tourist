package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.RatingEntity;
import guru.tour.repository.RatingRepository;

@Service
public class RatingEntityManagerImpl implements RatingEntityManager{

	@Autowired
	RatingRepository ratingRepository;
	public List<RatingEntity> getAll() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

}
