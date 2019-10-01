package com.revature.service;

import java.util.List;

import com.revature.model.Event;
import com.revature.repository.EventRepositoryImpl;

public class EventService {
	
	public List<Event> getAllEvents(){
		return new EventRepositoryImpl().getAllEvents();
	}
}
