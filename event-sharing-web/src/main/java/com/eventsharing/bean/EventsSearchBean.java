package com.eventsharing.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;


import com.eventsharing.business.dao.EventDao;
import com.eventsharing.business.filter.EventFilter;
import com.eventsharing.entity.Event;

@Model
public class EventsSearchBean {

	private EventFilter filter;
	private List<Event> results;

	@Inject EventDao eventDao; 
	
	public EventsSearchBean() {
		this.filter = new EventFilter();
	}
	
	public EventFilter getFilter() {
		return filter;
	}

	public void setFilter(EventFilter filter) {
		this.filter = filter;
	}
	
	public List<Event> search() {
		this.results = eventDao.findEvents(this.filter);
		return results;
	}

	public List<Event> getResults() {
		return results;
	}

	public void setResults(List<Event> results) {
		this.results = results;
	}
	
	
	
}
