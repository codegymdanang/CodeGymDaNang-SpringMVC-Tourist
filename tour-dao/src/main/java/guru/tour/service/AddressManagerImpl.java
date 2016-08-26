package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.AddressEntity;
import guru.tour.repository.AddressEntityRepository;

@Service
public class AddressManagerImpl implements AddressEntityManager {

	@Autowired
	AddressEntityRepository addEntity;
	public List<AddressEntity> getAllAddress() {
		return addEntity.findAll();
	}
}
