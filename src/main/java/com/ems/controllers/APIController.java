package com.ems.controllers;


import com.ems.dto.EventFullResponseDto;
import com.ems.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/event")

public class APIController {

    @Autowired
    EventService eventService;

    @GetMapping("/all")

    List<EventFullResponseDto> getEvents(){
        return  eventService.getEvents();
    }
}
