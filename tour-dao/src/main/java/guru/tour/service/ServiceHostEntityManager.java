package guru.tour.service;

import java.util.List;

import guru.tour.entity.ServiceHostEntity;

public interface ServiceHostEntityManager {
	public List<ServiceHostEntity> findByName(String name);
	public List<ServiceHostEntity> getAllHost();
}
