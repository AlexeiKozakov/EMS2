package com.ems.services;

import com.ems.dto.EventAddDto;
import com.ems.dto.EventDto;
import com.ems.dto.EventUpdateDto;
import com.ems.dto.ParticipantAddDto;

import java.util.List;

public interface EventService {
    List<EventDto> getAllEvents();

    public void addEvent(EventAddDto eventAddDto);
    public void deleteEventById(int id);

    public EventDto getEventById(int id);
    public boolean updateEvent(EventUpdateDto event);

    public void addParticipant(ParticipantAddDto participantAddDto);

}
