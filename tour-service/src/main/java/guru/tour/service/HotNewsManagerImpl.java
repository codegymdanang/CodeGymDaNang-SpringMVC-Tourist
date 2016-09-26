package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import guru.tour.entity.HotNewEntity;
import guru.tour.repository.HotNewsEntityRepository;

@Service
public class HotNewsManagerImpl implements HotNewsEntityManager {
	@Autowired
	HotNewsEntityRepository loadHotNews;

	public List<HotNewEntity> getAllHotNews() {
		// TODO Auto-generated method stub
		return loadHotNews.findAll();
	}

	public HotNewEntity findByHotnewsId(String id) {

		return loadHotNews.findOne(id);
	}

	public void saveHotNewsEntity(HotNewEntity hotnew) {
		loadHotNews.save(hotnew);
	}

	public boolean isHotNewsEntity(HotNewEntity hotnew) {
		// TODO Auto-generated method stub
		List<HotNewEntity> list = loadHotNews.findAll();

		if (list.contains(hotnew)) {
			return true;
		}
		return false;
	}

	public void updateHotnew(HotNewEntity currentHotnew) {
		// TODO Auto-generated method stub
		loadHotNews.saveAndFlush(currentHotnew);
	}

	public void deleteHotnewById(String id) {
		// TODO Auto-generated method stub
		loadHotNews.delete(id);
	}

	public void deleteAllHotnews() {
		// TODO Auto-generated method stub
		loadHotNews.deleteAll();
	}
}
