package guru.tour.service;

import java.util.Date;

import guru.tour.entity.UserAttemptEntity;

public interface UserAttemptsManager {
	public void insertAttempts(String username);
	public void updateAttempts(String username);
	public void lockUser(String username);
	public void resetAttempts(String username);
	public UserAttemptEntity geAttemptsEntity(String name);
	public boolean isExists(String name);
	public boolean isTimeUp(Date d);
}
