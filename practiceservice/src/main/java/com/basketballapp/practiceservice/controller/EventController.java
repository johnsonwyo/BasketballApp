package com.basketballapp.practiceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.basketballapp.practiceservice.model.Event;
import com.basketballapp.practiceservice.service.EventService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "v1/practice/events")
public class EventController {

	@Autowired
	private EventService eventService;

	@RequestMapping(value = "/{eventId}", method = RequestMethod.GET)
	public ResponseEntity<Event> getEvent(@PathVariable("eventId") int eventId) {

		Event event = eventService.getEvent(eventId);

		return ResponseEntity.ok(event);
	}

	@PutMapping
	public ResponseEntity<Event> updateEvent(@PathParam("date") String date, @PathParam("grade") int grade,
			@RequestBody Event request) {
		return ResponseEntity.ok(eventService.updateEvent(request, date, grade));
	}

	@PostMapping
	public ResponseEntity<Event> createEvent(@PathParam("date") String date, @PathParam("grade") int grade,
			@RequestBody Event request) {
		return ResponseEntity.ok(eventService.createEvent(request, date, grade));
	}

	@DeleteMapping(value = "/{eventId}")
	public ResponseEntity<String> deleteEvent(@PathVariable("eventId") int eventId) {
		return ResponseEntity.ok(eventService.deleteEvent(eventId));
	}
}
