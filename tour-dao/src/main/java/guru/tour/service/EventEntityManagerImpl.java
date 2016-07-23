package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.EventEntity;
import guru.tour.repository.EventEntityRepository;
@Service
public class EventEntityManagerImpl implements EventEntityManager {
	
	@Autowired
	EventEntityRepository eventEntity;

	public List<EventEntity> getAllEvent() {
		return eventEntity.findAll();
	}
}
