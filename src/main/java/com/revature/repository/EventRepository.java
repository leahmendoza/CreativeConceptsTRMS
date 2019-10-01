package com.revature.repository;

import java.util.List;
import com.revature.model.Event;

public interface EventRepository {
	List<Event> getAllEvents();
	Event getEventById(int id);
}
