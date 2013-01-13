package com.eventsharing.business.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.eventsharing.business.dao.EventDao;
import com.eventsharing.business.filter.EventFilter;
import com.eventsharing.entity.Event;
import com.eventsharing.entity.EventLocation;

@RunWith(Arquillian.class)
public class EventDaoImplTest {

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addClasses(Event.class, EventLocation.class, EventFilter.class, EventDao.class, EventDaoImpl.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(jar.toString(true));
		return jar;
	}
	
	@Inject
	private EventDao eventDao;
	
	@Test
	public void testRetrieveEvet() {
		System.out.println(eventDao.getClass().getName());
		Event event = eventDao.retrieveEvent(1);
		if (event != null) {
			System.out.println("Event " + event.getEventID() + " :");
			System.out.println(" " + event.getName());
			System.out.println(" at " + event.getEventLocation().getName());
			System.out.println(" on " + event.getDateTime());
		}
	}
	
	@Test 
	public void testListEvents() {
		EventFilter filter = new EventFilter();
		filter.setEventName("night");
		
		List<Event> eventList = eventDao.findEvents(filter);
		
		if (eventList != null) {
			System.out.println("Found " + eventList.size() + " events!");
			for (Event event : eventList) {
				System.out.println("Event " + event.getEventID() + " :");
				System.out.println(" " + event.getName());
				System.out.println(" at " + event.getEventLocation().getName());
				System.out.println(" on " + event.getDateTime());
			}
		}
	}
}
