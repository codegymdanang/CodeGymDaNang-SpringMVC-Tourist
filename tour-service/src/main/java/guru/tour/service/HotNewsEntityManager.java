package guru.tour.service;

import java.util.List;

import guru.tour.entity.HotNewEntity;

public interface HotNewsEntityManager {
	public List<HotNewEntity> getAllHotNews();

	public HotNewEntity findByHotnewsId(String id);

	public void saveHotNewsEntity(HotNewEntity hotnew);

	public boolean isHotNewsEntity(HotNewEntity hotnew);

	public void updateHotnew(HotNewEntity currentHotnew);
	
	public void deleteHotnewById(String id);

	public void deleteAllHotnews();

}
