package com.ems.services;

import com.ems.domain.Event;
import com.ems.domain.Participant;
import com.ems.dto.*;
import com.ems.exceptions.CreateException;
import com.ems.repository.EventRepo;
import com.ems.repository.ParticipantRepo;
import com.ems.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@Component

public class EventServiceImpl implements EventService {
    private final Mapper mapper;
    private final EventRepo eventRepo;
    private final ParticipantRepo participantRepo;

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepo.findAll();
        return mapper.convertToListEventResponseDto(events);
    }

    @Override
    public void addEvent(EventAddDto eventAddDto) {
        Event event = mapper.convertToEntity(eventAddDto);
        try {
            eventRepo.save(event);
        } catch (Exception e) {
            throw new CreateException(e);
        }
    }

    @Override
    public void deleteEventById(int id) {
        eventRepo.deleteById(id);
    }

    @Override
    public EventDto getEventById(int id) {
        Event selected = eventRepo.getById(id);
        return mapper.convertToEventResponseDto(selected);
    }

    @Override
    public boolean updateEvent(EventUpdateDto eventUpdateDto) {
        Event event = mapper.convertfromEventUpdateDtoToEntity(eventUpdateDto);
        eventRepo.save(event);
        return true;
    }

    @Override
    public void addParticipant(ParticipantAddDto participantAddDto) {
        Participant participant = new Participant();
        participant.setMail(participantAddDto.getMail());
        participant.setName(participantAddDto.getName());
        participant.setPhone(participantAddDto.getPhone());
        participant.setPerformingTime(participantAddDto.getPerformingTime());
        participant.setCreated(LocalDateTime.now());
        participant.setUpdated(LocalDateTime.now());

        participant = participantRepo.save(participant);

        Event event = eventRepo.getReferenceById(participantAddDto.getEventId());
        event.getParticipants().add(participant);
        eventRepo.save(event);
    }

    @Override
    public Page<Event> findAllEvents(Pageable pageable) {
        return eventRepo.findAll(pageable);
    }

   public List<EventFullResponseDto> getEvents(){
        List<Event> events = eventRepo.findAll();
        return mapper.convertToListEventFullResponseDto(events);
    }
}
