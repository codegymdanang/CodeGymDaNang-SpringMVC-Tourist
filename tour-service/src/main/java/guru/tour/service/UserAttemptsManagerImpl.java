package guru.tour.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.UserAttemptEntity;
import guru.tour.repository.ServiceFriendsRepository;
import guru.tour.repository.UserAttemptsRepository;

@Service
public class UserAttemptsManagerImpl implements UserAttemptsManager {

	@Autowired
	UserAttemptsRepository uar;

	@Autowired
	ServiceFriendsRepository uer;

	@Override
	public void insertAttempts(String username) {
		uar.save(new UserAttemptEntity(username, 1, new Date()));

	}

	@Override
	public void updateAttempts(String username) {
		uar.updateAttempts(username);
	}

	@Override
	public void lockUser(String username) {
		uer.updateLocked(username, false);
	}

	@Override
	public void resetAttempts(String username) {
		uer.updateLocked(username, true);
		uar.resetAttempts(username);
	}

	@Override
	public UserAttemptEntity geAttemptsEntity(String name) {
		return uar.findByUsername(name);
	}

	@Override
	public boolean isExists(String name) {
		if(uar.countAttempts(name)==1)
		return true;
		else return false;
	}

	@Override
	public boolean isTimeUp(Date d) {
		Calendar timeLocked = Calendar.getInstance();
		timeLocked.setTime(d);
		timeLocked.add(Calendar.MINUTE, 10);
		Calendar currentTime = Calendar.getInstance();
		currentTime.setTime(new Date());
		if (currentTime.getTime().after(timeLocked.getTime())){
			return true;
		}
		return false;
	}

}
