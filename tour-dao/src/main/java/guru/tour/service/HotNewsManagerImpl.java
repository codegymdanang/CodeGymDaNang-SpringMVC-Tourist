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
		loadHotNews.save(hotnew);
	}

	public boolean isHotNewsEntity(HotNewsEntity hotnew) {
		// TODO Auto-generated method stub
		List<HotNewsEntity> list = loadHotNews.findAll();

		if (list.contains(hotnew)) {
			return true;
		}
		return false;
	}

	public void updateHotnew(HotNewsEntity currentHotnew) {
		// TODO Auto-generated method stub
		loadHotNews.saveAndFlush(currentHotnew);
	}

	public void deleteHotnewById(int id) {
		// TODO Auto-generated method stub
		loadHotNews.delete(id);
	}

	public void deleteAllHotnews() {
		// TODO Auto-generated method stub
		loadHotNews.deleteAll();
	}
}
