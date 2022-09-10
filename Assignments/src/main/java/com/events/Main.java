package com.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		List<Event> event = new ArrayList<>();
		Event even = new Event();
		
		
		String lines;
		String[] split;

		System.out.println("Enter the number of Events:");
		int data = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter event details");

		for (int i = 0; i < data; i++) {

			lines = scan.nextLine();
			split = lines.split(",");
			//filterEvents = even.filterEvents(event,lines,data);

			event.add(new Event(split[0], split[1], split[2]));
			
			
			
		}
		System.out.println(" Filter:\n" + "1.Using Event name\n" + "2.Using Event type\n" + "3.Using Organizer name\n" + "Enter Your choice:");
		int choice = scan.nextInt();
		

		switch (choice) {
		case 1:
			System.out.println("Enter Your Value:");
			String val = scan.next();
			event.stream().filter(event1 -> event1.getEventName().equalsIgnoreCase(val))
			.forEach(event1 -> System.out.println(event1.getEventName() + "|" + event1.getEventType() + "|" + event1.getOrganizer()));
			break;
		case 2:
			System.out.println("Enter Your Value:");
			String val1 = scan.next();
			event.stream().filter(event1 -> event1.getEventType().equalsIgnoreCase(val1))
			.forEach(event1 -> System.out.println(event1.getEventName() + "|" + event1.getEventType() + "|" + event1.getOrganizer()));
			break;

		case 3:
			System.out.println("Enter Your Value:");
			String val3 = scan.next();
			event.stream().filter(event1 -> event1.getOrganizer().equalsIgnoreCase(val3))
			.forEach(event1 -> System.out.println(event1.getEventName() + "|" + event1.getEventType() + "|" + event1.getOrganizer()));
			break;

		default:
			System.out.println("Invalid Input");
			break;

		}
		scan.close();
	}

}
