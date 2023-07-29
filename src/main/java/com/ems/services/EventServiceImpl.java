package com.ems.services;

import com.ems.domain.Event;
import com.ems.domain.Participant;
import com.ems.dto.EventAddDto;
import com.ems.dto.EventDto;
import com.ems.dto.EventUpdateDto;
import com.ems.dto.ParticipantAddDto;
import com.ems.repository.EventRepo;
import com.ems.repository.ParticipantRepo;
import com.ems.utils.Mapper;
import lombok.AllArgsConstructor;
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
        return mapper.convertToListEventResponseDto(eventRepo.findAll());
    }

    @Override
    public void addEvent(EventAddDto eventAddDto) {
        Event event = mapper.convertToEntity(eventAddDto);
        eventRepo.save(event);
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
        participant.setCreated(LocalDateTime.now());
        participant.setUpdated(LocalDateTime.now());

        participant = participantRepo.save(participant);

        Event event = eventRepo.getReferenceById(participantAddDto.getEventId());
        event.getParticipants().add(participant);
        eventRepo.save(event);
    }
}
