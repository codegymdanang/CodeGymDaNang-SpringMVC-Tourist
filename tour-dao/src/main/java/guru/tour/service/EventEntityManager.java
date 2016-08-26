package guru.tour.service;

import java.util.List;

import guru.tour.entity.EventEntity;

public interface EventEntityManager {
	
	public List<EventEntity> getAllEvent();
	
	public List<EventEntity> getAllName();
	
	public EventEntity findByName(String name);
	
	void saveEvent(EventEntity event);
     
    void deleteEventByName(String name);
    
    void deleteAllEvent();
    
    public boolean isEventExist(EventEntity event);
}