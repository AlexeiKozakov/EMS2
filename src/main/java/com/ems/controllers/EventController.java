package com.ems.controllers;

import com.ems.domain.Participant;
import com.ems.dto.EventAddDto;
import com.ems.dto.EventDto;
import com.ems.dto.EventUpdateDto;
import com.ems.dto.ParticipantAddDto;
import com.ems.services.EventService;
import com.ems.services.ParticipantService;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor


public class EventController {
    private final EventService eventService;


    @GetMapping("/events")
    public ModelAndView getEvents() {
        List<EventDto> events = eventService.getAllEvents();
        ModelAndView model = new ModelAndView("events");
        model.addObject("events", events);
        return model;
    }

    @GetMapping("/events/add")
    public String addEvents(Model model) {
        model.addAttribute("event", new EventAddDto("test", "some", 223, "2023-07-25", 50));
        return "addEvent";
    }

    @PostMapping("/events/add")
    public String addEvents(@ModelAttribute("event") EventAddDto eventAddDto) {
        eventService.addEvent(eventAddDto);
        return "redirect:/events";
    }

    @GetMapping("/events/{id}")
    public ModelAndView deleteEvent(@PathVariable("id") Integer id) {
        eventService.deleteEventById(id);
        return new ModelAndView("redirect:/events");
    }


    @GetMapping("/events/view/{id}")
    public ModelAndView openEvent(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView("eventPage");
        model.addObject("event", eventService.getEventById(id));
        return model;
    }

    @GetMapping("/")
    public ModelAndView openHomePage() {
        return new ModelAndView("homepage");
    }


    @GetMapping("/events/update/{id}")
    public ModelAndView openUpdatePage(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView("updateEvent");
        model.addObject("event", eventService.getEventById(id));
        return model;
    }

    @PostMapping("/events/update")
    public String updateEvent(@ModelAttribute("event") EventUpdateDto eventUpdateDto) {
        eventService.updateEvent(eventUpdateDto);

        return "redirect:/events";
    }

    @GetMapping("/events/{id}/participant/add")
    public ModelAndView addParticipant(@PathVariable(name = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("addParticipant");
        ParticipantAddDto dto = new ParticipantAddDto();
        System.out.println(id);
        dto.setEventId(id);
        modelAndView.addObject("participant", dto);
        return modelAndView;
    }

    @PostMapping("/events/participant/add")
    public String addParticipant(@ModelAttribute("participant") ParticipantAddDto participantAddDto) {
        eventService.addParticipant(participantAddDto);

        return "redirect:/events/view/" + participantAddDto.getEventId();
    }


}