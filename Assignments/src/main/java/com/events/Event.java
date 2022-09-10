package com.events;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Event {
	private String eventName;
	private String eventType;
	private String organizer;

	public Event() {
		super();
	}

	public Event(String eventName, String eventType, String organizer) {
		super();
		this.eventName = eventName;
		this.eventType = eventType;
		this.organizer = organizer;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", eventType=" + eventType + ", organizer=" + organizer + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventName, eventType, organizer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(eventName, other.eventName) && Objects.equals(eventType, other.eventType)
				&& Objects.equals(organizer, other.organizer);
	}

	public List<Event> filterEvents(List<Event> eventList, String name, int id) {
		if (id == 1) {
			return eventList.stream().filter(event -> event.getEventName().equals(name)).collect(Collectors.toList());
		} else if (id == 2) {
			return eventList.stream().filter(event -> event.getEventType().equals(name)).collect(Collectors.toList());
		} else {
			return eventList.stream().filter(event -> event.getOrganizer().equals(name)).collect(Collectors.toList());
		}

	}

}
