package com.ems.controllers;

import com.ems.domain.Event;
import com.ems.domain.Participant;
import com.ems.dto.EventAddDto;
import com.ems.dto.EventDto;
import com.ems.dto.EventUpdateDto;
import com.ems.dto.ParticipantAddDto;
import com.ems.exceptions.CreateException;
import com.ems.services.EventService;
import com.ems.services.ParticipantService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
        if (model.getAttribute("createErrorMessage") == null) {
            model.addAttribute("createErrorMessage", "");
        }

        return "addEvent";
    }

    @PostMapping("/events/add")
    public ModelAndView addEvents(@ModelAttribute("event") EventAddDto eventAddDto) {

        try {
            eventService.addEvent(eventAddDto);
        } catch (CreateException e) {

            ModelAndView modelAndView = new ModelAndView("addEvent");
            modelAndView.addObject("createErrorMessage", "Event with name "+eventAddDto.getName()+" already exists!!");
            return modelAndView;

        }
        return getEvents();
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
    public String addParticipant( @PathVariable(name = "id") Integer id, Model model) {

        ParticipantAddDto dto = new ParticipantAddDto();

        dto.setEventId(id);
        model.addAttribute("participant", dto);
        return "/addParticipant";
    }

    @PostMapping("/events/participant/add")
    public String addParticipant(@Valid @ModelAttribute("participant") ParticipantAddDto participantAddDto,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/addParticipant";
        }

        eventService.addParticipant(participantAddDto);

        return "redirect:/events/view/" + participantAddDto.getEventId();
    }
 @GetMapping
    public String getEvent(@RequestParam(defaultValue = "0") int page,Model model){
     Page<Event> eventPage = eventService.findAllEvents(PageRequest.of(page,5));
     model.addAttribute("event",eventPage.getContent());
     model.addAttribute("currentPage",page);
     return "events";
 }

}