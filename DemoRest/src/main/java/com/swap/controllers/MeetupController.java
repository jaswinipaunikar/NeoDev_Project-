package com.swap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swap.model.Meetup;
import com.swap.service.MeetupService;


@org.springframework.web.bind.annotation.RestController
public class MeetupController {
	
	@Autowired
	private MeetupService meetupService;
	
		//Add a Meetup
		@RequestMapping(value="/addMeetup", method=RequestMethod.POST,headers="Accept=application/json")
		public void addMeetup(@RequestBody Meetup meetup)
		{			
				meetupService.saveMeetup(meetup);
				System.out.println("Meetup Successfully Inserted");	
		}
		
		//Update Meetup
		@RequestMapping(value="/updateMeetup/{id}",method=RequestMethod.PUT,headers="Accept=application/json")
		public void updateMeetup(@PathVariable("id")long id,@RequestBody Meetup meetup)
		{
			Meetup meetupObj=meetupService.findById(id);
			if(meetupObj==null)
				System.out.println("meetup not found to update");
			else{
				meetupObj.setPresenter(meetup.getPresenter());
				meetupObj.setTitle(meetup.getTitle());
				meetupObj.setDate(meetup.getDate());
				meetupObj.setDescription(meetup.getDescription());
				meetupObj.setStarttime(meetup.getStarttime());
				meetupObj.setEndtime(meetup.getEndtime());
				meetupObj.setGuest(meetup.getGuest());
				
				meetupService.updateMeetup(meetupObj);
				System.out.println("Meetup Successfully Updated");
			}
		}
		
		//Delete Meetup
		@RequestMapping(value="/deleteMeetup/{id}",method=RequestMethod.DELETE,headers="Accept=application/json")
		public void deleteMeetup(@PathVariable("id")long id)
		{
			Meetup meetup=meetupService.findById(id);
			if(meetup==null)
				System.out.println("Customer Not Present to delete");
			else
			meetupService.deleteMeetupById(id);
			System.out.println("Meetup with id "+id+" is deleted");
		}
		
		//Get All Meetups
		@RequestMapping(value = "/getMeetups", method = RequestMethod.GET, headers = "Accept=application/json")  
		public @ResponseBody List<Meetup> listAllMeetups()
		{
			List<Meetup> meetupList=meetupService.findAllMeetups();
			if(meetupList.isEmpty())
			{
				System.out.println("List Empty");
				return null;
			}
			else{
				return meetupList;
			}
			
		}
		//Get Single Meetup By Name
		@RequestMapping(value="/getMeetup/{name}",method=RequestMethod.GET,headers="Accept=application/json")
		public @ResponseBody Meetup getMeetup(@PathVariable("name") String name){
			Meetup meetup= meetupService.findByName(name);
			if(meetup==null)
			{
				System.out.println("Meetup Not Found");
				return null;
			}
			else
			{
				return meetupService.findByName(name);
			}
			
		}
		
		//Get Single Meetup By id
				@RequestMapping(value="/getMeetupById/{id}",method=RequestMethod.GET,headers="Accept=application/json")
				public @ResponseBody Meetup getMeetupById(@PathVariable("id") long id){
					Meetup meetup= meetupService.findById(id);
					if(meetup==null)
					{
						System.out.println("Meetup Not Found");
						return null;
					}
					else
					{
						return meetupService.findById(id);
					}
					
				}
	
}
