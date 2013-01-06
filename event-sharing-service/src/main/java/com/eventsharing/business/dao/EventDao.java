package com.eventsharing.business.dao;

import java.util.List;

import com.eventsharing.business.filter.EventFilter;
import com.eventsharing.entity.Event;

public interface EventDao {

	Event retrieveEvent(Integer id);
	
	List<Event> findEvents(EventFilter eventFilter);
}
