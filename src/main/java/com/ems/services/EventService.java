package com.ems.services;

import com.ems.domain.Event;
import com.ems.dto.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventService {
    List<EventDto> getAllEvents();

    public void addEvent(EventAddDto eventAddDto);
    public void deleteEventById(int id);

    public EventDto getEventById(int id);
    public boolean updateEvent(EventUpdateDto event);

    public void addParticipant(ParticipantAddDto participantAddDto);

    public Page<Event> findAllEvents(Pageable pageable);
    List<EventFullResponseDto> getEvents();



}
