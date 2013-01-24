package com.eventsharing.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.xml.stream.EventFilter;

import com.eventsharing.entity.Event;

@Model
public class EventsSearchBean {

	private EventFilter filter;
	private List<Event> results;

	public EventFilter getFilter() {
		return filter;
	}

	public void setFilter(EventFilter filter) {
		this.filter = filter;
	}
	
	
	
}
