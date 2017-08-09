package com.swap.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.swap.model.Meetup;

@ComponentScan("com.swap")
@Repository
public interface MeetupService {
	
	Meetup findByName(String name);
	
	Meetup findById(long id);

	void saveMeetup(Meetup meetup);

	void updateMeetup(Meetup meetup);

	void deleteMeetupById(long id);

	List<Meetup> findAllMeetups();
}
