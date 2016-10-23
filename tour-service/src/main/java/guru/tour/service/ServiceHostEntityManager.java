package guru.tour.service;

import java.util.List;

import guru.tour.entity.HostEntity;

public interface ServiceHostEntityManager {
	public List<HostEntity> findByName(String name);
	public List<HostEntity> getAllHost();
}
