package guru.tour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.UserSchedule;
import guru.tour.repository.UserScheduleRepository;


@Service
public class UserScheduleEntityManagerImpl implements UserScheduleEntityManager{
	
	@Autowired
	UserScheduleRepository userScheduleRepository;
	
	@Override
	public void saveUserScheduleEntity(UserSchedule userSchedule) {
		userScheduleRepository.save(userSchedule);
		
	}

		
	

}
