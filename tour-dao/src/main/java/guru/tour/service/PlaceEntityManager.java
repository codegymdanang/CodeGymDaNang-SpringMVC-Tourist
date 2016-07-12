package guru.tour.service;

import java.util.List;

import guru.tour.entity.PlaceEntity;

public interface PlaceEntityManager {
	public List<PlaceEntity> getAll();

	public PlaceEntity getPlaceByID(int i);
}
