package guru.tour.service;

import java.util.List;

import guru.tour.entity.HotNewsEntity;

public interface HotNewsEntityManager {
	public List<HotNewsEntity> getAllHotNews();

	public HotNewsEntity findById(int id);

	public void saveHotNewsEntity(HotNewsEntity hotnew);

	public boolean isUserExist(HotNewsEntity hotnew);
}
