package guru.tour.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.EventEntity;
import guru.tour.repository.EventEntityRepository;
@Service
public class EventEntityManagerImpl implements EventEntityManager {
	
	private static final AtomicLong counter = new AtomicLong();
	private static List<EventEntity> eventEntities;
	
	@Autowired
	EventEntityRepository eventEntity;

	
	public List<EventEntity> getAllEvent() {
		return eventEntity.findAll();
	}

	public List<EventEntity> getAllName() {
		
		return eventEntity.findAll();
	}

	public void saveEvent(EventEntity event) {
//		event.setId(counter.intValue());
		eventEntity.save(event);
	}


	public void deleteEventByName(String name) {
		for (Iterator<EventEntity> iterator = eventEntities.iterator(); iterator.hasNext(); ) {
            EventEntity event = iterator.next();
            if (event.getName() == name) {
                iterator.remove();
            }
        }
	}

	public void deleteAllEvent() {
		eventEntities.clear();
	}

	public EventEntity findByName(String name) {
		return eventEntity.findByName(name);
	}

	public boolean isEventExist(EventEntity event) {
		EventEntity findevent = findByName(event.getName());
		return (findevent == null) ? false : true;
	}

}
