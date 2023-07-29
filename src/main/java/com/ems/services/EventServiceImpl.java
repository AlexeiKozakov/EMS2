package com.ems.services;

import com.ems.domain.Event;
import com.ems.dto.EventAddDto;
import com.ems.dto.EventDto;
import com.ems.dto.EventUpdateDto;
import com.ems.repository.EventRepo;
import com.ems.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component

public class EventServiceImpl implements EventService{
     private final Mapper mapper;
    private final EventRepo eventRepo;
    @Override
    public List<EventDto> getAllEvents() {

        return mapper.convertToListEventResponseDto(eventRepo.findAll());
    }

    @Override
    public EventDto addEvent(EventAddDto eventAddDto) {
        Event event = mapper.convertToEntity(eventAddDto);
        Event savedEvent = eventRepo.save(event);
        return mapper.convertToEventResponseDto(savedEvent);
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

        Event event =  mapper.convertfromEventUpdateDtoToEntity(eventUpdateDto);
        eventRepo.save(event);




        return true;
    }

}
