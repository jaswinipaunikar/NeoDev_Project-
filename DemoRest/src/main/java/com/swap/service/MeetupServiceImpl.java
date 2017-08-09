package com.swap.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swap.dao.MeetupDao;
import com.swap.model.Meetup;

@Transactional
@Repository(value="MeetupService")
public class MeetupServiceImpl implements MeetupService {

	@Autowired
	private MeetupDao meetupDao;
	public Meetup findByName(String name) {
		
		return meetupDao.findByName(name);
	}

	public void saveMeetup(Meetup meetup) {
		
		meetupDao.saveMeetup(meetup);
	}

	public void updateMeetup(Meetup meetup) {
		
		meetupDao.updateMeetup(meetup);
	}

	public void deleteMeetupById(long id) {
		
		meetupDao.deleteMeetupById(id);
	}

	public List<Meetup> findAllMeetups() {
		
		return meetupDao.findAllMeetups();
	}

	public Meetup findById(long id) {
		
		return meetupDao.findById(id);
	}

}
