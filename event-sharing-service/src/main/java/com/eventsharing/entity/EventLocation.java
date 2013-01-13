package com.eventsharing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="EVENT_LOCATION")
public class EventLocation {

	@Id
	@Column(name="LOCATION_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer locationID;
	
	@Column(name="NAME")
	private String name;

	public Integer getLocationID() {
		return locationID;
	}

	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
