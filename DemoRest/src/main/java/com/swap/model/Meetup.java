package com.swap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="meetups")
public class Meetup {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=1,message="presenter should not be blank!!")
	private String presenter;
	
	@Size(min=1,message="title should not be blank!!")
	private String title;
	
	@Size(min=1,message="description should not be blank!!")
	private String description;
	
	@Size(min=1,message="guest should not be blank!!")
	private String guest;
	
	@Size(min=1,message="date should not be blank!!")
	private String date;
	
	@Size(min=1,message="starttime should not be blank!!")
	private String starttime;
	
	@Size(min=1,message="endtime should not be blank!!")
	private String endtime;

	public Meetup(long id, String presenter, String title, String description, String guest, String date,
			String starttime, String endtime) {
		super();
		this.id = id;
		this.presenter = presenter;
		this.title = title;
		this.description = description;
		this.guest = guest;
		this.date = date;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPresenter() {
		return presenter;
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Meetup() {
		super();
	}

	@Override
	public String toString() {
		return "Meetup [id=" + id + ", presenter=" + presenter + ", title=" + title + ", description=" + description
				+ ", guest=" + guest + ", date=" + date + ", starttime=" + starttime + ", endtime=" + endtime + "]";
	}

	
}
