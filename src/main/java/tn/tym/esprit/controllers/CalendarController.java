package tn.tym.esprit.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.tym.esprit.entities.Calendar;
import tn.tym.esprit.entities.Contract;
import tn.tym.esprit.interfaces.ICalendar;
import tn.tym.esprit.repositories.CalendarBookingRepository;



@RestController
@RequestMapping("/api")
public class CalendarController {
    @Autowired
    CalendarBookingRepository calendarBookingRepositery;
 ICalendar ical;
    @GetMapping("/getCalendarEvents")
    public ResponseEntity<List<Calendar>> getCalendarEvents() {
        List<Calendar> events = calendarBookingRepositery.findAll();
        return ResponseEntity.ok(events);
    }

    @PostMapping("/deleteCalendarEvent")
    public ResponseEntity<String> deleteCalendarEvent(@RequestParam Long eventId) {
    	ical.deleteEventById(eventId);
        return ResponseEntity.ok("Event deleted successfully");
    }
    @PostMapping("/addcala")
    public Calendar addContract(@RequestBody Calendar contract) {
        return calendarBookingRepositery.save(contract);
    }
}
