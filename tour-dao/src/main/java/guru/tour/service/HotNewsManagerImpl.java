package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import guru.tour.entity.HotNewsEntity;
import guru.tour.repository.HotNewsEntityRepository;

@Service
public class HotNewsManagerImpl implements HotNewsEntityManager {
	@Autowired	
	HotNewsEntityRepository loadHotNews;		
	public List<HotNewsEntity> getAllHotNews() {
		// TODO Auto-generated method stub
		return loadHotNews.findAll();
	}
	
	public HotNewsEntity findById(int id) {
	
		return loadHotNews.findOne(id);
	}

	public void saveHotNewsEntity(HotNewsEntity hotnew) {
			loadHotNews.saveAndFlush(hotnew);	
	}

	public boolean isUserExist(HotNewsEntity hotnew) {
		// TODO Auto-generated method stub
		HotNewsEntity hotNewsEntity =null;
		hotNewsEntity = findById(hotnew.getHotnewsId());
		if(hotNewsEntity == null){
			return true;
		}
		return false;
	}
}
