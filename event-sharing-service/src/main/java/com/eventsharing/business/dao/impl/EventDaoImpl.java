package com.eventsharing.business.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.eventsharing.business.dao.EventDao;
import com.eventsharing.business.filter.EventFilter;
import com.eventsharing.entity.Event;

@Stateless
public class EventDaoImpl implements EventDao {

	
	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	@Override
	public Event retrieveEvent(Integer id) {
		Event event = this.em.find(Event.class, id);
		return event;
	}

	@Override
	public List<Event> findEvents(EventFilter eventFilter) {
		String query = "select e from Event e where 1 = 1 ";
		
		String name = eventFilter.getEventName();
		if (name != null) {
			query += " and e.name like :name";
		}
		
		TypedQuery typedQuery = this.em.createQuery(query, Event.class);
		
		if (name != null) {
			typedQuery.setParameter("name", "%" + eventFilter.getEventName() + "%");
		}
		return typedQuery.getResultList();
	}

}
